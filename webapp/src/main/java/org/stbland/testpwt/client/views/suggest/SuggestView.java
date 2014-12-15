package org.stbland.testpwt.client.views.suggest;

import com.google.common.collect.Lists;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;

import org.stbland.testpwt.client.constants.views.SuggestViewConstants;
import org.stbland.testpwt.client.presenters.CouplePresenter;
import org.stbland.testpwt.client.views.suggest.impl.CoupleModalViewImpl;
import org.stbland.testpwt.client.widget.assist.UserOracle;
import org.stbland.testpwt.client.widget.assist.UserRenderer;
import org.stbland.testpwt.shared.constants.beans.CoupleConstants;
import org.stbland.testpwt.shared.domain.Couple;
import org.stbland.testpwt.shared.domain.User;

import fr.putnami.pwt.core.inject.client.annotation.Initialize;
import fr.putnami.pwt.core.inject.client.annotation.InjectResource;
import fr.putnami.pwt.core.inject.client.annotation.PostConstruct;
import fr.putnami.pwt.core.inject.client.annotation.Templated;
import fr.putnami.pwt.core.mvp.client.View;
import fr.putnami.pwt.core.mvp.client.ViewPlace;
import fr.putnami.pwt.core.mvp.client.annotation.ActivityDescription;
import fr.putnami.pwt.core.widget.client.Form;
import fr.putnami.pwt.core.widget.client.InputSuggest;
import fr.putnami.pwt.core.widget.client.event.ButtonEvent;

/**
 *
 * @author stephane
 */
@Templated
public class SuggestView extends Composite implements View, CouplePresenter {

	@ActivityDescription(view = SuggestView.class)
	public static class SuggestPlace extends ViewPlace {
	}

	@UiField(provided = true)
	@InjectResource
	SuggestViewConstants constants;

	@UiField
	InputSuggest<String> remoteInputSuggest;
	@UiField
	InputSuggest<User> asyncInputSuggest;

	@UiField
	@Initialize(constantsClass = CoupleConstants.class)
	Form<Couple> coupleEditor;

	@InjectResource
	CoupleModalViewImpl coupleModalView;

	@PostConstruct
	void postConstruct() {
		remoteInputSuggest.setSuggestions(
			Lists.newArrayList("muette", "terminée", "mines"));

		asyncInputSuggest.setRenderer(UserRenderer.get());
		asyncInputSuggest.setHighlighter(UserRenderer.get());
		asyncInputSuggest.setOracle(new UserOracle());
	}

	@UiHandler("chooseCoupleButton")
	protected void onChooseCoupleButtonEvent(ButtonEvent event) {
		coupleModalView.show();
	}

	@Override
	public void setCouple(Couple couple) {
		coupleEditor.edit(couple);
	}

}
