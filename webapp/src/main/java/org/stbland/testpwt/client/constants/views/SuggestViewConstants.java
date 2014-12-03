package org.stbland.testpwt.client.constants.views;

import org.stbland.testpwt.client.constants.views.base.BaseFormViewConstants;
import org.stbland.testpwt.shared.constants.beans.CoupleConstants;
import org.stbland.testpwt.shared.constants.beans.UserConstants;

/**
 *
 * @author sbeaufort
 */
public interface SuggestViewConstants extends BaseFormViewConstants, UserConstants, CoupleConstants {

    @DefaultStringValue("Choose a couple of user")
    String chooseCoupleButton();
    
}
