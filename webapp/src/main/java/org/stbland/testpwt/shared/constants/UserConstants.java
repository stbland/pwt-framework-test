package org.stbland.testpwt.shared.constants;

import com.google.gwt.i18n.client.ConstantsWithLookup;
/**
 *
 * @author sbeaufort
 */
public interface  UserConstants extends ConstantsWithLookup {


@DefaultStringValue("Identifiant")
String login();

@DefaultStringValue("Votre identifiant")
String loginPlaceholder();

@DefaultStringValue("Prénom")
String firstname();

@DefaultStringValue("Votre prénom")
String firstnamePlaceholder();

}
