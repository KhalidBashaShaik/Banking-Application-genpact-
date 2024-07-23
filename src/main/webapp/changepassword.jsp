<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Change Password</title>
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
        .form-container {
            width: 300px;
            margin: 0 auto;
            background: #f9f9f9;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }
        .form-container input {
            width: calc(100% - 20px);
            padding: 10px;
            margin: 10px 0;
            font-size: 16px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        .form-container button {
            padding: 10px 20px;
            font-size: 16px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        .form-container button:hover {
            background-color: #45a049;
        }
        .form-container p.error-msg {
            color: red;
            margin: 10px 0 0;
            font-size: 14px;
            text-align: left;
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
    <h2>Change Password</h2>
    
    <div class="form-container">
        <form action="ChangePasswordServlet" method="post">
            <% if (request.getParameter("error") != null && request.getParameter("error").equals("emptyFields")) { %>
                <p class="error-msg">Please fill in all fields.</p>
            <% } else if (request.getParameter("error") != null && request.getParameter("error").equals("incorrectPassword")) { %>
                <p class="error-msg">Incorrect current password.</p>
            <% } %>
            
            <label for="currentPassword">Current Password:</label><br>
            <input type="password" id="currentPassword" name="currentPassword" required><br>
            
            <label for="newPassword">New Password:</label><br>
            <input type="password" id="newPassword" name="newPassword" required><br>
            
            <label for="confirmPassword">Confirm New Password:</label><br>
            <input type="password" id="confirmPassword" name="confirmPassword" required><br>
            
            <button type="submit">Change Password</button>
            <p><a href="customerHome.jsp" class="redirect-link">Back to Home</a></p>
        </form>
    </div>
    
</body>
</html>
