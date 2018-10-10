package com.grade.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.grade.entity.Grade;
import com.grade.service.GradeService;
import com.grade.service.impl.GradeServiceImpl;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class GradeAddServlet
 */
@WebServlet("/GradeAddServlet")
public class GradeAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	GradeService gService =new  GradeServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String name = request.getParameter("name");
		String biz = request.getParameter("biz");
		System.out.println(name+"====="+biz);
		Grade grade = new Grade(name, biz);
		int i = gService.addGrade(grade);
		JSONObject obj =  new JSONObject();
		if(i>0) {
			obj.put("success", true);
			obj.put("msg", "添加成功");
		}else {
			obj.put("success", false);
			obj.put("msg", "添加失败");
		}
		response.getWriter().println(obj);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
