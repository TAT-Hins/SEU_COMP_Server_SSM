package com.seu.cose.seu_comp.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.seu.cose.seu_comp.entity.UserEntity;

@Service
public interface IUserService {
	
	// Get Method
	public List<UserEntity> getUsers();
	public UserEntity getUserByID(Integer userID);
	public UserEntity getUserByCardID(String userCardID);
	public UserEntity getUserByPhoneNum(String userMobile);
	public List<UserEntity> getUserByNickname(String userNickname);
	
	//Validation Method
	public Boolean loginByUserCardID(String cardID, String password);
	public Boolean loginByUserPhoneNum(String mobile, String password);
	public Boolean isAdminUser(String queryHeader);
	
	// Modify Method
	public Boolean registryNewUser(UserEntity newUser);
	public void unRegistryUser(UserEntity user);
	public void freezeUser(UserEntity user);
	public void editUserInfo(UserEntity user);
	
}
