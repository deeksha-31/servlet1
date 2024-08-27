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

@WebServlet("/removeTask")
public class RemoveTask extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            
            int taskId = Integer.valueOf(req.getParameter("taskId"));
                 
            Controller controller = new Controller();
                      
            Task removedTask = controller.removeTask(taskId);
                      
            req.setAttribute("removedTask", removedTask);
                      
            RequestDispatcher dispatcher = req.getRequestDispatcher("getAllTasks.jsp");
            dispatcher.forward(req, resp);
        } catch (NumberFormatException e) {
            
            resp.sendRedirect("taskNotFound.jsp");
        } catch (TaskNotFoundException e) {
           
            resp.sendRedirect("taskNotFound.jsp");
        } catch (Exception e) {
           
            resp.sendRedirect("error.jsp");
        }
    }
}
