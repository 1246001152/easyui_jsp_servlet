package com.grade.dao;

import java.util.List;

import com.grade.entity.Grade;
import com.grade.entity.PageBean;

public interface GradeDao {

	public List<Grade> queryByPage(PageBean pb,String name);
	
	public int queryCount(String name);

	public int deleteByIds(String ids);
	
	public int addGrade(Grade grade);
	
	public int updateGrade(Grade grade);
	
}
