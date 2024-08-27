<%@page import="edu.jsp.employeetaskmanager.model.TaskNotFoundException"%>
<%@page import="edu.jsp.employeetaskmanager.model.Task"%>
<%@page import="edu.jsp.employeetaskmanager.controller.Controller"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Task Details</title>
    
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
        <h2>Task Details</h2>
        <%
            
                Controller controller = new Controller();
        		int taskId = Integer.valueOf(request.getParameter("taskId"));
        		
                try {
                    Task task = controller.searchTask(taskId);
        %>
                    
                    <table>
                        <tr>
                            <th>Task ID</th>
                            <th>Task Name</th>
                            <th>Start Date</th>
                            <th>Deadline</th>
                            <th>Update</th>
            				<th>Delete</th>
                           
                        </tr>
                        <tr>
                            <td><%= task.getTaskid() %></td>
                            <td><%= task.getName()%></td>
                            <td><%= task.getStartDate() %></td>
                            <td><%= task.getDeadline() %></td>
                            <td><a href="updateTask.jsp?taskId=<%= task.getTaskid()%>"><button>Update</button></a></td>
       						<td><a href="removeTask?taskId=<%=task.getTaskid()%>"><button>Delete</button></a></td>
                           
                        </tr>
                    </table>
        <%
                } catch (TaskNotFoundException e) {
                   
                	response.getWriter().write("<html><body><script>alert('Oops! Error... Please ensure that you entered the correct Task ID and try again.');"
            				+ "window.location.href='searchTask.html';</script></body></html>");

                } catch (Exception e) {
                   
                	response.getWriter().write("<html><body><script>alert('Oops! Error... Please ensure that you entered the correct Task ID and try again.');"
            				+ "window.location.href='searchTask.html';</script></body></html>");

                }
            
        %>
    </div>
</body>
</html>
