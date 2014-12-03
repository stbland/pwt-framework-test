package org.stbland.testpwt.shared.constants;

import fr.putnami.pwt.core.editor.shared.constant.ValidationConstants;

/**
 *
 * @author sbeaufort
 */
public interface UserViewConstants extends ValidationConstants, UserConstants {

    @DefaultStringValue("Save")
    String saveButton();

    @DefaultStringValue("Cancel")
    String cancelButton();

    @DefaultStringValue("Submit")
    String submitButton();

    @DefaultStringValue("Close")
    String closeButton();

    @DefaultStringValue("Open")
    String openButton();

    @DefaultStringValue("Ajouter")
    String addButton();
    
    	@DefaultStringValue("Ajout d'un utilisateur")
String newUserTitle();
}
