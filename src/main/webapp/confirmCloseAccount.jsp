<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Confirm Close Account</title>
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
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
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
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        .button-container button.yes-button {
            background-color: #4CAF50;
            color: white;
        }
        .button-container button.yes-button:hover {
            background-color: #45a049;
        }
        .button-container button.cancel-button {
            background-color: #dc3545; /* Red background */
            color: white;
        }
        .button-container button.cancel-button:hover {
            background-color: #c82333; /* Darker red on hover */
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Confirm Account Closure</h2>
        <p class="confirmation-message">Are you sure you want to close your account?</p>
        <div class="button-container">
            <form action="CloseAccountServlet" method="post">
                <button type="submit" class="yes-button">Yes, Close Account</button>
            </form>
            <button onclick="location.href='customerHome.jsp'" class="cancel-button">Cancel</button>
        </div>
    </div>
</body>
</html>
