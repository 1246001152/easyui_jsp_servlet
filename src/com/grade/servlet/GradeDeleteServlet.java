package com.grade.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.grade.service.GradeService;
import com.grade.service.impl.GradeServiceImpl;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class GradeDeleteServlet
 */
@WebServlet("/GradeDeleteServlet")
public class GradeDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	GradeService gService  = new GradeServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String ids = request.getParameter("ids");
		int i = gService.deleteByIds(ids);
		JSONObject obj = new JSONObject();
		if(i>0) {
			obj.put("count", i);
			obj.put("msg", "删除成功");
		}else {
			obj.put("msg", "删除失败或已删除");
		}
		response.getWriter().print(obj);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
