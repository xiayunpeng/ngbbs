package com.icss.bbs.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.bbs.service.MessageService;

/**
 * 删除功能接口
 */
@WebServlet("/DeleteMsgServlet")
public class DeleteMsgServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("id");

		MessageService service = new MessageService();

		try {
			service.delete(Integer.parseInt(id));
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}
	}

}