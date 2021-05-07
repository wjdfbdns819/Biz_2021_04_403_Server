package com.callor.hello.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/product/*")
public class ProductController extends HttpServlet {

	// 입력처리를 위한 처음 화면 보여주기
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getRequestDispatcher("/WEB-INF/views/product.jsp")
			.forward(req, resp);
		
	}

	// 데이터를 받아서 처리하고, 결과 보여주기
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 전송되는 데이터를 문자열로 
		String num1 = req.getParameter("num1");
		String num2 = req.getParameter("num2");
		
		// 결과를 문자열
		String result = "%d + %d = %d";
		try {
			Integer intNum1 = Integer.valueOf(num1);
			Integer intNum2 = Integer.valueOf(num2);
			Integer sum = intNum1 + intNum2;
			result = 
					String.format(result, intNum1, intNum2, sum);
		} catch (Exception e) {
			// TODO: 오류발생
			result = "숫자로만 입력하세요";
		}
		// result 값(숫자로만 입력하세요) 을 RESULT에 담음
		req.setAttribute("RESULT", result);
		
		// 다시 product.jsp로 랜더링 해서 보냄 
		req.getRequestDispatcher("/WEB-INF/views/product.jsp")
			.forward(req, resp);
	}
	
}
