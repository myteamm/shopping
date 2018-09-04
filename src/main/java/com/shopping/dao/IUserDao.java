package com.shopping.dao;

import com.shopping.model.User;

public interface IUserDao {
	
	public String getUser(String userName);
	
	public User login(User user);
	
	public void register(User user);
	
}
