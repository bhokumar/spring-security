package org.spring.security.oauth.domain;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "USER_")
public class User {

	@Id
	@Column(name = "ID")
	private Integer userId;

	@Column(name = "USER_NAME")
	private String userName;

	@Column(name = "PASSWORD")
	private String password;

	@Column(name = "ACCOUNT_EXPIRED")
	private Boolean accountExpired;

	@Column(name = "ACCOUNT_LOCKED")
	private Boolean accountLocked;

	@Column(name = "CREDENTIALS_EXPIRED")
	private Boolean credentialsExpired;

	@Column(name = "ENABLED")
	private Boolean accountEnabled;

	@ManyToMany
	@JoinTable(name = "USERS_AUTHORITIES", joinColumns = @JoinColumn(name = "USER_ID"), inverseJoinColumns = @JoinColumn(name = "AUTHORITY_ID"))
	private Set<Authority> authoritiesToGet;

	public User() {
	}
	
	public User(User user) {
		super();
		this.userId = user.getUserId();
		this.userName = user.getUserName();
		this.password = user.getPassword();
		this.accountExpired = user.getAccountExpired();
		this.accountLocked = user.getAccountLocked();
		this.credentialsExpired = user.getCredentialsExpired();
		this.accountEnabled = user.getAccountEnabled();
		this.authoritiesToGet = user.getAuthoritiesToGet();
	}
	
	public User(Integer userId, String userName, String password, Boolean accountExpired, Boolean accountLocked,
			Boolean credentialsExpired, Boolean accountEnabled, Set<Authority> authoritiesToGet) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.accountExpired = accountExpired;
		this.accountLocked = accountLocked;
		this.credentialsExpired = credentialsExpired;
		this.accountEnabled = accountEnabled;
		this.authoritiesToGet = authoritiesToGet;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getAccountExpired() {
		return accountExpired;
	}

	public void setAccountExpired(Boolean accountExpired) {
		this.accountExpired = accountExpired;
	}

	public Boolean getAccountLocked() {
		return accountLocked;
	}

	public void setAccountLocked(Boolean accountLocked) {
		this.accountLocked = accountLocked;
	}

	public Boolean getCredentialsExpired() {
		return credentialsExpired;
	}

	public void setCredentialsExpired(Boolean credentialsExpired) {
		this.credentialsExpired = credentialsExpired;
	}

	public Boolean getAccountEnabled() {
		return accountEnabled;
	}

	public void setAccountEnabled(Boolean accountEnabled) {
		this.accountEnabled = accountEnabled;
	}

	public Set<Authority> getAuthoritiesToGet() {
		return authoritiesToGet;
	}

	public void setAuthoritiesToGet(Set<Authority> authoritiesToGet) {
		this.authoritiesToGet = authoritiesToGet;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accountEnabled == null) ? 0 : accountEnabled.hashCode());
		result = prime * result + ((accountExpired == null) ? 0 : accountExpired.hashCode());
		result = prime * result + ((accountLocked == null) ? 0 : accountLocked.hashCode());
		result = prime * result + ((credentialsExpired == null) ? 0 : credentialsExpired.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (accountEnabled == null) {
			if (other.accountEnabled != null)
				return false;
		} else if (!accountEnabled.equals(other.accountEnabled))
			return false;
		if (accountExpired == null) {
			if (other.accountExpired != null)
				return false;
		} else if (!accountExpired.equals(other.accountExpired))
			return false;
		if (accountLocked == null) {
			if (other.accountLocked != null)
				return false;
		} else if (!accountLocked.equals(other.accountLocked))
			return false;
		if (credentialsExpired == null) {
			if (other.credentialsExpired != null)
				return false;
		} else if (!credentialsExpired.equals(other.credentialsExpired))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}

}
