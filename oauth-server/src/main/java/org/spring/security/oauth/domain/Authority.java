package org.spring.security.oauth.domain;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "AUTHORITY")
public class Authority {
	@Id
	@Column(name = "ID")
	private Integer authorityId;
	
	@Column(name= "NAME")
	private String authorityName;
	
	@ManyToMany(mappedBy = "authoritiesToGet")
	private Set<User> users;
	
	public Authority() {
	}

	public Authority(Integer authorityId, String authorityName, Set<User> users) {
		super();
		this.authorityId = authorityId;
		this.authorityName = authorityName;
		this.users = users;
	}

	public String getAuthorityName() {
		return authorityName;
	}

	public void setAuthorityName(String authorityName) {
		this.authorityName = authorityName;
	}
	
	

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public void setAuthorityId(Integer authorityId) {
		this.authorityId = authorityId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((authorityId == null) ? 0 : authorityId.hashCode());
		result = prime * result + ((authorityName == null) ? 0 : authorityName.hashCode());
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
		Authority other = (Authority) obj;
		if (authorityId == null) {
			if (other.authorityId != null)
				return false;
		} else if (!authorityId.equals(other.authorityId))
			return false;
		if (authorityName == null) {
			if (other.authorityName != null)
				return false;
		} else if (!authorityName.equals(other.authorityName))
			return false;
		return true;
	}
}
