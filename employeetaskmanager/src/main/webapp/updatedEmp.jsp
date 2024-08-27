<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="edu.jsp.employeetaskmanager.model.Employee"%>
<%@page import="edu.jsp.employeetaskmanager.controller.Controller"%>
<%@page import="edu.jsp.employeetaskmanager.model.EmployeeNotFoundException"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Employee</title>
    <style>
        /* Navbar */
        .navbar {
            background-color: rgba(0, 0, 0, 0.7);
            overflow: hidden;
            padding: 10px;
            text-align: center;
        }

        .navbar a {
            display: inline-block;
            color: #fff;
            text-align: center;
            padding: 10px 20px;
            text-decoration: none;
            font-size: 18px;
            font-weight: bold;
            border-radius: 4px;
            transition: background-color 0.3s ease;
        }

        .navbar a:hover {
            background-color: rgba(255, 255, 255, 0.2);
            color: #ffeb3b;
        }

        /* Container */
        .container {
            max-width: 600px;
            margin: 100px auto;
            padding: 20px;
            background-color: rgba(255, 255, 255, 0.8);
            border-radius: 12px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
            text-align: center;
        }

        .message {
            color: red;
            font-weight: bold;
            font-size: 18px;
            margin-bottom: 20px;
        }
        .back-button {
            display: inline-block;
            padding: 10px 20px;
            background-color: hotpink;
            color: #fff;
            border: none;
            border-radius: 12px;
            cursor: pointer;
            font-size: 16px;
            text-decoration: none;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
            transition: background-color 0.3s ease, transform 0.3s ease;
        }

        .back-button:hover {
            background-color: violet;
            transform: scale(1.05);
        }
    </style>
</head>
<body>
    <div class="navbar">
        <a href="index.html">Home</a>
    </div>
    <div class="container">
        <%
            try {
                int empId = Integer.valueOf(request.getParameter("empid"));
                String name = request.getParameter("name");
                int age = Integer.valueOf(request.getParameter("age"));
                double salary = Double.parseDouble(request.getParameter("salary"));

                boolean updateName = request.getParameter("updateName") != null;
                boolean updateAge = request.getParameter("updateAge") != null;
                boolean updateSalary = request.getParameter("updateSalary") != null;

                Controller controller = new Controller();
                Employee employee = controller.searchEmployee(empId);

                if (updateName) {
                    employee.setName(name);
                }

                if (updateAge) {
                    employee.setAge(age);
                }

                if (updateSalary) {
                    employee.setSalary(salary);
                }

                employee = controller.updateEmployee(empId, name, age, salary);

                request.setAttribute("updatedEmployee", employee);

                response.sendRedirect("getAllEmployees.jsp");

            } catch (EmployeeNotFoundException e) {
                %>
                <div class="message">Employee not found. Please try again.</div>
                <a href="getAllEmployees.jsp" class="back-button">Go Back</a>
                <%
            } catch (Exception e) {
                %>
                <div class="message">Error occurred. Please try again.</div>
                <a href="getAllEmployees.jsp" class="back-button">Go Back</a>
                <%
            }
        %>
    </div>
</body>
</html>
