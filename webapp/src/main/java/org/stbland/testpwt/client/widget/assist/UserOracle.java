package org.stbland.testpwt.client.widget.assist;

import com.google.gwt.core.client.Scheduler;
import com.google.gwt.user.client.Timer;
import fr.putnami.pwt.core.widget.client.assist.AsyncOracle;
import fr.putnami.pwt.core.widget.client.assist.MultiWordMatcher;
import fr.putnami.pwt.core.widget.shared.assist.Oracle;
import fr.putnami.pwt.core.widget.shared.assist.SimpleSuggestion;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.stbland.testpwt.shared.domain.User;
import org.stbland.testpwt.shared.repository.UserMemoryRepository;

/**
 *
 * @author stephane
 */
public class UserOracle extends AsyncOracle<User> {

    public UserOracle() {
        super();
        setQueryLengthToRequest(2);
        final UserMatcher matcher = new UserMatcher();        
        setMatcher(matcher);
    }
    
    @Override
protected void addToSuggestion(String query, Collection<SimpleSuggestion<User>> result, User user, int relevance) {

		UserSuggestion suggestion = new UserSuggestion(user, query );
		 if (!result.contains(suggestion)) {
			result.add(suggestion);
		 }
	}    

    @Override
    public void asyncRequest(final Oracle.Request request, final Oracle.Callback<User> callback) {
        
        Timer timer = new Timer() {

            @Override
            public void run() {
                findBeanList(request, callback);
            }
        };
        
        timer.schedule(2 * 1000 /* delayMillis */ );
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
            final Oracle.Callback callback, List<User> beanList) {

        ArrayList<UserSuggestion> result = new ArrayList<UserSuggestion>(beanList.size());
        for (int i = 0; i < beanList.size(); i++) {
            User user = beanList.get(i);
            UserSuggestion suggestion = new UserSuggestion(user, request.getQuery());
            result.add(suggestion);
        }
        Response response = new Response(result);
        callback.onSuggestionsReady(request, response);
    }

}
