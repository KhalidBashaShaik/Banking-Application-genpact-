<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Bank Details</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
            background: linear-gradient(90deg, #a6a6a6, #ffffff);
            background-image: url('images/bank_image.jpg');
             background-size: cover; /* Cover the entire background */
            background-position: center; /* Center the background image */
            background-repeat: no-repeat;
            background-attachment: fixed;
        }
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            padding: 10px;
            border: 1px solid #ddd;
            text-align: left;
        }
        th {
            background-color: #f4f4f4;
        }
        .form-container {
            margin-top: 20px;
            text-align: center;
        }
        .form-container input[type=text] {
            padding: 8px;
            margin: 0 10px;
        }
        .form-container button {
            padding: 10px 20px;
            font-size: 16px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        .form-container button:hover {
       
        }
    </style>
</head>
<body>
    <h2>Bank Details</h2>

    <div class="form-container">
        <form action="GetCustomerDetailsServlet" method="get">
            <label for="accountNumber">Enter Account Number:</label>
            <input type="text" id="accountNumber" name="accountNumber" required>
            <button type="submit">Get Details</button>
        </form>
    </div>

    <hr>

    <h3>Customer Details</h3>

    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Full Name</th>
                <th>Address</th>
                <th>Mobile</th>
                <th>Email</th>
                <th>Account Type</th>
                <th>Date of Birth</th>
                <th>ID Proof Type</th>
                <th>ID Proof Input</th>
                <th>Account Number</th>
                <!-- Add more headers as needed -->
            </tr>
        </thead>
        <tbody>
            <c:if test="${not empty customer}">
                <tr>
                    <td>${customer.id}</td>
                    <td>${customer.fullname}</td>
                    <td>${customer.address}</td>
                    <td>${customer.mobile}</td>
                    <td>${customer.email}</td>
                    <td>${customer.accountType}</td>
                    <td>${customer.dob}</td>
                    <td>${customer.idProofType}</td>
                    <td>${customer.idProofInput}</td>
                    <td>${customer.accountNumber}</td>
                    <!-- Add more columns as needed -->
                </tr>
            </c:if>
        </tbody>
    </table>

    <div class="form-container">
        <button onclick="window.location.href='adminHome.jsp'">Back</button>
    </div>

</body>
</html>
