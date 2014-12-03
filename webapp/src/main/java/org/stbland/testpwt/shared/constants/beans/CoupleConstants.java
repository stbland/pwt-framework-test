package org.stbland.testpwt.shared.constants.beans;

import com.google.gwt.i18n.client.ConstantsWithLookup;
import fr.putnami.pwt.core.editor.shared.constant.ValidationConstants;

/**
 *
 * @author sbeaufort
 */
public interface CoupleConstants extends ConstantsWithLookup, ValidationConstants {

    @DefaultStringValue("Utilisateur 1")
    String user1();

    @DefaultStringValue("Utilisateur 2")
    String user2();

}
