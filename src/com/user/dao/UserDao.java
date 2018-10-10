package com.user.dao;

import com.user.entity.User;

public interface UserDao {

	public User queryByUsername(String username);
	
	public User queryByLogin(String username,String password);
	
	public int Update(User user);
	
}
