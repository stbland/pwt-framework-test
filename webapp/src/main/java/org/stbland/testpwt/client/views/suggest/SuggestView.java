package org.stbland.testpwt.client.views.suggest;

import com.google.common.collect.Lists;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;

import org.stbland.testpwt.client.widget.assist.UserOracle;
import org.stbland.testpwt.client.widget.assist.UserRenderer;
import org.stbland.testpwt.shared.domain.User;

import fr.putnami.pwt.core.inject.client.annotation.PostConstruct;
import fr.putnami.pwt.core.inject.client.annotation.Templated;
import fr.putnami.pwt.core.mvp.client.View;
import fr.putnami.pwt.core.mvp.client.ViewPlace;
import fr.putnami.pwt.core.mvp.client.annotation.ActivityDescription;
import fr.putnami.pwt.core.widget.client.InputSuggest;

/**
 *
 * @author stephane
 */
@Templated
public class SuggestView extends Composite implements View {
	@ActivityDescription(view = SuggestView.class)
	public static class SuggestPlace extends ViewPlace {
	}

	@UiField
	InputSuggest<String> remoteInputSuggest;
	@UiField
	InputSuggest<User> asyncInputSuggest;

	@PostConstruct
	void postConstruct() {
		remoteInputSuggest.setSuggestions(
			Lists.newArrayList("muette", "terminée", "mines"));

		asyncInputSuggest.setRenderer(UserRenderer.get());
		asyncInputSuggest.setHighlighter(UserRenderer.get());
		asyncInputSuggest.setOracle(new UserOracle());
	}

}
