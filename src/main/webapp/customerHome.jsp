<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate">
    <meta http-equiv="Pragma" content="no-cache">
    <meta http-equiv="Expires" content="0">
    <title>Customer Home</title>
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
        .button-container {
            display: flex;
            justify-content: center; /* Center align the flex items */
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
    <h2>Welcome, <%= session.getAttribute("username") %></h2>
    <button class="logout-button" onclick="location.href='LogoutServlet'">Logout</button>
    <div class="button-container">
        <button onclick="location.href='AccountDetailsServlet'">Account Details</button>
        <button onclick="location.href='DepositServlet'">Deposit</button>
        <button onclick="location.href='WithdrawalServlet'">Withdrawal</button>
        <button onclick="location.href='CheckBalanceServlet'">Check Balance</button>
        <button onclick="location.href='ViewTransactionsServlet'">View Transactions</button>
        <button onclick="location.href='ChangePasswordServlet'">Change Password</button>
        <button onclick="location.href='CloseAccountServlet'">Close Account</button> 
    </div>
</body>
</html>
