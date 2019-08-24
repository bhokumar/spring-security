package org.spring.security.oauth.domain;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomUserDetails extends User implements UserDetails {
	
	private static final long serialVersionUID = -4315492692410357718L;

	public CustomUserDetails(User user) {
		super(user);
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Set<SimpleGrantedAuthority> authorities = new HashSet<>();
		super.getAuthoritiesToGet().forEach(authority -> {
			authorities.add(new SimpleGrantedAuthority("ROLE_"+authority.getAuthorityName()));
		});
		return authorities;
	}

	@Override
	public String getPassword() {
		return super.getPassword();
	}

	@Override
	public String getUsername() {
		return super.getUserName();
	}

	@Override
	public boolean isAccountNonExpired() {
		return super.getAccountExpired();
	}

	@Override
	public boolean isAccountNonLocked() {
		return super.getAccountLocked();
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return super.getCredentialsExpired();
	}

	@Override
	public boolean isEnabled() {
		return super.getAccountEnabled();
	}

}
