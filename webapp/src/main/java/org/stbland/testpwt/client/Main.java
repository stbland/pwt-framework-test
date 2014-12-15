package org.stbland.testpwt.client;

import org.stbland.testpwt.client.views.PageDecorator;
import org.stbland.testpwt.client.views.suggest.SuggestView;
import org.stbland.testpwt.client.views.tableeditor.TableEditorPlace;
import org.stbland.testpwt.client.views.welcome.WelcomePlace;

import fr.putnami.pwt.core.inject.client.Module;
import fr.putnami.pwt.core.inject.client.annotation.ErrorManagmentDescription;
import fr.putnami.pwt.core.inject.client.annotation.MvpDescription;

@MvpDescription(
	display = PageDecorator.class,
	defaultPlace = WelcomePlace.class,
	activities = {
		WelcomePlace.class,
		SuggestView.SuggestPlace.class,
		TableEditorPlace.class})
@ErrorManagmentDescription
public class Main implements Module {

}
