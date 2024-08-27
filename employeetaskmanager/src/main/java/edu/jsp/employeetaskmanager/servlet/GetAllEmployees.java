package edu.jsp.employeetaskmanager.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.jsp.employeetaskmanager.controller.Controller;
import edu.jsp.employeetaskmanager.model.Employee;


@WebServlet("/getAllEmployees")
public class GetAllEmployees extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       
        Controller controller = new Controller();
        List<Employee> employees = controller.getAllEmployee();
       
        req.setAttribute("employees", employees);
     
        RequestDispatcher dispatcher = req.getRequestDispatcher("getAllEmployees.jsp");
        dispatcher.forward(req, resp);
    }

}
