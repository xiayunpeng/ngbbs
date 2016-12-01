package com.icss.bbs.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.bbs.pojo.Message;
import com.icss.bbs.service.MessageService;

/**
 * Servlet插入数据的后台接口
 */
@WebServlet("/InsertMessageServlet")
public class InsertMessageServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		//设置请求和响应编码
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		//获得请求参数
		String username = request.getParameter("username");
		String content = request.getParameter("content");
		
		//封装pojo对象
		Message msg = new Message(username,content,new Date(),request.getRemoteAddr(),0);
		
		//插入数据
		MessageService service = new MessageService();
		
		try {
			service.insert(msg);
			out.write("评论发表成功！");
		} catch (Exception e) {			
			e.printStackTrace();
		}
		
		//模拟网络延迟
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}