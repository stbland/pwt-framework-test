package org.stbland.testpwt.client.views.welcome;

import fr.putnami.pwt.core.mvp.client.ViewPlace;
import fr.putnami.pwt.core.mvp.client.annotation.ActivityDescription;

/**
 * Classe WelcomePlace
 *
 * @author stbland
 */
@ActivityDescription(view = WelcomeView.class)
public class WelcomePlace extends ViewPlace {

    public static final WelcomePlace INSTANCE = new WelcomePlace();

}
