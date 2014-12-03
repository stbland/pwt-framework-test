package org.stbland.testpwt.client.views.suggest;

import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import fr.putnami.pwt.core.inject.client.annotation.PresentHandler;
import fr.putnami.pwt.core.inject.client.annotation.Templated;
import fr.putnami.pwt.core.mvp.client.View;
import fr.putnami.pwt.core.widget.client.InputSuggest;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author stephane
 */
@Templated
public class SuggestView extends Composite implements View {

    @UiField
    InputSuggest remoteInputSuggest;

    @PresentHandler
    void present(SuggestPlace place) {
        Collection<String> suggestions = new ArrayList<String>(3);
        suggestions.add("muette");
        suggestions.add("terminée");
        suggestions.add("mines");

        remoteInputSuggest.setSuggestions(suggestions);
    }

}
