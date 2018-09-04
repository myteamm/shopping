package com.shopping.model;

public interface UserMapper {
	
	public String getUser(String userName);
	
	public User login(User user);
	
	public void register(User user);
}
