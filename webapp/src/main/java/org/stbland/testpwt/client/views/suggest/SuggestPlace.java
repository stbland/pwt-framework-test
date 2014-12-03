package org.stbland.testpwt.client.views.suggest;

import fr.putnami.pwt.core.mvp.client.ViewPlace;
import fr.putnami.pwt.core.mvp.client.annotation.ActivityDescription;

/**
 * Classe SuggestPlace
 * @author stbland
 */
@ActivityDescription(view = SuggestView.class)
public class SuggestPlace extends ViewPlace {
    
    public static final SuggestPlace INSTANCE = new SuggestPlace();

}

