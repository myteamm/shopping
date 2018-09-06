package com.shopping.dao;

import java.util.List;

import com.shopping.model.Order;

public interface IOrderDao {
	
	public int addOrder(Order order);
	
	public List<Order> listByUserName(String userName);
	
	public List<Order> listAll();

}
