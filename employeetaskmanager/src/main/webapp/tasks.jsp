<%@page import="edu.jsp.employeetaskmanager.model.EmployeeNotFoundException"%>
<%@page import="edu.jsp.employeetaskmanager.model.Task"%>
<%@page import="java.util.List"%>
<%@page import="edu.jsp.employeetaskmanager.model.Employee"%>
<%@page import="edu.jsp.employeetaskmanager.controller.Controller"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Task List</title>
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
            max-width: 800px;
            margin: 50px auto;
            padding: 20px;
            background-color: rgba(255, 255, 255, 0.8);
            border-radius: 12px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
        }

        /* Table */
        table {
            width: 100%;
            border-collapse: collapse;
        }

        th, td {
            padding: 10px;
            border: 1px solid #ccc;
            text-align: center;
        }

        th {
            background-color: #333;
            color: #fff;
        }

        td {
            background-color: #f9f9f9;
        }

        /* Buttons */
        button {
            display: flex;
            align-items: center;
            justify-content: center;
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

        button:hover {
            background-color: violet;
            transform: scale(1.05);
        }

        /* Error Message*/
        p {
            color: red;
            font-weight: bold;
            text-align: center;
        }
    </style>

</head>
<body>
<div class="navbar">
 		 <a href="index.html">Home</a>
	</div>
 <div class="container">
    <h2>Task List</h2>
    <table >
        <tr>
            <th>Task ID</th>
            <th>Task Name</th>
            <th>Start Date</th>
            <th>End Date</th>
            <th>Update</th>
            <th>Delete</th>
            
        </tr>
        <%
	        int id = 0;
	        String empId = request.getParameter("empid");
	        if (empId != null && !empId.isEmpty()) {
	        	id = Integer.parseInt(empId);
	        }
	
	        Controller controller = new Controller();
			try{
	        Employee employee = controller.searchEmployee(id);
	        List<Task> tasks = employee.getTasks();
	
	        for (Task task : tasks) {
        %>
        <tr>
            <td><%= task.getTaskid() %></td>
            <td><%= task.getName()%></td>
            <td><%= task.getStartDate() %></td>
            <td><%= task.getDeadline()%></td>
            <td><a href="updateTask.jsp?taskId=<%= task.getTaskid()%>"><button>Update</button></a></td>
       		<td><a href="removeTask?taskId=<%=task.getTaskid()%>"><button>Delete</button></a></td>
                
        </tr>
        <% }	     
                    
                } catch (EmployeeNotFoundException e) {
            %>
            
                <p>Employee Not Found. Please provide existing emp id.<a href="index.html">Go back to Home</a></p>
           
            <%
                }
            %>
    </table>
    </div>
</body>
</html>
