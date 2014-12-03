package org.stbland.testpwt.client.views.suggest;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import fr.putnami.pwt.core.inject.client.annotation.Initialize;
import fr.putnami.pwt.core.inject.client.annotation.PresentHandler;
import fr.putnami.pwt.core.inject.client.annotation.Templated;
import fr.putnami.pwt.core.mvp.client.View;
import fr.putnami.pwt.core.widget.client.Form;
import fr.putnami.pwt.core.widget.client.InputSuggest;
import fr.putnami.pwt.core.widget.client.event.ButtonEvent;
import java.util.ArrayList;
import java.util.Collection;
import org.stbland.testpwt.client.constants.views.SuggestViewConstants;
import org.stbland.testpwt.client.presenters.CouplePresenter;
import org.stbland.testpwt.client.views.suggest.impl.CoupleModalViewImpl;
import org.stbland.testpwt.shared.constants.beans.CoupleConstants;
import org.stbland.testpwt.shared.domain.Couple;

/**
 *
 * @author stephane
 */
@Templated
public class SuggestView extends Composite implements View, CouplePresenter {

    @UiField
    InputSuggest remoteInputSuggest;

    @UiField(provided = true)
    protected final SuggestViewConstants constants = GWT
            .create(SuggestViewConstants.class);

    @UiField
    @Initialize(constantsClass = CoupleConstants.class)
    Form<Couple> coupleEditor;

    private CoupleModalView coupleModalView;

    @PresentHandler
    void present(SuggestPlace place) {
        Collection<String> suggestions = new ArrayList<String>(3);
        suggestions.add("muette");
        suggestions.add("terminée");
        suggestions.add("mines");

        remoteInputSuggest.setSuggestions(suggestions);
    }

    protected CoupleModalView getCoupleModalView() {
        if (coupleModalView == null) {
            coupleModalView = GWT.create(CoupleModalViewImpl.class);
            coupleModalView.setCouplePresenter(this);
        }
        return coupleModalView;
    }

    @UiHandler("chooseCoupleButton")
    protected void onChooseCoupleButtonEvent(ButtonEvent event) {
        getCoupleModalView().show();
    }

    @Override
    public void setCouple(Couple couple) {
        coupleEditor.edit(couple);
    }

}
