<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Check Balance</title>
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
            background-attachment: fixed; /* Light grey background */
        }
        h2 {
            olor: black; /* Set the color to black */
            font-size: 24px; /* Larger font size for heading */
            margin-bottom: 20px;  /* Dark grey text */
        }
        .balance-container {
            display: inline-block;
            padding: 20px;
            border: 1px solid #ddd;
            border-radius: 10px; /* Rounded corners */
            background-color: #fff; /* White background */
            box-shadow: 0 0 10px rgba(0,0,0,0.1); /* Light shadow */
            margin-top: 20px;
        }
        .back-btn {
            background-color: #4CAF50; /* Green background */
            color: white; /* White text */
            padding: 10px 20px; /* Padding around text */
            border: none; /* No border */
            cursor: pointer; /* Cursor style */
            text-decoration: none; /* No underline */
            font-size: 16px; /* Font size */
            margin-top: 10px; /* Top margin */
            display: inline-block;
            border-radius: 5px; /* Rounded corners */
        }
        .back-btn:hover {
            background-color: #45a049; /* Darker green on hover */
        }
    </style>
</head>
<body>
    <h2>Account Balance</h2>
    <div class="balance-container">
        <p><strong>Balance:</strong> <%= session.getAttribute("balance") %></p>
    </div>
    <div class="deposit-form">
        <form action="DepositServlet" method="post">
            <!-- Your deposit form elements can be added here -->
        </form>
    </div>
    <div class="withdrawal-form">
        <form action="WithdrawalServlet" method="post">
            <!-- Your withdrawal form elements can be added here -->
        </form>
    </div>
    <button class="back-btn" onclick="goBack()">Back</button>

    <script>
        function goBack() {
            window.history.back();
        }
    </script>
</body>
</html>
