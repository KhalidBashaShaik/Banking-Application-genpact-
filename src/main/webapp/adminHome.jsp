<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta charset="UTF-8">
    <meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate">
    <meta http-equiv="Pragma" content="no-cache">
    <meta http-equiv="Expires" content="0">
    <title>Admin Home</title>
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
            /* Remove any extra margin-top here to ensure alignment */
        }
        .button-container {
            display: flex;
            justify-content: center;
            margin-top: 20px;
        }
        .button-container button {
            margin: 0 10px;
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
        .logout-button {
            position: fixed; /* Fix the position relative to the viewport */
            top: 10px;
            right: 10px;
            padding: 10px 20px;
            font-size: 16px;
            background-color: #f44336; /* Red background for logout button */
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            z-index: 1000; /* Ensure the button stays on top of other elements */
        }
        .logout-button:hover {
            background-color: #d32f2f;
        }
    </style>
</head>
<body>
    <button class="logout-button" onclick="location.href='LogoutServlet'">Logout</button>

    <h2>Welcome, Admin</h2>

    <div class="button-container">
        <button onclick="location.href='CreateAccountServlet'">Create Account</button>
        <button onclick="location.href='DeleteAccountServlet'">Delete Account</button>
        <button onclick="location.href='BankDetailsServlet'">Bank Details</button>
        <button onclick="location.href='EditDetailsServlet'">Edit Details</button>
    </div>
</body>
</html>
