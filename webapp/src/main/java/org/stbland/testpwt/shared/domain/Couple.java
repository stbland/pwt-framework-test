package org.stbland.testpwt.shared.domain;

import java.io.Serializable;
import javax.validation.constraints.NotNull;

/**
 * Classe Couple
 *
 * @author stephane
 */
public class Couple implements Serializable {

    @NotNull
    private User user1;
    
    @NotNull
    private User user2;

    public Couple() {
        super();
    }

    public Couple(User user1, User user2) {
        super();

        this.user1 = user1;
        this.user2 = user2;
    }

    @Override
    public String toString() {
        return "(" + (user1 != null ? user1.toString() : "null") + "," + (user2 != null ? user2.toString() : "null") + ")";
    }

    public User getUser1() {
        return user1;
    }

    public void setUser1(User user1) {
        this.user1 = user1;
    }

    public User getUser2() {
        return user2;
    }

    public void setUser2(User user2) {
        this.user2 = user2;
    }

}
