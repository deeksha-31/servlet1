<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="edu.jsp.employeetaskmanager.model.Employee"%>
<%@page import="edu.jsp.employeetaskmanager.controller.Controller"%>
<%@page import="edu.jsp.employeetaskmanager.model.EmployeeNotFoundException"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update Employee</title>
    <style>
   
    /* Navbar */
	.navbar {
	    background-color: rgba(0, 0, 0, 0.7); 
	    padding: 10px;
	    text-align: center;
	}

	.navbar a {
	    color: white;
	    text-decoration: none;
	    font-size: 20px;
	    padding: 8px 20px;
	    border-radius: 20px;
	    transition: background-color 0.3s ease;
	}
	
	.navbar a:hover {
	    background-color: violet;
	}
	
	/* Container */
	.container {
	    max-width: 600px;
	    margin: 50px auto;
	    padding: 20px;
	    background-color: rgba(255, 255, 255, 0.8);
	    border-radius: 20px;
	    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
	    text-align: center;
	}
	
	/* Form */
	form {
	    display: flex;
	    flex-direction: column;
	    align-items: center;
	}
	
	label {
	    font-size: 18px;
	    margin-bottom: 5px;
	}
	
	input[type="text"],
	input[type="number"],
	input[type="checkbox"] {
	    padding: 10px;
	    margin-bottom: 15px;
	    width: 80%;
	    border: 2px solid #ddd;
	    border-radius: 10px;
	    box-sizing: border-box;
	}
	
	input[type="checkbox"] {
	    width: auto;
	    margin-right: 10px;
	}
	
	button[type="submit"] {
	    background-color: hotpink;
	    color: white;
	    border: none;
	    padding: 10px 20px;
	    border-radius: 20px;
	    cursor: pointer;
	    transition: background-color 0.3s ease, transform 0.3s ease;
	}
	
	button[type="submit"]:hover {
	    background-color: violet;
	    transform: scale(1.1);
	}
	    
	</style>
</head>
<body>
    <div class="navbar">
        <a href="index.html">Home</a>
    </div>
    <div class="container">
        <h1>Update Employee</h1>
        
        <%
            try {
                Controller controller = new Controller();
                int id = Integer.valueOf(request.getParameter("empid"));
                Employee employee = controller.searchEmployee(id);
        %>

        <form action="updatedEmp.jsp" method="post">
            <input type="hidden" name="empid" value="<%= employee.getId() %>">

            <label for="name">Name:</label>
            <input type="checkbox" id="updateName" name="updateName"> 
            <input type="text" id="name" name="name" value="<%= employee.getName() %>" required><br><br>

            <label for="age">Age:</label>
            <input type="checkbox" id="updateAge" name="updateAge"> 
            <input type="number" id="age" name="age" value="<%= employee.getAge() %>" required><br><br>

            <label for="salary">Salary:</label>
            <input type="checkbox" id="updateSalary" name="updateSalary"> 
            <input type="number" id="salary" name="salary" value="<%= employee.getSalary() %>" required><br><br>

            <button type="submit">Update Employee</button>
        </form>

        <%
            } catch (EmployeeNotFoundException e) {
                response.getWriter().write("<html><body><script>alert('Employee not found. Please try again.');"
                        + "window.location.href='getAllEmployees.jsp';</script></body></html>");
            } catch (Exception e) {
                response.getWriter().write("<html><body><script>alert('Error occurred. Please try again.');"
                        + "window.location.href='getAllEmployees.jsp';</script></body></html>");
            }
        %>

    </div>
</body>
</html>
