<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Account Details</title>
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
        color: black; /* Set the color to black */
            font-size: 24px; /* Larger font size for heading */
            margin-bottom: 20px; /* Dark grey text */
    }
    table {
        margin: 0 auto;
        border-collapse: collapse;
        width: 40%;
        background-color: #fff; /* White background */
        box-shadow: 0 0 10px rgba(0,0,0,0.1); /* Light shadow for table */
        margin-bottom: 20px; /* Space between table and button */
        border-radius: 10px; /* Rounded corners */
    }
    table, th, td {
        border: 1px solid #ddd; /* Light grey borders */
    }
    th, td {
        padding: 10px;
        text-align: left;
    }
    th {
        background-color: #f2f2f2; /* Light grey background for table headers */
    }
    tr:nth-child(even) {
        background-color: #f9f9f9; /* Light grey background for even rows */
    }
    tr:hover {
        background-color: #e9e9e9; /* Light grey background on hover */
    }
    /* Green background for the header row */
    table tr:first-child th {
        background-color: #007bff; /* Green color */
        color: white; /* White text */
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
        border-radius: 5px; /* Rounded corners */
    }
    .back-btn:hover {
        background-color: #45a049; /* Darker green on hover */
    }
</style>

</head>
<body>
    <h2>Account Details</h2>
    <table>
        <tr>
            <th>Attribute</th>
            <th>Details</th>
        </tr>
        <tr>
            <td>Full Name</td>
            <td>${customer.fullname}</td>
        </tr>
        <tr>
            <td>Address</td>
            <td>${customer.address}</td>
        </tr>
        <tr>
            <td>Mobile</td>
            <td>${customer.mobile}</td>
        </tr>
        <tr>
            <td>Email</td>
            <td>${customer.email}</td>
        </tr>
        <tr>
            <td>Account Type</td>
            <td>${customer.accountType}</td>
        </tr>
        <tr>
            <td>Date of Birth</td>
            <td>${customer.dob}</td>
        </tr>
        <tr>
            <td>ID Proof Type</td>
            <td>${customer.idProofType}</td>
        </tr>
        <tr>
            <td>ID Proof</td>
            <td>${customer.idProofInput}</td>
        </tr>
        <tr>
            <td>Account Number</td>
            <td>${customer.accountNumber}</td>
        </tr>
    </table>
    <button class="back-btn" onclick="goBack()">Back</button>

    <script>
        function goBack() {
            window.history.back();
        }
    </script>
</body>
</html>
