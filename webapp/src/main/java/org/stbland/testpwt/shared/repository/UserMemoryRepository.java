package org.stbland.testpwt.shared.repository;

import com.google.common.collect.Lists;

import org.stbland.testpwt.shared.domain.User;

import java.util.List;

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

	private final List<User> users = Lists.newArrayList(
		new User("Stéphane", "BEAUFORT", "STBEAUFORT"),
		new User("Sabine", "DUBREUIL"),
		new User("Gilles", "PLESSY"),
		new User("Fabien", "BRUNACCI"),
		new User("Odile", "VUILLAUME"),
		new User("Julien", "PARNY"),
		new User("Olivia", "PARNY-BEAUFORT", "OPARNY"),
		new User("Caroline", "THIEBAUD-BEAUFORT", "CTHIEBAUD"),
		new User("Julien", "THIEBAUD"),
		new User("Etan", "THIEBAUD"),
		new User("Tristan", "THIEBAUD"),
		new User("Eliott", "THIEBAUD"),
		new User("Sarah", "PARNY"),
		new User("Lily", "PARNY"),
		new User("Sonia", "BEAUFORT", "SOBEAUFORT"),
		new User("Patrice", "BEAUFORT"),
		new User("Vincent", "VOISIN"),
		new User("Nadège", "BRUNACCI-MICHELET", "NBRUNACCI")
		);

	private UserMemoryRepository() {
	}

	public List<User> getUserList() {
		return Lists.newArrayList(this.users);
	}

}
