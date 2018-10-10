package com.user.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.sun.org.apache.regexp.internal.recompile;
import com.user.dao.JdbcDao;
import com.user.dao.UserDao;
import com.user.entity.User;

public class UserDaoImpl implements UserDao{

	private QueryRunner qr  = new QueryRunner();
	
	@Override
	public User queryByUsername(String username) {
		Connection con  = JdbcDao.getConnection();
		String sql ="select * from user where username=?";
		try {
			User user = qr.query(con,sql, new BeanHandler<>(User.class), username);
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public User queryByLogin(String username, String password) {
		Connection con  = JdbcDao.getConnection();
		String sql ="select * from user where username=? and password =?";
		User user=null;
		try {
			user = qr.query(con, sql, new BeanHandler<>(User.class), username,password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public int Update(User user) {
		Connection con  = JdbcDao.getConnection();
		String sql ="update user set Email= ?  where username=? ";
		try {
			int i = qr.update(con, sql,user.getEmail(),user.getUsername());
			return i;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
