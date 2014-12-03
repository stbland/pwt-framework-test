/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.stbland.testpwt.client.widget;

import com.google.gwt.user.client.ui.IsWidget;
import fr.putnami.pwt.core.widget.client.InputSuggest;
import org.stbland.testpwt.client.widget.assist.UserRenderer;
import org.stbland.testpwt.client.widget.assist.UserOracle;
import org.stbland.testpwt.shared.domain.User;

/**
 *
 * @author stephane
 */
public class UserInputSuggest extends InputSuggest<User> {

    public UserInputSuggest() {
        super();
        init();
    }

    protected UserInputSuggest(UserInputSuggest source) {
        super(source);
        init();
    }

    private void init() {
        this.setRenderer(UserRenderer.get());
        setOracle(new UserOracle());
    }

    @Override
    public IsWidget cloneWidget() {
        return new UserInputSuggest(this);
    }

}
