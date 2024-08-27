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

@WebServlet("/updateEmployee")
public class UpdateEmployee extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
        	
            int id = Integer.valueOf(req.getParameter("id"));
            String name = req.getParameter("name");
            int age = Integer.valueOf(req.getParameter("age"));
            double salary = Double.valueOf(req.getParameter("salary"));
            
            boolean updateName = req.getParameter("updateName") != null;
            boolean updateAge = req.getParameter("updateAge") != null;
            boolean updateSalary = req.getParameter("updateSalary") != null;

            Controller controller = new Controller();
            Employee employee = controller.searchEmployee(id);

           
            if (updateName ) {
                employee.setName(name);
            }

            if (updateAge ) {
                employee.setAge(age);
            }

            if (updateSalary) {
                employee.setSalary(salary);
            }

           
            employee = controller.updateEmployee(id, name, age, salary);

           
            req.setAttribute("employee", employee);

            
            RequestDispatcher dispatcher = req.getRequestDispatcher("/updateEmployee.jsp");
            dispatcher.forward(req, resp);

            
        } catch (EmployeeNotFoundException e) {
            
        	resp.sendRedirect("employeeNotFound.jsp");
        }
    }

}
