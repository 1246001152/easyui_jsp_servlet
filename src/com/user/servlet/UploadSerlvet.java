package com.user.servlet;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.user.entity.User;
import com.user.service.UserServiceImpl;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class UploadSerlvet
 */
@WebServlet("/UploadSerlvet")
//使用注解@MultipartConfig将一个Servlet标识为支持文件上传
@MultipartConfig//标识Servlet支持文件上传
public class UploadSerlvet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("UploadSerlvet.doGet()....");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("UploadSerlvet.doPost()....");
		Collection<Part> parts = request.getParts();
		if(parts.size()==1) {
			//Servlet3.0将multipart/form-data的POST请求封装成Part，通过Part对上传的文件进行操作。
            //Part part = parts[0];//从上传的文件集合中获取Part对象
            Part part = request.getPart("file");//通过表单file控件(<input type="file" name="file">)的名字直接获取Part对象
            //Servlet3没有提供直接获取文件名的方法,需要从请求头中解析出来
            //获取请求头，请求头的格式：form-data; name="file"; filename="snmp4j--api.zip"
            String header = part.getHeader("content-disposition");
            System.out.println(header);
            //获取文件名
            String fileName = getFileName(header);
//            //把文件写到指定路径
            String savePath = "D:/files/";
            part.write(savePath+fileName);
            JSONObject obj  = new JSONObject();
            obj.put("code", 0);
            obj.put("url", "http://localhost:8080/file/"+fileName);
            User user = (User)request.getSession().getAttribute("user");
            user.setEmail(fileName);
            new UserServiceImpl().Update(user);
            response.getWriter().println(obj.toString());
		}
		
		doGet(request, response);
	}

	private String getFileName(String header) {
		String[] arrStr = header.split("\"");
//		System.out.println(arrStr[arrStr.length-1]);
		String filename = arrStr[arrStr.length-1];
		String uuid = UUID.randomUUID().toString().replace("-", "");
		if(filename.contains("_") && filename.substring(0, filename.indexOf("_")).length()==32) {
			return filename;
		}
		return uuid+"_"+filename;
	}

}
