package org.stbland.testpwt.client;

import fr.putnami.pwt.core.inject.client.Module;
import fr.putnami.pwt.core.inject.client.annotation.MvpDescription;
import org.stbland.testpwt.client.views.PageDecorator;
import org.stbland.testpwt.client.views.suggest.SuggestPlace;
import org.stbland.testpwt.client.views.tableeditor.TableEditorPlace;
import org.stbland.testpwt.client.views.welcome.WelcomePlace;

@MvpDescription(
        display = PageDecorator.class,
        defaultPlace = WelcomePlace.class,
        activities = {
            WelcomePlace.class,
            SuggestPlace.class,
        TableEditorPlace.class})
public class Main implements Module {

}
