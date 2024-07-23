<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Account Details</title>
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
            display: inline-block;
            text-align: left;
            border: 1px solid #ccc;
            padding: 20px;
            border-radius: 4px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 30%;
            max-width: 600px;
            margin: 0 auto; /* Center aligning the form */
        }
        .form-container div {
            margin: 8px 0;
        }
        .form-container label {
            display: block;
            font-weight: bold;
            margin-bottom: 3px;
        }
        .form-container input {
            padding: 8px;
            font-size: 14px;
            width: calc(100% - 16px); /* Adjusted width */
            border-radius: 4px;
            border: 1px solid #ccc;
            box-sizing: border-box; /* Ensures padding is included in width */
        }
        .form-container button {
            margin-top: 20px; /* Increased margin for better spacing */
            padding: 10px 20px; /* Adjusted padding */
            font-size: 16px; /* Slightly larger font size */
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            display: block; /* Ensures button is treated as block level for centering */
            margin: 0 auto; /* Centers the button */
        }
        .form-container button:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <h2>Edit Account Details</h2>

    <form action="EditDetailsServlet" method="post" class="form-container">
        <div>
            <label for="accountNumber">Account Number:</label>
            <input type="text" id="accountNumber" name="accountNumber" value="${accountNumber}" readonly>
        </div>
        <div>
            <label for="fullName">Full Name:</label>
            <input type="text" id="fullName" name="fullName" value="${fullName}">
        </div>
        <div>
            <label for="address">Address:</label>
            <input type="text" id="address" name="address" value="${address}">
        </div>
        <div>
            <label for="mobile">Mobile:</label>
            <input type="text" id="mobile" name="mobile" value="${mobile}">
        </div>
        <div>
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" value="${email}">
        </div>
        <div>
            <label for="accountType">Account Type:</label>
            <input type="text" id="accountType" name="accountType" value="${accountType}">
        </div>
        <div>
            <label for="Balance">Balance:</label>
            <input type="number" id="initialBalance" name="initialBalance" value="${initialBalance}">
        </div>
        <div>
            <label for="dob">Date of Birth:</label>
            <input type="date" id="dob" name="dob" value="${dob}">
        </div>
        <div>
            <label for="idProofType">ID Proof Type:</label>
            <input type="text" id="idProofType" name="idProofType" value="${idProofType}">
        </div>
        <div>
            <label for="idProofInput">ID Proof Input:</label>
            <input type="text" id="idProofInput" name="idProofInput" value="${idProofInput}">
        </div>
        <div>
            <button type="submit">Update Details</button>
        </div>
    </form>
</body>
</html>
