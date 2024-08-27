package edu.jsp.employeetaskmanager.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.jsp.employeetaskmanager.controller.Controller;
import edu.jsp.employeetaskmanager.model.Employee;
import edu.jsp.employeetaskmanager.model.EmployeeNotFoundException;


@WebServlet("/searchEmployee")
public class SearchEmployee extends HttpServlet{
	
	@Override
	 protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	        int id = Integer.valueOf(req.getParameter("empId"));

	        Controller controller = new Controller();

	        try {
	            Employee employee = controller.searchEmployee(id);

	           
	            req.setAttribute("employeeFound", employee);
	            RequestDispatcher dispatcher = req.getRequestDispatcher("getEmp.jsp");
	            dispatcher.forward(req, resp);
	            
	        } catch (EmployeeNotFoundException e) {
	          
	            resp.sendRedirect("employeeNotFound.jsp"); 
	        }catch (Exception e) {
	            
	            resp.sendRedirect("error.jsp");
	        }
	    }

}
