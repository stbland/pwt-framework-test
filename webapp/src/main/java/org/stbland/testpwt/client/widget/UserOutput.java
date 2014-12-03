package org.stbland.testpwt.client.widget;

import com.google.gwt.user.client.ui.IsWidget;

import fr.putnami.pwt.core.widget.client.base.AbstractTextOutput;
import org.stbland.testpwt.client.widget.assist.UserRenderer;
import org.stbland.testpwt.shared.domain.User;

/**
 * Classe UserOutput
 *
 * @author sbeaufort
 *
 */
public final class UserOutput extends AbstractTextOutput<User> {

    public UserOutput() {
        super();
        initRenderer();
    }

    protected UserOutput(UserOutput source) {
        super(source);
        initRenderer();
    }

    @Override
    public IsWidget cloneWidget() {
        return new UserOutput(this);
    }

    private void initRenderer() {
        setRenderer(UserRenderer.get());
    }

}
