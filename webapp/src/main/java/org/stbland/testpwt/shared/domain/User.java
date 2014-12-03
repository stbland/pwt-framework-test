package org.stbland.testpwt.shared.domain;

import com.google.common.base.Objects;

import java.io.Serializable;

/**
 *
 * @author stephane
 */
public class User implements Serializable {

	private String login;
	private String firstname;
	private String lastname;

	public User() {
		super();
	}

	@Override
	public String toString() {
		return login;
	}

	public User(String firstname, String lastname) {
		super();
		this.login = firstname.substring(0, 1).toUpperCase() + lastname.toUpperCase();
		this.firstname = firstname;
		this.lastname = lastname.toUpperCase();
	}

	public User(String firstname, String lastname, String login) {
		super();
		this.login = login.toUpperCase();
		this.firstname = firstname;
		this.lastname = lastname.toUpperCase();
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	/**
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * @param lastname the lastname to set
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(login);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof User) {
			return Objects.equal(login, ((User) obj).login);
		}
		return super.equals(obj);
	}

}
