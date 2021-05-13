package com.callor.html;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/")
public class HomeController extends HttpServlet {

	private static final long serialVersionUID = -4703672503138357323L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//req.getRequestDispatcher("WEB-INF/views/home.jsp").forward(req, resp);
		
		ReqController.found(req, resp, "home");
		
	}


	
}
