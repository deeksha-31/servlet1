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
import edu.jsp.employeetaskmanager.model.Employee;
import edu.jsp.employeetaskmanager.model.EmployeeNotFoundException;

@WebServlet("/addEmployee")
public class AddEmployee  extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        int age = Integer.valueOf(req.getParameter("age"));
        double salary = Double.valueOf(req.getParameter("salary")); 
        
        Controller controller = new Controller();
        Employee employee = new Employee();
        employee.setName(name);
        employee.setAge(age);
        
        String dojString = req.getParameter("doj");       
        System.out.println("dojString: " + dojString);
        LocalDate doj = LocalDate.parse(dojString);
        employee.setDOJ(doj);
        employee.setSalary(salary);
        
        try {
            Employee addedEmployee = controller.addEmployee(employee);

            
            req.setAttribute("addedEmployee", addedEmployee);
            RequestDispatcher dispatcher = req.getRequestDispatcher("getAllEmployees.jsp");
            dispatcher.forward(req, resp);
        } catch (EmployeeNotFoundException e) {
	          
            resp.sendRedirect("employeeNotFound.jsp"); 
        } catch (Exception e) {
            
            resp.sendRedirect("error.jsp"); 
        }
    }

}
