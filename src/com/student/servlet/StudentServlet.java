package com.student.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.grade.entity.PageBean;
import com.student.entity.Student;
import com.student.service.StudentServiceImpl;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class StudentServlet
 */
@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	StudentServiceImpl  studentSevice =  new StudentServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String sno = request.getParameter("sno");
		String sname = request.getParameter("sname");
		String ssex = request.getParameter("ssex");
		String birthday = request.getParameter("birthday");
		String gid = request.getParameter("gid");
		
		Student s =  new Student();
		s.setSno(sno);
		s.setSname(sname);
		s.setSsex(ssex);
		try {
			if(birthday!=null && !"".equals(birthday) )
			s.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse(birthday));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if(gid!=null && !"".equals(gid)) {
			s.setGid(Integer.parseInt(gid));
		}
		//--------------------------------
		String page = request.getParameter("page");
		String rows = request.getParameter("rows");
		PageBean pb =  new PageBean();
		pb.setPageIndex(Integer.parseInt(page));
		pb.setPageCount(Integer.parseInt(rows));
		JSONArray arr = studentSevice.queryPage(pb, s);
		int count = studentSevice.queryCount(s);
		JSONObject json =  new JSONObject();
		json.put("rows", arr);
		json.put("total", count);
		response.getWriter().println(json);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
