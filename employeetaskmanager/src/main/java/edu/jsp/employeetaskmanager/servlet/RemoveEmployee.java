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

@WebServlet("/removeEmployee")
public class RemoveEmployee extends HttpServlet{

	 protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	        int empId = Integer.valueOf(req.getParameter("empid"));

	        Controller controller = new Controller();

	        try {
	            Employee employee = controller.removeEmployee(empId);	          
	            req.setAttribute("employeeRemoved", employee);
	            RequestDispatcher dispatcher = req.getRequestDispatcher("getAllEmployees.jsp");
	            dispatcher.forward(req, resp);
	            
	        } catch (NumberFormatException e) {
	            
	            resp.sendRedirect("employeeNotFound.jsp");
	            
	        }catch (EmployeeNotFoundException e) {
	           
	            resp.sendRedirect("employeeNotFound.jsp"); 
	        }catch(Exception e) {
	        	resp.sendRedirect("error.jsp");
	        }
	    }
	}
