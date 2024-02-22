package edu.jsp.loadonstartup;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class Bank extends HttpServlet{

	static {
		System.out.println("Bank is loaded");
		
	}
	public Bank() {
		System.out.println("Bank object is created");
	}
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("Bank is intialised");
	}
}
