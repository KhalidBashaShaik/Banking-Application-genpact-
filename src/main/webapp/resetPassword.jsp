<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Password Reset</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0; /* Light grey background */
            text-align: center;
            margin-top: 50px;
            background: linear-gradient(90deg, #a6a6a6, #ffffff);
            background-image: url('images/bank_image.jpg');
             background-size: cover; /* Cover the entire background */
            background-position: center; /* Center the background image */
            background-repeat: no-repeat;
            background-attachment: fixed;
        }
        .message-container {
            width: 40%;
            margin: 0 auto;
            background-color: #fff; /* White background for the message */
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        h2 {
            color: #333; /* Dark grey color for headings */
        }
        p {
            margin-bottom: 15px;
            color: #555; /* Medium grey color for text */
        }
        .back-to-login {
            margin-top: 20px;
        }
        .back-to-login a {
            color: #4CAF50; /* Green link color */
            text-decoration: none;
            font-weight: bold;
        }
        .back-to-login a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <div class="message-container">
        <h2>Password Reset Email Sent</h2>
        <p>An email with instructions to reset your password has been sent to your email address.</p>
        <p>Please check your inbox and follow the instructions provided.</p>
        <div class="back-to-login">
            <a href="Login.jsp">Back to Login Page</a>
        </div>
    </div>
</body>
</html>
