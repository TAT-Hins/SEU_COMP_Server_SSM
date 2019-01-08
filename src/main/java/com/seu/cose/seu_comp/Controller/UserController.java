package com.seu.cose.seu_comp.Controller;

import com.seu.cose.seu_comp.service.IUserService;
import com.seu.cose.seu_comp.entity.UserEntity;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/Users")
public class UserController {
	
	@Resource
	private IUserService ius;
	
	public void setUserService(IUserService service) {
		this.ius = service;
	}
	
	// 用户端登录
	@RequestMapping(value="/clientLogin", method=RequestMethod.POST)
	@ResponseBody
	public Map<String, String> loginToServer(@RequestBody UserEntity user) throws Exception {
		
		Map<String, String> retMap = new HashMap<String, String>();
		Boolean loginResult = false;
		
		String cardID = user.getCardid();
		String mobile = user.getPhonenum();
		String password = user.getPassword();
		
		if ((cardID != null || mobile != null) && password != null) {
			// if user input the cardID as loginHeader
			loginResult = ius.loginByUserCardID(cardID, password);
			if (!loginResult) {
				// if user input the phone number as loginHeader
				loginResult = ius.loginByUserPhoneNum(mobile, password);
			}
		}
		
		retMap.put("result", (loginResult) ? ("true") : ("false"));
		return retMap;
	}
	
	// 用户端登录
		@RequestMapping(value="/clientLogin_Get", method=RequestMethod.GET)
		@ResponseBody
		public Map<String, String> loginToServer_Get(@RequestBody UserEntity user) throws Exception {
			
			Map<String, String> retMap = new HashMap<String, String>();
			Boolean loginResult = false;
			
			String cardID = user.getCardid();
			String mobile = user.getPhonenum();
			String password = user.getPassword();
			
			if ((cardID != null || mobile != null) && password != null) {
				// if user input the cardID as loginHeader
				loginResult = ius.loginByUserCardID(cardID, password);
				if (!loginResult) {
					// if user input the phone number as loginHeader
					loginResult = ius.loginByUserPhoneNum(mobile, password);
				}
			}
			
			retMap.put("result", (loginResult) ? ("true") : ("false"));
			return retMap;
		}
	
	// 用户端注册
	@RequestMapping(value="/clientRegister", method=RequestMethod.POST)
	@ResponseBody
	public Map<String, String> registerNewUser(@RequestBody UserEntity user) {
		Map<String, String> retMap = new HashMap<String, String>();
		
		Boolean result = ius.registryNewUser(user);
		retMap.put("result", (result) ? ("true") : ("false"));
		
		return retMap;
	}
}
