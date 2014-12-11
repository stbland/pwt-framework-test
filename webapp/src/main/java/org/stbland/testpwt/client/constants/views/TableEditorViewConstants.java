package org.stbland.testpwt.client.constants.views;

import org.stbland.testpwt.client.constants.views.base.BaseFormViewConstants;
import org.stbland.testpwt.shared.constants.beans.UserConstants;

/**
 *
 * @author sbeaufort
 */
public interface TableEditorViewConstants extends BaseFormViewConstants, UserConstants {

    @DefaultStringValue("Add some user")
    String newUserTitle();
}
