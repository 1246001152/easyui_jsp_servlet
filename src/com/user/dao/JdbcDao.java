package com.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcDao {

	private static String driverClassName="com.mysql.jdbc.Driver";
	private static String url="jdbc:mysql:///web06?useUnicode=true&charaterEncoding=utf-8";
	private static String user="root";
	private static String password="1234";
	private static Connection con;
	public static Connection getConnection() {
		try {
			Class.forName(driverClassName);
			con = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	
	public static void close(ResultSet rs,PreparedStatement ps) {
		try {
			if (rs != null)
				rs.close();
			if (ps != null) 
				ps.close();
			if (con != null) 
				con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		System.out.println(JdbcDao.getConnection());
		
	}
	
}
