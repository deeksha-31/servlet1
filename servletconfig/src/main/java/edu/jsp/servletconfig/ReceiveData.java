package edu.jsp.servletconfig;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ReceiveData extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServletConfig config=getServletConfig();
		String username=config.getInitParameter("username1");
		String password=config.getInitParameter("password1");
		
		resp.getWriter().write("<html><body><h1>username : "+username+ "password : "+password+"</h1></body></html>");

	}
}
