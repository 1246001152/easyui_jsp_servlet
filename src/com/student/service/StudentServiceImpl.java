package com.student.service;

import java.text.SimpleDateFormat;
import java.util.List;

import com.grade.entity.PageBean;
import com.student.dao.StudentDao;
import com.student.entity.Student;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class StudentServiceImpl {

	
	StudentDao dao  =  new StudentDao();
	public  JSONArray queryPage(PageBean pb,  Student s){
		JSONArray arr =  new JSONArray();
		List<Student> list = dao.queryPage(pb,s);
		for (Student stu : list) {
			JSONObject json  =  new JSONObject();
			json.put("sid", stu.getSid());
			json.put("sno", stu.getSno());
			json.put("sname", stu.getSname());
			json.put("ssex", stu.getSsex());
			json.put("birthday", new SimpleDateFormat("yyyy-MM-dd").format(stu.getBirthday()));
			json.put("email", stu.getEmail());
			json.put("gid", stu.getGid());
			json.put("cname", stu.getCname());
			arr.add(json);
		}
		return arr;
	}
	public int queryCount( Student s) {
		return dao.queryCount(s);
	}
	
	public int deleteByIds(String ids) {
		return dao.deleteByIds(ids);
	}
}
