package edu.jsp.employeetaskmanager.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.jsp.employeetaskmanager.controller.Controller;
import edu.jsp.employeetaskmanager.model.EmployeeNotFoundException;
import edu.jsp.employeetaskmanager.model.Task;
import edu.jsp.employeetaskmanager.model.TaskNotFoundException;

@WebServlet("/assignTask")
public class AssignTask extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int empId = Integer.valueOf(req.getParameter("empId"));
        int taskId = Integer.valueOf(req.getParameter("taskId"));

        Controller controller = new Controller();

        try {
        	
            Task assignedTask = controller.assignTask(empId, taskId);
            req.setAttribute("assignedTask", assignedTask);
            RequestDispatcher dispatcher = req.getRequestDispatcher("getAllEmployees.jsp");
            dispatcher.forward(req, resp);
            
        } catch (EmployeeNotFoundException e) {
	          
            resp.sendRedirect("employeeNotFound.jsp"); 
        }catch (TaskNotFoundException e) {
			resp.sendRedirect("taskNotFound.jsp"); 
		} catch (Exception e) {
            
            resp.sendRedirect("error.jsp");
        }
    }

}
