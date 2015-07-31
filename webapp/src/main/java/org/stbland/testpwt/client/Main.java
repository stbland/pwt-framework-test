package org.stbland.testpwt.client;

import org.stbland.testpwt.client.views.PageDecorator;
import org.stbland.testpwt.client.views.suggest.SuggestView;
import org.stbland.testpwt.client.views.tableeditor.TableEditorPlace;
import org.stbland.testpwt.client.views.welcome.WelcomePlace;
import org.stbland.testpwt.client.views.treeview.TreeviewPlace;

import fr.putnami.pwt.core.inject.client.Module;
import fr.putnami.pwt.core.inject.client.annotation.MvpDescription;

@MvpDescription(
	display = PageDecorator.class,
	defaultPlace = WelcomePlace.class,
	activities = {
		WelcomePlace.class,
		SuggestView.SuggestPlace.class,
		TableEditorPlace.class,
                TreeviewPlace.class})
public class Main implements Module {

}
