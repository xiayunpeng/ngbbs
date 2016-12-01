package com.icss.bbs.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.icss.bbs.pojo.Message;
import com.icss.bbs.service.MessageService;

/**
 * 查询单条数据功能接口
 */
@WebServlet("/GetMsgServlet")
public class GetMsgServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// 设置请求和响应编码
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		PrintWriter out = response.getWriter();

		String id = request.getParameter("id");

		MessageService service = new MessageService();

		try {
			Message msg = service.get(Integer.parseInt(id));

			Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss")
					.create();
			
			out.write(gson.toJson(msg));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
