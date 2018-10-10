package com.student.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.grade.entity.PageBean;
import com.student.entity.Student;
import com.user.dao.JdbcDao;

public class StudentDao {

	QueryRunner qr  = new QueryRunner();
	
	public List<Student> queryPage(PageBean pb , Student s){
		StringBuffer sql  = new StringBuffer("select s.*, g.name as cname from student s , grade g where s.gid = g.id ");
		List<Object> arr =  new ArrayList<>();
		if(s.getSno()!=null && !"".equals(s.getSno())) {
			sql.append(" and sno = ? ");
			arr.add(s.getSno());
		}
		if(s.getSname()!=null && !"".equals(s.getSname())) {
			sql.append(" and sname like ? ");
			arr.add("%"+s.getSname()+"%");
		}
		if(s.getSsex()!=null && !"".equals(s.getSsex())) {
			sql.append(" and ssex = ? ");
			arr.add(s.getSsex());
		}
		if(s.getBirthday()!=null && !"".equals(s.getBirthday())) {
			sql.append(" and birthday = ? ");
			arr.add(new Date(s.getBirthday().getTime()));
		}
		if(s.getGid()!=-1) {
			sql.append(" and gid = ? ");
			arr.add(s.getGid());
		}
		
		if(pb!=null) {
			sql.append("limit ? , ?");
			arr.add(pb.getIndex());
			arr.add(pb.getPageCount());
		}
		Connection con  = JdbcDao.getConnection();
		List<Student> list=null;
		try {
			list = qr.query(con, sql.toString(), new BeanListHandler<>(Student.class), arr.toArray());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public int queryCount(Student s) {
		Connection conn =  JdbcDao.getConnection();
		StringBuffer sql = new StringBuffer("select count(*) count from student ");
		
		List<Object> arr =  new ArrayList<>();
		if(s.getSno()!=null && !"".equals(s.getSno())) {
			sql.append(" and sno = ? ");
			arr.add(s.getSno());
		}
		if(s.getSname()!=null && !"".equals(s.getSname())) {
			sql.append(" and sname like ? ");
			arr.add("%"+s.getSname()+"%");
		}
		if(s.getSsex()!=null && !"".equals(s.getSsex())) {
			sql.append(" and ssex = ? ");
			arr.add(s.getSsex());
		}
		if(s.getBirthday()!=null && !"".equals(s.getBirthday())) {
			sql.append(" and birthday = ? ");
			arr.add(s.getBirthday());
		}
		if(s.getGid()!=-1) {
			sql.append(" and gid = ? ");
			arr.add(s.getGid());
		}
		try {
			Number count =0;
			if(arr.isEmpty()) {
				count = (Number)qr.query(conn, sql.toString(), new ScalarHandler());
			}else {
			    count = (Number)qr.query(conn, sql.toString().replaceFirst("and", "where"), new ScalarHandler(), arr.toArray());
			}
			int c = count.intValue();
			return c;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int deleteByIds(String ids) {
		Connection conn =  JdbcDao.getConnection();
		String sql ="delete from student where sid in ("+ids+")";
		int i=0;
		try {
			i = qr.update(conn, sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}
}
