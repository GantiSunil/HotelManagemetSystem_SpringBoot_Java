package com.sunil.security;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.sunil.model.UsersInfo;

public class UserDetailsMapper implements UserDetails{

	private String usernAme;
	
	private String password;
	
	private List<GrantedAuthority> grantedAuth;
	
	
	public UserDetailsMapper() {}
	
	public UserDetailsMapper(UsersInfo usersInfo) {
		
		this.usernAme = usersInfo.getUserName();
		
		this.password = usersInfo.getPassword();
		
		this.grantedAuth = Arrays.stream(usersInfo.getRoles().split(","))
				.map(SimpleGrantedAuthority::new).collect(Collectors.toList());
		
	}
	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return grantedAuth;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return usernAme;
	}
	
	
	

}
