<!DOCTYPE html>
<%@page import="edu.jsp.employeetaskmanager.model.EmployeeNotFoundException"%>
<%@page import="edu.jsp.employeetaskmanager.model.Employee"%>
<%@page import="edu.jsp.employeetaskmanager.controller.Controller"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title> Employee</title>
    
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
            max-width: 80%;
            margin: 20px auto;
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

        th {
            background-color: #333;
            color: #fff;
            padding: 10px;
            border-radius: 8px;
        }

        td {
            border: 1px solid #ccc;
            padding: 10px;
            text-align: center;
        }

        button {
            display: inline-block;
            padding: 10px 20px;
            background-color: hotpink;
            color: #fff;
            border: none;
            border-radius: 12px;
            cursor: pointer;
            font-size: 14px;
            text-decoration: none;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
            transition: background-color 0.3s ease, transform 0.3s ease;
        }

        button:hover {
            background-color: violet;
            transform: scale(1.05);
        }

        .error-message {
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
    <h1>Employee Details</h1>
    
               
        <%
            Controller controller = new Controller(); 
       		int id = Integer.valueOf(request.getParameter("empid"));

       		 try {
         			 Employee employee= controller.searchEmployee(id);
         			 
        %>
         <h2>Employee</h2>
        <table>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Age</th>
                <th>Date of Joining</th>
                <th>Salary</th>
                <th>Task Assigned</th>
                <th>Update</th>
            	<th>Delete</th>
            </tr>
        	
        	 <tr>
                <td><%= employee.getId() %></td>
                <td><%= employee.getName() %></td>
                <td><%= employee.getAge() %></td>
                <td><%= employee.getDOJ() %></td>
                <td><%= employee.getSalary() %></td>
                <td><a href="tasks.jsp?empid=<%= employee.getId() %>"><button >Get Task List</button></a></td>
                <td><a href="updateEmployee.jsp?empid=<%= employee.getId() %>"><button>Update</button></a></td>
       		<td><a href="removeEmployee?empid=<%=employee.getId() %>"><button>Delete</button></a></td>
                
             </tr>
               <% }
       		catch (EmployeeNotFoundException e) {
        		// TODO: handle exception
        		
       			response.getWriter().write("<html><body><script>alert('Oops! Error... Please ensure that you entered the correct Employee ID and try again.');"
        				+ "window.location.href='searchEmp.html';</script></body></html>");

        	} 
            
            catch (Exception e) {
            	response.getWriter().write("<html><body><script>alert('Oops! Error... Please ensure that you entered the correct Employee ID and try again.');"
        				+ "window.location.href='searchEmp.html';</script></body></html>");

            }
       		 %>
             </table>
            
   
	</div>
</body>
</html>
