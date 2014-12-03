package org.stbland.testpwt.client.views.suggest;

<<<<<<< .mine
import com.google.gwt.core.shared.GWT;
=======
import com.google.common.collect.Lists;
>>>>>>> .theirs
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
<<<<<<< .mine
import fr.putnami.pwt.core.inject.client.annotation.Initialize;
import fr.putnami.pwt.core.inject.client.annotation.PresentHandler;




=======

import org.stbland.testpwt.client.widget.assist.UserOracle;
import org.stbland.testpwt.client.widget.assist.UserRenderer;
import org.stbland.testpwt.shared.domain.User;

import fr.putnami.pwt.core.inject.client.annotation.PostConstruct;
>>>>>>> .theirs
import fr.putnami.pwt.core.inject.client.annotation.Templated;
import fr.putnami.pwt.core.mvp.client.View;
<<<<<<< .mine
import fr.putnami.pwt.core.widget.client.Form;

=======
import fr.putnami.pwt.core.mvp.client.ViewPlace;
import fr.putnami.pwt.core.mvp.client.annotation.ActivityDescription;
>>>>>>> .theirs
import fr.putnami.pwt.core.widget.client.InputSuggest;
<<<<<<< .mine
import fr.putnami.pwt.core.widget.client.event.ButtonEvent;
import java.util.ArrayList;
import java.util.Collection;
=======



>>>>>>> .theirs
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

<<<<<<< .mine
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
=======
	@PostConstruct
	void postConstruct() {
		remoteInputSuggest.setSuggestions(
			Lists.newArrayList("muette", "terminée", "mines"));












>>>>>>> .theirs

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
