package com.shopping.dao;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.shopping.model.User;
import com.shopping.model.UserMapper;

@Repository
public class UserDao implements IUserDao {
	
	@Resource
	private SqlSessionTemplate sqlSession;

	public String getUser(String userName) {
		return sqlSession.getMapper(UserMapper.class).getUser(userName);
	}

	public User login(User user) {
		return sqlSession.getMapper(UserMapper.class).login(user);
	}

	public void register(User user) {
		sqlSession.getMapper(UserMapper.class).register(user);
	}

}
