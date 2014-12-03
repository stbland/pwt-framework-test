package org.stbland.testpwt.client.widget.assist;

import com.google.gwt.user.client.Timer;

import org.stbland.testpwt.shared.domain.User;
import org.stbland.testpwt.shared.repository.UserMemoryRepository;

import java.util.ArrayList;
import java.util.List;

import fr.putnami.pwt.core.widget.client.assist.AsyncOracle;
import fr.putnami.pwt.core.widget.shared.assist.Oracle;
import fr.putnami.pwt.core.widget.shared.assist.SimpleSuggestion;

/**
 *
 * @author stephane
 */
public class UserOracle extends AsyncOracle<User> {

	public UserOracle() {
		super();
		setQueryLengthToRequest(2);
		setMatcher(new UserMatcher());
	}

	@Override
	public void asyncRequest(final Oracle.Request request, final Oracle.Callback<User> callback) {

		Timer timer = new Timer() {

			@Override
			public void run() {
				findBeanList(request, callback);
			}
		};

		timer.schedule(2 * 1000 /* delayMillis */);
	}

	protected void findBeanList(Oracle.Request request, Oracle.Callback<User> callback) {

		String query = request.getQuery();
		List<User> userList = new ArrayList<User>(1);
		for (User user : UserMemoryRepository.get().getUserList()) {

			if (user.getLogin().toLowerCase().startsWith(query.toLowerCase())
				|| user.getLastname().toLowerCase().startsWith(query.toLowerCase())) {
				userList.add(user);
			}
		}

		this.requestSuggestionsSuccess(request, callback, userList);
	}

	protected void requestSuggestionsSuccess(final Request request,
		final Oracle.Callback<User> callback, List<User> beanList) {

		List<Suggestion<User>> result = new ArrayList<Suggestion<User>>(beanList.size());
		for (int i = 0; i < beanList.size(); i++) {
			User user = beanList.get(i);
			Suggestion<User> suggestion = new SimpleSuggestion<User>(user, 10);
			result.add(suggestion);
		}
		Response<User> response = new Response<User>(result);
		callback.onSuggestionsReady(request, response);
	}

}
