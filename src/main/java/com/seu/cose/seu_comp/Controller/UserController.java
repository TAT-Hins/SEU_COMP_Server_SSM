package com.seu.cose.seu_comp.Controller;

import com.seu.cose.seu_comp.service.IUserService;
import com.seu.cose.seu_comp.entity.UserEntity;
import com.seu.cose.seu_comp.po.UserLoginPo;
import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/UserClient")
public class UserController {
	
	@Resource
	private IUserService ius;
	
	public void setUserService(IUserService service) {
		this.ius = service;
	}
	
	// 用户端登录
	@RequestMapping(value="/login", method=RequestMethod.POST)
	@ResponseBody
	public Map<String, String> loginToServer(@RequestBody UserEntity user, HttpSession session) throws Exception {
		
		Map<String, String> retMap = new HashMap<String, String>();
		Boolean loginResult = false;
		
		String loginHeader = user.getCardid();
		String password = user.getPassword();
		
		if (loginHeader != null) {
			// if user input the cardID as loginHeader
			loginResult = ius.loginByUserCardID(loginHeader, password);
			if (!loginResult) {
				// if user input the phone number as loginHeader
				loginHeader = user.getPhonenum();
				loginResult = ius.loginByUserPhoneNum(loginHeader, password);
			}
		}
		
		retMap.put("result", (loginResult) ? ("true") : ("false"));
		if (loginResult) {
			// 登录成功后将登录信息存储在session中
			session.setAttribute(session.getId(), user);
		}
		return retMap;
	}
	
	// 用户端注册
	@RequestMapping(value="/register", method=RequestMethod.POST)
	@ResponseBody
	public Map<String, String> registerNewUser(@RequestBody UserEntity user, HttpSession session) throws Exception {
		Map<String, String> retMap = new HashMap<String, String>();
		
		Boolean result = ius.registryNewUser(user);
		retMap.put("result", result.toString());
		
		return retMap;
	}
	
	// 获取用户信息
	@RequestMapping(value="/getUserInfo", method=RequestMethod.POST)
	@ResponseBody
	public Map<String, String> getUserInfo(@RequestBody UserEntity user, HttpSession session) throws Exception {
		Map<String, String> retMap = new HashMap<String, String>();
		UserEntity result;
		if (user.getId() == 0) {
			result = ius.getUserByCardID(user.getCardid());
			if (result == null)
				result = ius.getUserByPhoneNum(user.getPhonenum());
		}
		else result = ius.getUserByID(user.getId());
		
		retMap.put("result", (result == null) ? ("false") : ("true"));
		retMap.put("queryResult", JSON.toJSONString(result));
		return retMap;
	}	
}
