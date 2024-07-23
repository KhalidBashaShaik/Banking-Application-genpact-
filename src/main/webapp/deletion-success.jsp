<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Deletion Successful</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            text-align: center;
            margin-top: 50px;
            background: linear-gradient(90deg, #a6a6a6, #ffffff);
            background-image: url('images/bank_image.jpg');
             background-size: cover; /* Cover the entire background */
            background-position: center; /* Center the background image */
            background-repeat: no-repeat;
            background-attachment: fixed;
        }
        .container {
            width: 60%;
            margin: 0 auto; /* Center the container */
            background-color: white;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); /* Optional: Adds a shadow */
            }
        .success-message {
            color: green;
            font-size: 1.2em;
            margin-bottom: 20px;
        }
        .account-details {
            margin-top: 20px;
            font-size: 1.1em;
            color: #000000;
        }
        .redirect-link {
            color: #007bff;
            text-decoration: none;
            font-weight: bold;
        }
        .redirect-link {
            display: inline-block;
            margin-top: 20px;
            color: #007bff;
            text-decoration: none;
            font-weight: bold;
            padding: 10px 20px;
            border: 2px solid #007bff;
            border-radius: 5px;
            transition: all 0.3s ease;
        }
        .redirect-link:hover {
            background-color: #007bff;
            color: white;
        }
    </style>
</head>
<body>
<div class="container">
     <h2 class="success-message">Account deletion successful!</h2> 
        <div class="account-details">
        <p>Your account has been deleted.</p>
        </div>
        <a href="adminHome.jsp" class="redirect-link">Go back to Home</a>
    </div>
    
    
</body>
</html>
