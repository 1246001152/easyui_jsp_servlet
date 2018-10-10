package com.user.service;

import com.user.entity.User;

public interface UserService {

	public User queryByUsername(String username);
	
	public User queryByLogin(String username,String password);
	
	public int Update(User user);
}
