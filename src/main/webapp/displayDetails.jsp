<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Customer Details</title>
    <style>
        body {
            background-color: #f0f0f0; /* Light gray background */
            font-family: Arial, sans-serif;
            text-align: center;
            padding-top: 20px; /* Adjusted padding top */
            margin: 0; /* Remove default margin */
            background: linear-gradient(90deg, #a6a6a6, #ffffff);
            background-image: url('images/bank_image.jpg');
            background-size: cover; /* Cover the entire background */
            background-position: center; /* Center the background image */
            background-repeat: no-repeat;
            background-attachment: fixed; /* Provides space from the top */
        }
        h2 {
            color: black; /* Set the color to black */
            font-size: 24px; /* Larger font size for heading */
            margin-bottom: 20px; /* Add space below the heading */
        }
        form {
            max-width: 400px; /* Limits form width for better readability */
            margin: 0 auto; /* Centers the form horizontally */
            background-color: #fff; /* White background */
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); /* Subtle shadow effect */
            margin-top: -20px; /* Adjusted negative margin to move it up */
        }
        label {
            display: block;
            margin-bottom: 10px;
            color: #555; /* Dark gray text color */
            font-size: 16px;
        }
        input[type="text"], input[type="email"], input[type="date"] {
            width: calc(100% - 20px); /* Full width input minus padding */
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ccc; /* Light gray border */
            border-radius: 3px;
            font-size: 16px;
            box-sizing: border-box; /* Ensures padding and border are included in width */
        }
        button[type="submit"] {
            background-color: #4CAF50; /* Green background */
            color: white; /* White text color */
            padding: 12px 20px; /* Padding inside the button */
            border: none; /* No border */
            border-radius: 3px; /* Rounded corners */
            cursor: pointer; /* Pointer cursor on hover */
            font-size: 16px; /* Font size */
        }
        button[type="submit"]:hover {
            background-color: #45a049; /* Darker green on hover */
        }
    </style>
</head>
<body>
    <h2>Edit Customer Details</h2>
    <br><br>
    <form action="UpdateDetailsServlet" method="post">
        <input type="hidden" name="accountNumber" value="${param.accountNumber}">
        <label for="fullname">Full Name:</label>
        <input type="text" id="fullname" name="fullname" value="${requestScope.fullname}" required>
        
        <label for="address">Address:</label>
        <input type="text" id="address" name="address" value="${requestScope.address}" required>
        
        <label for="mobile">Mobile No:</label>
        <input type="text" id="mobile" name="mobile" value="${requestScope.mobile}" required>
        
        <label for="email">Email ID:</label>
        <input type="email" id="email" name="email" value="${requestScope.email}" required>
        
        <label for="accountType">Type of Account:</label>
        <input type="text" id="accountType" name="accountType" value="${requestScope.accountType}" required>
        
        <label for="dob">Date of Birth:</label>
        <input type="date" id="dob" name="dob" value="${requestScope.dob}" required>
        
        <label for="idProofInput">ID Proof:</label>
        <input type="text" id="idProofInput" name="idProofInput" value="${requestScope.idProofInput}" required>
        
        <button type="submit">Update Details</button>
    </form>
</body>
</html>
