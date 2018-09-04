package com.shopping.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shopping.model.User;
import com.shopping.service.UserService;

@Controller
public class UserController {
	
	@Resource
	private UserService userService;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public String login(User user) {
		return userService.login(user);
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	@ResponseBody
	public String register(User user) {
		return userService.register(user);
	}
	
	@RequestMapping(value = "/checkUserName", method = RequestMethod.GET)
	@ResponseBody
	public String checkName(String userName) {
		return userService.checkUserName(userName);
	}

}
