<%@page import="edu.jsp.employeetaskmanager.model.Task"%>
<%@page import="edu.jsp.employeetaskmanager.controller.Controller"%>
<%@page import="java.time.LocalDate"%>
<%@page import="edu.jsp.employeetaskmanager.model.TaskNotFoundException"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Task</title>
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
                int taskId = Integer.valueOf(request.getParameter("taskId"));
                String name = request.getParameter("name");
                String deadlineStr = request.getParameter("deadline");
                LocalDate deadline = LocalDate.parse(deadlineStr);

                boolean updateName = request.getParameter("updateName") != null;
                boolean updateDeadline = request.getParameter("updateDeadline") != null;

                Controller controller = new Controller();
                Task task = controller.searchTask(taskId);

                if (updateName) {
                    task.setName(name);
                }
                if (updateDeadline) {
                    task.setDeadline(deadline);
                }

                task = controller.updateTask(taskId, name, deadline);
                request.setAttribute("updatedtask", task);
                response.sendRedirect("getAllTasks.jsp");

            } catch (TaskNotFoundException e) {
                %>
                <div class="message">Task not found. Please try again.</div>
                <a href="getAllTasks.jsp" class="back-button">Go Back</a>
                <%
            } catch (Exception e) {
                %>
                <div class="message">Error occurred. Please try again.</div>
                <a href="getAllTasks.jsp" class="back-button">Go Back</a>
                <%
            }
        %>
    </div>
</body>
</html>
