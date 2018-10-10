package com.user.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.user.entity.User;
import com.user.service.UserService;
import com.user.service.UserServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserService uservice =  new UserServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("LoginServlet.doGet....");
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		if(user==null) {
			// 重定向  发出的信息，不能访问， 转向这个页面
//			response.sendRedirect(request.getContextPath()+"/WEB-INF/login.jsp");
			request.setAttribute("msg", "你没有登录，请登录后访问！");
			request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("LoginServlet.doPost....");
		// 有就使用，没有就创建
		HttpSession session = request.getSession();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User user = uservice.queryByLogin(username, password);
		if(user!=null) {
			session.setAttribute("user", user);
			
//			request.getRequestDispatcher("/WEB-INF/main.jsp").forward(request, response);
			/**
			 * 重定向： 重新给出新的地址，地址栏执行这个地址    地址栏发生改变    请求域的信息不共享
			 * 转发： 转向一个地址    地址栏不发生改变    请求域的信息共享
			 */
			response.sendRedirect(request.getContextPath()+"/ForwardServlet?method=main.jsp");
		}else {
			request.setAttribute("msg", "用户名和密码不匹配");
			request.setAttribute("username", username);
			request.setAttribute("password", password);
			request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
		}
	}

}
