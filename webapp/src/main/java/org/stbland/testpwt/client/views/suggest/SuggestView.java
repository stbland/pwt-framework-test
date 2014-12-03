package org.stbland.testpwt.client.views.suggest;

import com.google.gwt.core.shared.GWT;

import com.google.common.collect.Lists;

import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;

import fr.putnami.pwt.core.inject.client.annotation.Initialize;

import org.stbland.testpwt.client.widget.assist.UserOracle;
import org.stbland.testpwt.client.widget.assist.UserRenderer;
import org.stbland.testpwt.shared.domain.User;

import fr.putnami.pwt.core.inject.client.annotation.PostConstruct;

import fr.putnami.pwt.core.inject.client.annotation.Templated;
import fr.putnami.pwt.core.mvp.client.View;

import fr.putnami.pwt.core.widget.client.Form;

import fr.putnami.pwt.core.mvp.client.ViewPlace;
import fr.putnami.pwt.core.mvp.client.annotation.ActivityDescription;

import fr.putnami.pwt.core.widget.client.InputSuggest;

import fr.putnami.pwt.core.widget.client.event.ButtonEvent;

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

    @ActivityDescription(view = SuggestView.class)
    public static class SuggestPlace extends ViewPlace {
    }

    @UiField
    InputSuggest<String> remoteInputSuggest;
    @UiField
    InputSuggest<User> asyncInputSuggest;

    @UiField(provided = true)
    protected final SuggestViewConstants constants = GWT
            .create(SuggestViewConstants.class);

    @UiField
    @Initialize(constantsClass = CoupleConstants.class)
    Form<Couple> coupleEditor;

    private CoupleModalView coupleModalView;

    @PostConstruct
    void postConstruct() {
        remoteInputSuggest.setSuggestions(
                Lists.newArrayList("muette", "terminée", "mines"));

        asyncInputSuggest.setRenderer(UserRenderer.get());
        asyncInputSuggest.setHighlighter(UserRenderer.get());
        asyncInputSuggest.setOracle(new UserOracle());
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
