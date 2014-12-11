package org.stbland.testpwt.shared.constants.beans;

import fr.putnami.pwt.core.editor.shared.constant.ValidationConstants;
/**
 *
 * @author sbeaufort
 */
public interface UserConstants extends ValidationConstants {


@DefaultStringValue("Identifiant")
String login();

@DefaultStringValue("Votre identifiant")
String loginPlaceholder();

@DefaultStringValue("Prénom")
String firstname();

@DefaultStringValue("Votre prénom")
String firstnamePlaceholder();

}
