package com.grade.service.impl;

import java.util.List;

import org.junit.Test;

import com.grade.dao.GradeDao;
import com.grade.dao.impl.GradeDaoImpl;
import com.grade.entity.Grade;
import com.grade.entity.PageBean;
import com.grade.service.GradeService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class GradeServiceImpl implements GradeService{

	private GradeDao dao  = new GradeDaoImpl();
	
	@Override
	public JSONArray queryByPage(PageBean pb,String name) {
		List<Grade> list = dao.queryByPage(pb,name);
		return JSONArray.fromObject(list);
	}
	@Override
	public int queryCount(String name) {
		return dao.queryCount(name);
	}
	
	@Override
	public int deleteByIds(String ids) {
		return dao.deleteByIds(ids);
	}
	@Override
	public int addGrade(Grade grade) {
		return dao.addGrade(grade);
	}
	@Override
	public int updateGrade(Grade grade) {
		// TODO Auto-generated method stub
		return dao.updateGrade(grade);
	}
	
	
	
	
	//--------------------------------------------------
	/**
	 * junit 的单元测试
	 */
	@Test
	public void fun() {
		PageBean pb =  new PageBean();
		pb.setPageIndex(1);
		pb.setPageCount(5);
		List<Grade> list = dao.queryByPage(pb,"");
//		System.out.println(list);
		JSONArray arr =  JSONArray.fromObject(list);
		System.out.println(arr);
		
		/**
		 *  json格式  是一种数据格式  {"id":1,"name":"java班","biz":"java班是程序员的天下"} 
		 */
		System.out.println("-----------");
		Grade g = list.get(0);
		System.out.println(JSONObject.fromObject(g));
		JSONObject obj = new JSONObject();
		obj.put("id", 1);
		obj.put("name", "java");
		obj.put("biz", "java班是程序员的天下");
		System.err.println(obj);
	}

}
