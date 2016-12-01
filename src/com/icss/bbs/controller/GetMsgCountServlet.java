package com.icss.bbs.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.icss.bbs.service.MessageService;

/**
 * 评论总数数据接口
 */
@WebServlet("/GetMsgCountServlet")
public class GetMsgCountServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// 设置请求和响应编码
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		PrintWriter out = response.getWriter();

		MessageService service = new MessageService();

		try {
			int count = service.getCount();
			Gson gson = new Gson();

			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("recordCount", count);
			out.write(gson.toJson(map));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}