package com.callor.db.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
// 자동으로 만듦
/**
 * Servlet 
 * Java를 이용한 WAS(Web Application Service) 구현에서
 *  Controller 클래스를 부르는 별칭
 *  
 * Servlet의 path를 / 로만 설정한 Controller는 
 *  localhost:8080/db/ URL의 요청에 응답한다
 *  rootPath 요청이라고도 한다
 *  rootPath 요청은 Run On Server로 실행했을 때
 *  자동으로 호출되는 효과가 있다
 */
@WebServlet("/")
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath()); // Print를 사용하지 않고 직접 사용하는 방법
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
