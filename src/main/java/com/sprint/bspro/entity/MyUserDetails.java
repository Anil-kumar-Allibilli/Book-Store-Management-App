package com.sprint.bspro.entity;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class MyUserDetails implements UserDetails {
	private BookStoreUser user;
	
	public MyUserDetails(BookStoreUser user) {
		super();
		this.user = user;
	}
	public MyUserDetails() {	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		//String authority = user.getRole();
		SimpleGrantedAuthority a = new SimpleGrantedAuthority(user.getUserrole().toString());
		System.out.println("--->> Inside MyUserDetails class :- "+a.getAuthority());
		return Arrays.asList(a);
      
	}
	@Override
	public String getPassword() {
		String password = user.getPassword();
		return password;
	}
	@Override
	public String getUsername() {
		String userid = user.getUsername();
		return userid;
	}

	@Override
	public boolean isAccountNonExpired() {	
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {	
		return true; 
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {	
		return true;	
	}

	
}
