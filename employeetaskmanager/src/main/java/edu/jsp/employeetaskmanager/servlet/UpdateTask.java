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

@WebServlet("/updateTask")
public class UpdateTask extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			int id = Integer.valueOf(req.getParameter("id"));
			String name = req.getParameter("name");
			
			String deadlineStr = req.getParameter("deadline");       
			System.out.println("deadline : " + deadlineStr );
			LocalDate deadline = LocalDate.parse(deadlineStr );
			
			boolean updateName=req.getParameter("updateName") !=null;
			boolean updateDeadline=req.getParameter("updateDeadline") !=null;
			
			Controller controller = new Controller(); 
			
			Task task=controller.searchTask(id);
			
			
			if(updateName) {
				task.setName(name);
			}
			if(updateDeadline) {
				task.setDeadline(deadline);
			}
			
			task=controller.updateTask(id, name, deadline);
			req.setAttribute("taskId", task.getTaskid());
			RequestDispatcher dispatcher=req.getRequestDispatcher("/updateTask.jsp");
			dispatcher.forward(req, resp);

		}
		catch (TaskNotFoundException e) {
			resp.sendRedirect("taskNotFound.jsp"); 
		}
	}
}
