package org.stbland.testpwt.client.views;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;

import fr.putnami.pwt.core.widget.client.OneWidgetPanel;
import fr.putnami.pwt.core.widget.client.binder.UiBinderLocalized;

/**
 *
 * @author stbland
 */
public class PageDecorator extends Composite implements AcceptsOneWidget {

    interface Binder extends UiBinderLocalized<Widget, PageDecorator> {
        Binder BINDER = GWT.create(Binder.class);
    }

    @UiField
    OneWidgetPanel viewContainer;

    public PageDecorator() {
        initWidget(Binder.BINDER.createAndBindUi(this));
    }

    @Override
    public void setWidget(IsWidget w) {
        if (w == null) {
            return;
        }
        viewContainer.setWidget(w);
    }
}
