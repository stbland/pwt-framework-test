package org.stbland.testpwt.client.widget.assist;

import com.google.common.base.Objects;
import fr.putnami.pwt.core.widget.shared.assist.SimpleSuggestion;
import org.stbland.testpwt.shared.domain.User;

/**
 *
 * @author stephane
 */
public class UserSuggestion extends SimpleSuggestion<User> {

    public UserSuggestion(User value, String query) {
        super(value, UserRenderer.get().render(value), UserRenderer.get().renderHighlight(value, query), 10 /* relevance */);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getValue().getLogin());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof UserSuggestion) {
            return Objects.equal(getValue().getLogin(), ((UserSuggestion) obj).getValue().getLogin());
        } else {
            return super.equals(obj);
        }

    }

}
