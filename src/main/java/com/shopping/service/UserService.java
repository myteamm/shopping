package com.shopping.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.shopping.dao.UserDao;
import com.shopping.model.User;

@Service
public class UserService {
	
	private static final String LOGIN_SUCCESS = "login_success";
	private static final String LOGIN_FAIL = "login_fail";
	private static final String REGISTER_SUCCESS = "register_success";
	private static final String USERNAME_ALREADY_EXIST = "username_already_exist";
	private static final String USERNAME_NOT_EXIST = "username_not_exist";
	
	@Resource
	private UserDao userDao;
	
	public String login(User user) {
		if (userDao.login(user) != null) {
			return LOGIN_SUCCESS;
		}
		return LOGIN_FAIL;
	}
	
	public String register(User user) {
		if (userDao.getUser(user.getUserName()) != null) {
			return USERNAME_ALREADY_EXIST;
		}
		userDao.register(user);
		return REGISTER_SUCCESS;
	}
	
	public String checkUserName(String userName) {
		if (userDao.getUser(userName) == null) {
			return USERNAME_NOT_EXIST;
		}
		return USERNAME_ALREADY_EXIST;
	}
	
}
