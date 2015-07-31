package org.stbland.testpwt.client.views.treeview;

import fr.putnami.pwt.core.mvp.client.ViewPlace;
import fr.putnami.pwt.core.mvp.client.annotation.ActivityDescription;

/**
 * Classe TreeviewPlace
 *
 * @author stbland
 */
@ActivityDescription(view = TreeviewView.class)
public class TreeviewPlace extends ViewPlace {

    public static final TreeviewPlace INSTANCE = new TreeviewPlace();

}
