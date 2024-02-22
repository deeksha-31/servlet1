package edu.jsp.loadonstartup;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(name="user", urlPatterns = {"/user"}, loadOnStartup = 4)
public class User extends HttpServlet{

	static {
		System.out.println("User is loaded");
		
	}
	public User() {
		System.out.println("User object is created");
	}
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("User is intialised");
	}
}
