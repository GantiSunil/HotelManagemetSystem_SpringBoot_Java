package com.sunil.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sunil.model.UsersInfo;
import com.sunil.repository.HMSMasterUserInfo;
import com.sunil.service.JwtService;

@Service
public class UserInfoServiceImp implements UserDetailsService{

	@Autowired
	private HMSMasterUserInfo hmsMasterUserInfo;
	
	@Lazy
	@Autowired
	private AuthenticationManager authenticationManager;
	
	//---Jwt
	@Autowired 
	private JwtService jwtService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<UsersInfo> userInfo = hmsMasterUserInfo.findByUserName(username);
				
				
		return  userInfo.map(UserDetailsMapper::new).orElseThrow(()-> new UsernameNotFoundException("Exception"));
	}
	
	
	
	//------------- Jwt
	public String getUserInfo(UsersInfo usersInfo) 
	{
		
		Authentication authentication = authenticationManager.authenticate(
				
				new UsernamePasswordAuthenticationToken(usersInfo.getUserName(), usersInfo.getPassword())
				);
		
		if(authentication.isAuthenticated()) 
		{
			return jwtService.getJwtToken(usersInfo.getUserName());
		}
		else 
		{
			return "Failure";
		}
		
		
	}
	
	

}
