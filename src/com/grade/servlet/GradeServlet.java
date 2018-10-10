package com.grade.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.grade.entity.PageBean;
import com.grade.service.GradeService;
import com.grade.service.impl.GradeServiceImpl;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class GradeServlet
 */
@WebServlet("/GradeServlet")
public class GradeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	GradeService gService  = new GradeServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String page = request.getParameter("page");
		String rows = request.getParameter("rows");
		String name = request.getParameter("name");
		PageBean pb =  new PageBean();
		pb.setPageIndex(Integer.parseInt(page));
		pb.setPageCount(Integer.parseInt(rows));
		JSONArray arr = gService.queryByPage(pb,name);
		int count = gService.queryCount(name);
		JSONObject obj = new JSONObject();
		obj.put("rows", arr);
		obj.put("total", count);
		response.getWriter().println(obj);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
