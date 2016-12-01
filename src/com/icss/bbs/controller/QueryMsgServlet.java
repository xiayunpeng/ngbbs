package com.icss.bbs.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.icss.bbs.common.Pager;
import com.icss.bbs.pojo.Message;
import com.icss.bbs.service.MessageService;

/**
 * 分页查询数据访问接口
 * @author Administrator
 *
 */
@WebServlet("/QueryMsgServlet")
public class QueryMsgServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
				
		// 设置请求和响应编码
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		PrintWriter out = response.getWriter();

		// 获得页码
		String pageNumStr = request.getParameter("pageNum");
		// 获得每页多少条
		String pageSizeStr = request.getParameter("pageSize");

		int pageNum = 1;

		try {
			pageNum = Integer.parseInt(pageNumStr);
		} catch (Exception e) {

		}

		int pageSize = 10;

		try {
			pageSize = Integer.parseInt(pageSizeStr);
		} catch (Exception e) {

		}

		MessageService service = new MessageService();

		try {
			//分页对象
			Pager pager = new Pager(service.getCount(), pageSize, pageNum);
			//本页数据 
			ArrayList<Message> list = service.query(pager);
			
			Gson gson = new GsonBuilder()  
			  .setDateFormat("yyyy-MM-dd HH:mm:ss")  
			  .create();
			
			HashMap<String, Object> map = new HashMap<String,Object>();
			map.put("pager", pager);
			map.put("list", list);
			
			out.write(gson.toJson(map));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//模拟网络延迟
		/*try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}*/

	}

}