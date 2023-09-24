<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Loan Application</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <style>
        body {
            background-color: #f8f9fa;
        }

        .container {
            margin-top: 30px;
        }

        .form-group {
            margin-bottom: 20px;
        }

        .btn-check-eligibility {
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 5px;
            padding: 10px 20px;
            font-weight: bold;
            cursor: pointer;
        }

        .btn-check-eligibility:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Eligibility Check</h2>
        <form action="http://localhost:9010/LoanManagement/checkloan" method="get">
            <div class="form-group">
                <label for="loanType">Loan Type</label>
                <select class="form-control" id="loanType" name="loanType" required>
                    <option value="" disabled selected>Select Loan Type</option>
                    <option value="personal">Personal Loan</option>
                    <option value="home">Home Loan</option>
                    <option value="auto">Auto Loan</option>
                    <!-- Add more loan types as needed -->
                </select>
            </div>
            <div class="form-group">
                <label for="amountReq">Amount Required</label>
                <input type="number" class="form-control" id="amountReq" name="amountReq" required>
            </div>
            <div class="form-group">
               <label for="monthsReq">No Of Months</label>
                <select class="form-control" id="monthsReq" name="monthsReq" required>
                    <option value="" disabled selected>Select months</option>
                    <option value="12">12</option>
                    <option value="24">24</option>
                    <option value="32">32</option>
                    <option value="48">48</option>
                </select>
            </div>
            <div class="form-group">
                <label for="annualIncome">Annual Income</label>
                <input type="number" class="form-control" id="annualIncome" name="annualIncome" required>
            </div>
            <div class="form-group">
                <label for="disposalIncome">Disposable Income</label>
                <input type="number" class="form-control" id="disposalIncome" name="disposalIncome" required>
            </div>
            <div class="form-group">
                <label for="cibilScore">Cibil Score</label>
                <input type="number" class="form-control" id="cibilScore" name="cibilScore" required>
            </div>
            <button class="btn btn-check-eligibility">Check Eligibility</button>
        </form>
    </div>

    <!-- Bootstrap and JavaScript -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
