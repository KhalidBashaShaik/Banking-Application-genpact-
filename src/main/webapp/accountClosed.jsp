<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Account Closed</title>
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
       
        .confirmation-message {
            margin-bottom: 20px;
        }
        .button-container {
            margin-top: 20px;
        }
        .button-container button {
            margin: 10px;
            padding: 10px 20px;
            font-size: 16px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        .button-container button:hover {
            background-color: #45a049;
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
    </style>
</head>
<body>
    <div class="container">
        <h2 class="success-message">Account Closed Successfully</h2>
        <p class="confirmation-message">Your account has been closed successfully.</p>
        <div class="button-container">
            <button onclick="location.href='Login.jsp'">Login</button>
        </div>
    </div>
</body>
</html>
