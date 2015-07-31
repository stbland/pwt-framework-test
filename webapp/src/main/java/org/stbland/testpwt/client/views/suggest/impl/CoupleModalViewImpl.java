package org.stbland.testpwt.client.views.suggest.impl;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

import org.stbland.testpwt.client.constants.views.CoupleModalConstants;
import org.stbland.testpwt.client.presenters.CouplePresenter;
import org.stbland.testpwt.client.views.suggest.CoupleModalView;
import org.stbland.testpwt.client.widget.assist.UserOracle;
import org.stbland.testpwt.client.widget.assist.UserRenderer;
import org.stbland.testpwt.shared.constants.beans.CoupleConstants;
import org.stbland.testpwt.shared.domain.Couple;
import org.stbland.testpwt.shared.domain.User;

import fr.putnami.pwt.core.editor.client.event.FlushErrorEvent;
import fr.putnami.pwt.core.editor.client.event.FlushSuccessEvent;
import fr.putnami.pwt.core.inject.client.annotation.Initialize;
import fr.putnami.pwt.core.inject.client.annotation.InjectResource;
import fr.putnami.pwt.core.inject.client.annotation.PostConstruct;
import fr.putnami.pwt.core.inject.client.annotation.Templated;
import fr.putnami.pwt.core.mvp.client.View;
import fr.putnami.pwt.core.widget.client.Form;
import fr.putnami.pwt.core.widget.client.FormGroup;
import fr.putnami.pwt.core.widget.client.InputSuggest;
import fr.putnami.pwt.core.widget.client.Modal;
import fr.putnami.pwt.core.widget.client.event.ButtonEvent;

/**
 * Classe CoupleModalViewImpl
 *
 * Modal view to choose two users (couple)
 *
 * @author sbeaufort
 */
@Templated
public class CoupleModalViewImpl extends Composite implements View, CoupleModalView {

	private CouplePresenter couplePresenter;

	@UiField(provided = true)
	@InjectResource
	CoupleModalConstants constants;

	@UiField
	protected Modal modal;

	@UiField
	@Initialize(constantsClass = CoupleConstants.class)
	protected Form<Couple> coupleEditor;

	@UiField
	protected FormGroup user1FormGroup;

	@UiField
	protected InputSuggest<User> user1InputSuggest;

	@UiField
	protected InputSuggest<User> user2InputSuggest;

	@PostConstruct
	void postConstruct() {
		user1InputSuggest.setRenderer(UserRenderer.get());
		user1InputSuggest.setHighlighter(UserRenderer.get());
		user1InputSuggest.setOracle(new UserOracle());

		user2InputSuggest.setRenderer(UserRenderer.get());
		user2InputSuggest.setHighlighter(UserRenderer.get());
		user2InputSuggest.setOracle(new UserOracle());
	}

	@Override
	public void show() {

		final Couple couple = new Couple();
		coupleEditor.edit(couple);

		modal.show();
		user1FormGroup.setFocus(true);
	}

	@Override
	public void setCouplePresenter(CouplePresenter couplePresenter) {
		this.couplePresenter = couplePresenter;
	}

	protected void hide() {
		modal.hide();
	}

	@UiHandler("cancelButton")
	public void onCancelButton(ButtonEvent event) {
		hide();
	}

	@UiHandler("coupleEditor")
	void onCoupleEditorFlushSuccess(FlushSuccessEvent event) {
		hide();

		Couple couple = event.getValue();
		GWT.log("onCoupleEditorFlushSuccess value: " + couple.toString());

		if (couplePresenter != null) {
			couplePresenter.setCouple(couple);
		}
	}

	@UiHandler("coupleEditor")
	void onCoupleEditorFlushError(FlushErrorEvent event) {
		GWT.log("onCoupleEditorFlushSuccess valueEdited: " + event.getValueEdited().toString());
		GWT.log("onCoupleEditorFlushSuccess valueFlushed: " + event.getValueFlushed().toString());
	}

	@Override
	public Widget asWidget() {
		return modal;
	}

}
