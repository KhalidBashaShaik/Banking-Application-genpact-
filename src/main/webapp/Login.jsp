<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Your Bank</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            background-image: url('images/bank_image1.jpg'); /* Specify the path to your image */
            background-size: cover; /* Ensure the image covers the entire background */
            background-repeat: no-repeat; /* Prevent the background image from repeating */
            background-attachment: fixed;
             
        }

        .container {
            display: flex;
            width: 80%;
            height: 80%;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            border-radius: 10px;
            overflow: hidden;
            background-color: #ffffff; /* Removed transparency */
        }
        .left, .right {
            display: flex;
            justify-content: center;
            align-items: center;
        }

        .left {
            flex: 1;
            background-color: #49AD8C;
            flex-direction: column;
            text-align: center;
            padding: 20px;
        }

        .left img {
            width: 100%; /* Set width to 100% to fill container */
            max-width: 95%; /* Ensure image doesn't exceed its original size */
            height: auto; /* Maintain aspect ratio */
        }

        .left h3 {
            font-size: 24px;
            color: #333;
            margin-top: 20px;
            text-align: center;
        }

        .right {
            width: 30%; /* Reduced width */
            display: flex;
            justify-content: center;
            align-items: center;
            padding: 40px;
        }

        .login-container {
            width: 100%;
            max-width: 400px;
            text-align: center;
        }

        h2 {
            color: #333333;
        }

        .input-group {
            margin-bottom: 15px;
            text-align: left;
        }

        label {
            display: block;
            font-size: 14px;
            color: #666;
            margin-bottom: 5px;
        }

        input[type="text"],
        input[type="password"],
        select {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-sizing: border-box;
        }

        input[type="submit"] {
            width: 100%;
            padding: 10px;
            background-color: #007bff;
            color: white;
            border: none;
            border-radius: 5px;
            font-size: 16px;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #0056b3;
        }

        .forgot-password {
            margin-top: 10px;
        }

        .forgot-password input[type="submit"] {
            background-color: transparent;
            color: #007bff;
            padding: 0;
            border: none;
            cursor: pointer;
            font-size: 14px;
        }

        .forgot-password input[type="submit"]:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="left">
            <img src="images/2.png" alt="Bank Image">
            
        </div>
        <div class="right">
            <div class="login-container">
                <h2>Welcome</h2>
                <p>Sign into your account.</p>
                <form action="LoginServlet" method="post">
                    <div class="input-group">
                        <label for="role">Role:</label>
                        <select id="role" name="role" required>
                            <option value="" disabled selected>Select your role</option>
                            <option value="customer">Customer</option>
                            <option value="admin">Admin</option>
                        </select>
                    </div>
                    <div class="input-group">
                        <label for="username">Username:</label>
                        <input type="text" id="username" name="username" required>
                    </div>
                    <div class="input-group">
                        <label for="password">Password:</label>
                        <input type="password" id="password" name="password" required>
                    </div>
                    <input type="submit" value="Login">
                </form>
                <form action="ForgotPasswordServlet" method="get" class="forgot-password">
                    <input type="submit" value="Forgot Password">
                </form>
            </div>
        </div>
    </div>
</body>
</html>
