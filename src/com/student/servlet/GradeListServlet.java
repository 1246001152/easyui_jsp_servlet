package com.student.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.grade.service.GradeService;
import com.grade.service.impl.GradeServiceImpl;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class GradeListServlet
 */
@WebServlet("/GradeListServlet")
public class GradeListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	   
	GradeService gService  = new GradeServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		JSONArray arr = gService.queryByPage(null, null);
		JSONObject obj = new JSONObject();
		obj.put("id", "");
		obj.put("name", "请选择...");
		arr.add(obj);
		response.getWriter().print(arr);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
