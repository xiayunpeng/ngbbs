package com.icss.bbs.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.bbs.service.MessageService;

/**
 * 点赞功能接口
 */
@WebServlet("/UpdateHitServlet")
public class UpdateHitServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		
		MessageService service = new MessageService();
		
		try {
			service.updateHit(Integer.parseInt(id));
		}  catch (Exception e) {			
			e.printStackTrace();
		}

	}

}