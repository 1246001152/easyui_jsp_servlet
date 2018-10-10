package com.fiter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.user.entity.User;

/**
 * 1. jsp和html 的编码格式是否是一致的出现乱码
 * 2. 数据库的存储 编码问题   mysql 默认是拉丁文
 * 3. 数据库连接编码问题 useUnicode=true&characterEncoding=utf-8
 * 4. 提交方式 get提交乱码，提交方式改为post
 * 5. 使用过滤器防止乱码
 * 
 * @author Administrator
 */
@WebFilter("/*")
public class MyFilter implements Filter {
	/**
	 * 销毁过滤器
	 */
	public void destroy() {

	}

	/**
	 * 过滤
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		String uri = req.getRequestURI();
		if(uri.contains("ForwardServlet")) {
			String method = req.getQueryString();
				if(method.contains("main.jsp")) {
					HttpSession session = req.getSession();
					User user = (User)session.getAttribute("user");
					if(user==null) {
						request.setAttribute("msg", "你没有登录，请登录后访问！");
						request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
					}else {
						// 放行
						chain.doFilter(request, response);
					}
				}else {
					// 放行
					chain.doFilter(request, response);
				}
		}else {
			// 放行
			chain.doFilter(request, response);
		}
	}

	/**
	 * 初始化过滤器
	 */
	public void init(FilterConfig config) throws ServletException {
	
	}

}
