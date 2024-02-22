package edu.jsp.loadonstartup;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(name="car", urlPatterns = {"/car"}, loadOnStartup = 3) 
public class Car extends  HttpServlet{

	static {
		System.out.println("Car is loaded");
		
	}
	public Car() {
		System.out.println("Car object is created");
	}
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("Car is intialised");
	}
}
