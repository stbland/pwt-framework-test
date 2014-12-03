package org.stbland.testpwt.client.widget.assist;

import com.google.gwt.text.shared.AbstractRenderer;
import org.stbland.testpwt.shared.domain.User;

/**
 *
 * @author stephane
 */
public class UserRenderer extends AbstractRenderer<User> {

    protected UserRenderer() {
        super();
    }

    @Override
    public String render(User user) {
        if ( user == null ) {
            return "";
        }
        return user.getFirstname() + " "  +  user.getLastname() + " (" + user.getLogin() + ")";
    }
    
    public String renderHighlight(User user, String query) {
        return user.getFirstname() + ' ' +  renderHighlight ( user.getLastname(), query ) + " (" + renderHighlight(user.getLogin(), query ) + ")";
    }
    
     public String renderHighlight(String text, String query) {
         final String _text = text.toUpperCase();
         final String _query = query.toUpperCase();
         
         if ( _text.startsWith(_query))
         {
             return "<strong>" + text.substring(0, query.length()) + "</strong>" + text.substring(query.length());
         }
                 
         return text;
     }

    public static UserRenderer get() {
        return new UserRenderer();
    }

}
