package com.grade.service;

import com.grade.entity.Grade;
import com.grade.entity.PageBean;

import net.sf.json.JSONArray;

public interface GradeService {

	public JSONArray queryByPage(PageBean pb,String name);
	
	public int queryCount(String name);
	
	public int deleteByIds(String ids);
	
	public int addGrade(Grade grade);
	
	public int updateGrade(Grade grade);
}
