package com.grade.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.grade.dao.GradeDao;
import com.grade.entity.Grade;
import com.grade.entity.PageBean;
import com.sun.org.apache.regexp.internal.recompile;
import com.user.dao.JdbcDao;

public class GradeDaoImpl implements GradeDao {

	private QueryRunner qr =  new QueryRunner();
	@Override
	public List<Grade> queryByPage(PageBean pb ,String name) {
		Connection conn =  JdbcDao.getConnection();
//		String sql ="select * from grade limit ?,? ";
		List<Object>  arr = new ArrayList<>();
		StringBuffer sql = new StringBuffer("select * from grade");
		if (name!=null && !"".equals(name)) {
			sql.append(" and  name like ? ");
			arr.add("%"+name+"%");
		}
		if(pb!=null) {
			sql.append(" limit ? , ? ");
			arr.add(pb.getIndex());
			arr.add(pb.getPageCount());
		}
		try {
			List<Grade> list = qr.query(conn, sql.toString().replaceFirst("and", "where"), new BeanListHandler<>(Grade.class), arr.toArray());
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public int queryCount(String name) {
		Connection conn =  JdbcDao.getConnection();
		StringBuffer sql = new StringBuffer("select count(*) count from grade");
		try {
			Number count=0;
			if (name!=null && !"".equals(name)) {
				sql.append(" and  name like ? ");
				count = (Number)qr.query(conn, sql.toString().replaceFirst("and", "where"), new ScalarHandler(),"%"+name+"%");
			}else {
				count = (Number)qr.query(conn, sql.toString(), new ScalarHandler());
			}
			int c = count.intValue();
			return c;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	@Override
	public int deleteByIds(String ids) {
		Connection conn =  JdbcDao.getConnection();
		String sql ="delete from grade where id in ("+ids+")";
		int i=0;
		try {
			i = qr.update(conn, sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}
	@Override
	public int addGrade(Grade grade) {
		Connection conn =  JdbcDao.getConnection();
		String sql ="insert into grade (name , biz ) values (?,?)";
		int i=0;
		try {
			i = qr.update(conn, sql,grade.getName(),grade.getBiz());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}
	@Override
	public int updateGrade(Grade grade) {
		Connection conn =  JdbcDao.getConnection();
		String sql ="update grade set name= ?, biz = ? where id = ?";
		int i=0;
		try {
			i = qr.update(conn, sql,grade.getName(),grade.getBiz(),grade.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

}
