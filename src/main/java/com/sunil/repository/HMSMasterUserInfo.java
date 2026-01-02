package com.sunil.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunil.model.UsersInfo;

public interface HMSMasterUserInfo extends JpaRepository<UsersInfo,String>{
	
	
	Optional<UsersInfo> findByUserName(String userName);

}
