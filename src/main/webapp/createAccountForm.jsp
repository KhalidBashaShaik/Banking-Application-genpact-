<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Customer Registration</title>
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
            width: 40%; /* Reduced width */
            margin: 0 auto;
            background-color: #f2f2f2;
            padding: 15px; /* Reduced padding */
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        .form-container label {
            display: block;
            text-align: left;
            margin-bottom: 5px;
        }
        .form-container input[type="text"],
        .form-container input[type="number"],
        .form-container input[type="email"],
        .form-container input[type="date"],
        .form-container select {
            width: calc(100% - 10px); /* Adjusted width */
            padding: 6px; /* Reduced padding */
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }
        .form-container input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            padding: 8px 16px; /* Reduced padding */
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        .form-container input[type="submit"]:hover {
            background-color: #45a049;
        }
        .back-button {
            margin-top: 20px;
        }
        .back-button a {
            text-decoration: none;
            background-color: #f44336;
            padding: 10px 20px;
            color: black;
            border-radius: 4px;
        }
        .back-button a:hover {
            background-color: #d32f2f;
        }
    </style>
</head>
<body>
    <h2>Customer Registration</h2>

    <div class="form-container">
        <form action="RegisterCustomerServlet" method="post">
            <label for="fullname">Full Name:</label>
            <input type="text" id="fullname" name="fullname" required><br>

            <label for="address">Address:</label>
            <input type="text" id="address" name="address" required><br>

            <label for="mobile">Mobile No:</label>
            <input type="text" id="mobile" name="mobile" pattern="[0-9]{10}" required><br>

            <label for="email">Email ID:</label>
            <input type="email" id="email" name="email" required><br>

            <label for="accountType">Type of Account:</label>
            <select id="accountType" name="accountType" required>
                <option value="saving">Saving Account</option>
                <option value="current">Current Account</option>
            </select><br>

            <label for="Balance">Balance (min 1000):</label>
            <input type="number" id="Balance" name="Balance" min="1000" required><br>

            <label for="dob">Date of Birth:</label>
            <input type="date" id="dob" name="dob" required><br>

            <label for="idProofType">ID Proof Type:</label>
            <select id="idProofType" name="idProofType" onchange="toggleIdProofInput()" required>
                <option value="" disabled selected>Select ID Proof</option>
                <option value="Aadhaar">Aadhaar Number</option>
                <option value="Pan Card">PAN Number</option>
            </select><br>

            <input type="text" id="idProofInput" name="idProofInput" placeholder="Enter ID Proof" required><br>

            <input type="submit" value="Register">
        </form>
    </div>

    <div class="back-button">
        <a href="adminHome.jsp">Back</a>
    </div>

    <script>
        function toggleIdProofInput() {
            var idProofType = document.getElementById("idProofType").value;
            var idProofInput = document.getElementById("idProofInput");
            if (idProofType === "Aadhaar") {
                idProofInput.setAttribute("type", "text");
                idProofInput.setAttribute("pattern", "[0-9]{12}");
                idProofInput.setAttribute("placeholder", "Enter 12-digit Aadhaar number");
            } else {
                idProofInput.setAttribute("type", "text");
                idProofInput.removeAttribute("pattern");
                idProofInput.setAttribute("placeholder", "Enter PAN number");
            }
        }
    </script>
</body>
</html>
