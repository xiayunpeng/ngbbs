package com.icss.bbs.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.icss.bbs.pojo.Admin;
import com.icss.bbs.service.AdminService;

/**
 * 登录接口
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();

//		获得请求参数
		String username = request.getParameter("username");
		String userpwd = request.getParameter("userpwd");
		
		System.out.println("username=" + username);
		System.out.println("userpwd=" + userpwd);
		
//		封装为对象
		Admin admin = new Admin(username,userpwd);
		
//		调用业务对象
		AdminService service = new AdminService();
		
		try {
			int result = service.checkUser(admin);
			
			if (result == 3) {
//				在session中设置登录标识（存储用户名密码）
				HttpSession session = request.getSession();
				session.setAttribute("admin", admin);
			}
			
			out.print(result);
		} catch (Exception e) {			
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
