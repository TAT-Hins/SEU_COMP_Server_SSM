package com.seu.cose.seu_comp.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.seu.cose.seu_comp.entity.UserEntity;
import com.seu.cose.seu_comp.entity.UserEntityExample;
import com.seu.cose.seu_comp.service.IUserService;
import com.seu.cose.seu_comp.dao.UserEntityMapper;

@Service("userService")
public class IUserServiceImpl implements IUserService {

	@Resource
	private UserEntityMapper mapper;
	
	@Override
	public List<UserEntity> getUsers() {
		// TODO Auto-generated method stub
		List<UserEntity> users = mapper.getUsers();
		return users;
	}

	@Override
	public UserEntity getUserByID(Integer userID) {
		// TODO Auto-generated method stub
		return mapper.selectByPrimaryKey(userID);
	}

	@Override
	public UserEntity getUserByCardID(String userCardID) {
		// TODO Auto-generated method stub
		UserEntityExample example = new UserEntityExample();
		example.createCriteria().andCardidEqualTo(userCardID);
		List<UserEntity> result = mapper.selectByExample(example);
		if (!result.isEmpty()) {
			return result.get(0);
		}
		else {
			return null;
		}
	}
	
	@Override
	public UserEntity getUserByPhoneNum(String userMobile) {
		// TODO Auto-generated method stub
		UserEntityExample example = new UserEntityExample();
		example.createCriteria().andPhonenumEqualTo(userMobile);
		List<UserEntity> result = mapper.selectByExample(example);
		if (!result.isEmpty()) {
			return result.get(0);
		}
		else {
			return null;
		}
	}

	@Override
	public List<UserEntity> getUserByNickname(String userNickname) {
		// TODO Auto-generated method stub
		UserEntityExample example = new UserEntityExample();
		example.createCriteria().andNicknameEqualTo(userNickname);
		return mapper.selectByExample(example);
	}

	@Override
	public Boolean loginByUserCardID(String cardID, String password) {
		// TODO Auto-generated method stub
		if (cardID == null || password == null) {
			return false;
		}
		UserEntityExample example = new UserEntityExample();
		// if user input the phone number
		example.or().andCardidEqualTo(cardID).andPasswordEqualTo(password);
		List<UserEntity> user = mapper.selectByExample(example);
		
		if (user.isEmpty()) {
			return false;		//cannot find match user
		}
		
		if (user.get(0).getActivateStatus())
			return true;
		else return false;		//user has been freezed
	}
	
	@Override
	public Boolean loginByUserPhoneNum(String mobile, String password) {
		// TODO Auto-generated method stub
		if (mobile == null || password == null) {
			return false;
		}
		UserEntityExample example = new UserEntityExample();
		// if user input the phone number
		example.or().andPhonenumEqualTo(mobile).andPasswordEqualTo(password);
		List<UserEntity> user = mapper.selectByExample(example);
		
		if (user.isEmpty()) {
			return false;		//cannot find match user
		}
		
		if (user.get(0).getActivateStatus())
			return true;
		else return false;		//user has been freezed
	}

	@Override
	public Boolean isAdminUser(String queryHeader) {
		// TODO Auto-generated method stub
		UserEntityExample example = new UserEntityExample();
		List<UserEntity> users;
		// if user input the phone number
		example.createCriteria().andPhonenumEqualTo(queryHeader);
		users = mapper.selectByExample(example);
		if (!users.isEmpty()) {
			return users.get(0).getAccounttype();
		}
		// if user input the card ID
		example.clear();
		users.clear();
		example.createCriteria().andCardidEqualTo(queryHeader);
		users = mapper.selectByExample(example);
		if (!users.isEmpty())
		{
			return users.get(0).getAccounttype();
		}
		else return null;
	}

	@Override
	public Boolean registryNewUser(UserEntity newUser) {
		// TODO Auto-generated method stub
		// Default attributes set
		newUser.setRegisterdate(new Date());
		newUser.setAccounttype(false);
		newUser.setActivateStatus(true);
		int ret = 0;
		try {
			 ret = mapper.insert(newUser);
		}catch(com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException e) {
			e.printStackTrace();
		}
		return (ret > 0);
	}

	@Override
	public void unRegistryUser(UserEntity user) {
		// TODO Auto-generated method stub
		mapper.deleteByPrimaryKey(user.getId());
	}

	@Override
	public void freezeUser(UserEntity user) {
		// TODO Auto-generated method stub
		user.setActivateStatus(false);
		mapper.updateByPrimaryKeySelective(user);
	}

	@Override
	public void editUserInfo(UserEntity user) {
		// TODO Auto-generated method stub
		if (user.getActivateStatus()) {
			mapper.updateByPrimaryKeySelective(user);
		}
	}

}
