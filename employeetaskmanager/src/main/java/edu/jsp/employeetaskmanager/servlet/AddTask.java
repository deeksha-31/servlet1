package edu.jsp.employeetaskmanager.servlet;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.jsp.employeetaskmanager.controller.Controller;
import edu.jsp.employeetaskmanager.model.Task;
import edu.jsp.employeetaskmanager.model.TaskNotFoundException;

@WebServlet("/addTask")
public class AddTask  extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
		String name = req.getParameter("name");

        Controller controller = new Controller();
        Task task = new Task();
        task.setName(name);

        String startDateStr = req.getParameter("startDate");       
        System.out.println("startDate : " + startDateStr );
        LocalDate  startDate = LocalDate.parse(startDateStr );
        task.setStartDate(startDate);
        
        String deadlineStr = req.getParameter("deadline");       
        System.out.println("deadline : " + deadlineStr );
        LocalDate deadline = LocalDate.parse(deadlineStr );
        task.setDeadline(deadline);
        
        try {
        	
            Task addedTask = controller.addTask(task);
            req.setAttribute("addedTask", addedTask);
            RequestDispatcher dispatcher = req.getRequestDispatcher("getAllTasks.jsp");
            dispatcher.forward(req, resp);
        } catch (TaskNotFoundException e) {
			resp.sendRedirect("taskNotFound.jsp"); 
		}catch (Exception e) {
            
            resp.sendRedirect("error.jsp"); 
        }
    }

}
