package org.stbland.testpwt.client.widget.assist;

import fr.putnami.pwt.core.widget.client.assist.Matcher;
import org.stbland.testpwt.shared.domain.User;

/**
 *
 * @author stephane
 */
public class UserMatcher implements Matcher<User> {

    @Override
    public int match(User value, String query) {
        final String login = value.getLogin().toUpperCase();
        final String lastname = value.getLastname().toUpperCase();
        query = query.toUpperCase();

        if (login.equals(query) || lastname.equals(query)) {
            return 10;
        }
        
        if (login.startsWith(query) || lastname.startsWith(query)) {
            return 9;
        }

        return 0;
    }

}
