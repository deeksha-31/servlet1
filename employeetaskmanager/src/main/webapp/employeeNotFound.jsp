<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Employee Not Found</title>
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
        <div class="message">
            Oops! Error... Please ensure that you entered the correct Employee ID and try again.
        </div>
        <a href="getAllEmployees.jsp" class="back-button">Go Back</a>
    </div>
    <script>
        alert('Oops! Error... Please ensure that you entered the correct Employee ID and try again.');
        window.location.href = 'getAllEmployees.jsp';
    </script>
</body>
</html>
