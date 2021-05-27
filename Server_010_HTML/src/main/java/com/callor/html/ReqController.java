package com.callor.html;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ReqController {

	public static void found(HttpServletRequest req, HttpServletResponse resp, String title) throws ServletException, IOException  {
		
		title = "/WEB-INF/views/" + title + ".jsp";
		
		req.getRequestDispatcher(title).forward(req, resp);
		
	}
}
