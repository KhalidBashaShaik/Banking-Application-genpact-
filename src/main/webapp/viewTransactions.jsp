<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>View Transactions</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            text-align: center;
            margin-top: 50px;
            background: linear-gradient(90deg, #a6a6a6, #ffffff);
            /* Use background image */
            background-image: url('images/bank_image.jpg');
            background-size: cover; /* Cover the entire background */
            background-position: center; /* Center the background image */
            background-repeat: no-repeat;
            background-attachment: fixed; /* Prevent background image from repeating */
        }
        .container {
            width: 80%;
            margin: 0 auto;
            background-color: rgba(255, 255, 255, 0.8); /* Light transparent white */
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1); /* Light shadow */
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        th, td {
            padding: 10px;
            border-bottom: 1px solid #ddd;
            text-align: left;
        }
        th {
            background-color: #4CAF50;
            color: white;
        }
        tr:hover {
            background-color: #f5f5f5;
        }
        .back-button {
            margin-top: 20px;
        }
        .back-button a {
            text-decoration: none;
            background-color: #4CAF50;
            padding: 10px 20px;
            color: black;
            border-radius: 4px;
        }
        .back-button a:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Transaction History</h2>
        <table>
            <tr>
                <th>Account Number</th>
                <th>Type</th>
                <th>Amount</th>
                <th>Description</th>
                <th>Date</th>
            </tr>
            <c:forEach var="transaction" items="${transactions}">
                <tr>
                    <td>${transaction.accountNumber}</td>
                    <td>${transaction.transactionType}</td>
                    <td>${transaction.amount}</td>
                    <td>${transaction.description}</td>
                    <td>${transaction.transactionDate}</td>
                </tr>
            </c:forEach>
        </table>
        <br>
    </div>
    <div class="back-button">
        <a href="customerHome.jsp">Back</a>
    </div>
</body>
</html>
