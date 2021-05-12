package com.callor.diet.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/")
public class HomeController extends HttpServlet{

	private static final long serialVersionUID = -953531494441799347L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// WEB-INF에 view 폴더에 있는 home.jps 파일을 열어서 보여달라
		//req.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(req, resp);
		
		ReqController.forward(req, resp, "home");
	}
	
}