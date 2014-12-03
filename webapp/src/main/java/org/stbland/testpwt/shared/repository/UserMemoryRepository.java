package org.stbland.testpwt.shared.repository;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import org.stbland.testpwt.shared.domain.User;

/**
 *
 * @author sbeaufort
 */
public class UserMemoryRepository {

    private static UserMemoryRepository INSTANCE;

    public static UserMemoryRepository get() {
        if (UserMemoryRepository.INSTANCE == null) {
            UserMemoryRepository.INSTANCE = new UserMemoryRepository();
        }
        return UserMemoryRepository.INSTANCE;
    }

    private List<User> USERS;

    private UserMemoryRepository() {
        USERS = new ArrayList<User>(15);
        USERS.add(new User("Stéphane", "BEAUFORT", "STBEAUFORT"));
        USERS.add(new User("Sabine", "DUBREUIL"));
        USERS.add(new User("Gilles", "PLESSY"));
        USERS.add(new User("Fabien", "BRUNACCI"));
        USERS.add(new User("Odile", "VUILLAUME"));
        USERS.add(new User("Julien", "PARNY"));
        USERS.add(new User("Olivia", "PARNY-BEAUFORT", "OPARNY"));
        USERS.add(new User("Caroline", "THIEBAUD-BEAUFORT", "CTHIEBAUD"));
        USERS.add(new User("Julien", "THIEBAUD"));
        USERS.add(new User("Etan", "THIEBAUD"));
        USERS.add(new User("Tristan", "THIEBAUD"));
        USERS.add(new User("Eliott", "THIEBAUD"));
        USERS.add(new User("Sarah", "PARNY"));
        USERS.add(new User("Lily", "PARNY"));
        USERS.add(new User("Sonia", "BEAUFORT", "SOBEAUFORT"));
        USERS.add(new User("Patrice", "BEAUFORT"));
        USERS.add(new User("Vincent", "VOISIN"));
        USERS.add(new User("Nadège","BRUNACCI-MICHELET", "NBRUNACCI"));
    }

    public List<User> getUserList() {
        return Lists.newArrayList(this.USERS);
    }

}
