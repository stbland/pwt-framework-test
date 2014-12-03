package org.stbland.testpwt.client.widget.assist;

import org.stbland.testpwt.shared.domain.User;

import fr.putnami.pwt.core.widget.client.assist.Matcher;

/**
 *
 * @author stephane
 */
public class UserMatcher implements Matcher<User> {

	@Override
	public int match(User value, String query) {
		final String login = value.getLogin().toUpperCase();
		final String lastname = value.getLastname().toUpperCase();
		String _query = query.toUpperCase();

		if (login.equals(_query) || lastname.equals(_query)) {
			return 10;
		}

		if (login.startsWith(_query) || lastname.startsWith(_query)) {
			return 9;
		}

		return 0;
	}

}
