package com.user.service;

import com.user.dao.UserDao;
import com.user.dao.impl.UserDaoImpl;
import com.user.entity.User;

public class UserServiceImpl implements UserService{

	private UserDao dao  =  new UserDaoImpl();
	@Override
	public User queryByUsername(String username) {
		return dao.queryByUsername(username);
	}
	@Override
	public User queryByLogin(String username, String password) {
		return dao.queryByLogin(username, password);
	}
	@Override
	public int Update(User user) {
		// TODO Auto-generated method stub
		return dao.Update(user);
	}

}
