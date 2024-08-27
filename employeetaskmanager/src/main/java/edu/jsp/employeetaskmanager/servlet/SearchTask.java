package edu.jsp.employeetaskmanager.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.jsp.employeetaskmanager.controller.Controller;
import edu.jsp.employeetaskmanager.model.Task;
import edu.jsp.employeetaskmanager.model.TaskNotFoundException;


@WebServlet("/searchTask")
public class SearchTask extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int taskId = Integer.valueOf(request.getParameter("taskId"));

        Controller controller = new Controller();

        try {
            Task task = controller.searchTask(taskId);

           
            request.setAttribute("taskFound", task);
            RequestDispatcher dispatcher = request.getRequestDispatcher("getTask.jsp");
            dispatcher.forward(request, response);
        } catch (TaskNotFoundException e) {
            
            response.sendRedirect("taskNotFound.jsp"); 
        }catch (Exception e) {
           
            response.sendRedirect("error.jsp");
        }
    }

}
