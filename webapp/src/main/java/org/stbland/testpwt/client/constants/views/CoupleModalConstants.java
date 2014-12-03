package org.stbland.testpwt.client.constants.views;

import org.stbland.testpwt.client.constants.views.base.BaseFormViewConstants;
import org.stbland.testpwt.shared.constants.beans.CoupleConstants;

/**
 *
 * @author sbeaufort
 */
public interface CoupleModalConstants extends BaseFormViewConstants, CoupleConstants {

    @DefaultStringValue("Choose a couple of user")
    String dialogTitle();
    
}
