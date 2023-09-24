<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Loan Eligibility</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
        }
        .container {
            max-width: 400px;
            margin: 0 auto;
            padding: 20px;
            background-color: #fff;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            text-align: center;
        }
        h1 {
            color: #333;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Congratulations!</h1>
        <p>You are eligible for a loan.</p>
        
        <h2>Loan Details:</h2>
        <p>Eligible Amount: <%=request.getAttribute("amount") %></p>
        <p>EMI Range: <%=request.getAttribute("emi") %> - <%=(double)request.getAttribute("emi")*2 %></p>
        <p>Loan Term (Months): <%=request.getAttribute("months") %></p>
    </div>
</body>
</html>
