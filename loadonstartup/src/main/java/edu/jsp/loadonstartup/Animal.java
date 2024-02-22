package edu.jsp.loadonstartup;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class Animal extends HttpServlet {

	static {
		System.out.println("Animal is loaded");
		
	}
	public Animal() {
		System.out.println("Animal object is created");
	}
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("Animal is intialised");
	}
}
