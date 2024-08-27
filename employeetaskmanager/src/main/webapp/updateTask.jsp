<%@page import="edu.jsp.employeetaskmanager.model.TaskNotFoundException"%>
<%@page import="edu.jsp.employeetaskmanager.model.Task"%>
<%@page import="edu.jsp.employeetaskmanager.controller.Controller"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update Task</title>
	    <style>
	    
	    /* Navbar*/
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
	
	/* Container*/
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
	input[type="date"],
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
        <h1>Update Task</h1>
        
        <%
            try {
               Controller controller = new Controller();
                int id = Integer.valueOf(request.getParameter("taskId"));
                Task task=controller.searchTask(id);
        %>

        <form action="updatedTask.jsp" method="post">
            <input type="hidden" name="taskId" value="<%= task.getTaskid() %>">

            <label for="name"> Task Name:</label>
            <input type="checkbox" id="updateName" name="updateName"> 
            <input type="text" id="name" name="name" value="<%= task.getName() %>" required><br><br>

            <label for="deadline">Deadline:</label>
            <input type="checkbox" id="updateDeadline" name="updateDeadline"> 
            <input type="date" id="deadline" name="deadline" value="<%= task.getDeadline() %>" required><br><br>
          
            <button type="submit">Update Task</button>
        </form>

        <%
            } catch (TaskNotFoundException e) {
                response.getWriter().write("<html><body><script>alert('Task not found. Please try again.');"
                        + "window.location.href='getAllTasks.jsp';</script></body></html>");
            } catch (Exception e) {
                response.getWriter().write("<html><body><script>alert('Error occurred. Please try again.');"
                        + "window.location.href='getAllTasks.jsp';</script></body></html>");
            }
        %>

    </div>
</body>
</html>
