package com.callor.todo.commmand;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface TodoCommand {
	
	public void execute(HttpServletRequest req, HttpServletResponse res ) throws ServletException, IOException;

	
}
