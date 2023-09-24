<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Bank Loan Dashboard</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <style>
        body {
            background-image: url('https://thumbs.dreamstime.com/b/estate-agent-pointing-finger-document-showing-total-cost-signing-paper-buying-house-real-home-loan-insurance-concept-151774559.jpg');
            background-size: cover;
            background-position: center;
            height: 100vh;
            margin: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            flex-direction: column;
        }

        .container {
            padding: 20px;
        }

        .dashboard-card {
            background-color: #fff;
            padding: 20px;
            box-shadow: 0px 5px 15px rgba(0, 0, 0, 0.2);
            border-radius: 10px;
            margin-bottom: 20px;
            transition: transform 0.3s ease-in-out;
        }

        .dashboard-card:hover {
            transform: translateY(-5px);
        }

        .dashboard-card h2 {
            font-size: 24px;
            margin-bottom: 20px;
            color: #333;
        }

        .dashboard-card p {
            font-size: 16px;
            color: #666;
        }

        .dashboard-link {
            text-decoration: none;
        }

        .logout-button {
            background-color: #d9534f;
            color: #fff;
            border: none;
            border-radius: 5px;
            padding: 10px 20px;
            font-weight: bold;
            cursor: pointer;
            transition: background-color 0.3s ease-in-out;
        }

        .logout-button:hover {
            background-color: #c9302c;
        }

        .icon-badge {
            position: relative;
            display: inline-block;
            margin-right: 10px;
        }

        .icon-badge .badge {
            position: absolute;
            top: -8px;
            right: -8px;
            background-color: #007bff;
            color: #fff;
            border: 2px solid #fff;
            border-radius: 50%;
            padding: 4px 7px;
            font-size: 12px;
        }

	h1 {
            /* Adjust the margin as needed */
            background-color: #007bff;
            color: #fff;
            padding: 20px;
            border-radius: 5px;
            text-align: center;
            font-size: 28px;
        }
    </style>
</head>

   <body>
    <h1 align="top" style="font-family:times-roman;">
        Welcome to World Bank 
    </h1>
	 <div class="container">
        <div class="row">
            <div class="col-md-4">
                <a href="http://localhost:9010/LoanManagement/myinformation?userid=<%=request.getAttribute("userid") %>" class="dashboard-link">
                    <div class="dashboard-card">
                        <h2>My Account Information</h2>
                        <p>View your account details.</p>
                    </div>
                </a>
            </div>
            <div class="col-md-4">
                <a href="loan-information.html" class="dashboard-link">
                    <div class="dashboard-card">
                        <h2>My Loans Information</h2>
                        <p>View details of your loans.</p>
                    </div>
                </a>
            </div>
            <div class="col-md-4">
                <a href="http://localhost:9010/LoanManagement/totalemis?userid=<%=request.getAttribute("userid") %>" class="dashboard-link">
                    <div class="dashboard-card">
                        <h2>Total EMIs</h2>
                        <p>Check your Equated Monthly Installments.</p>
                    </div>
                </a>
            </div>
        </div>
        <div class="row">
            <div class="col-md-4">
                <a href="http://localhost:9010/LoanManagement/appliedloans?userid=<%=request.getAttribute("userid") %>" class="dashboard-link">
                    <div class="dashboard-card">
                        <h2>Applied Loans</h2>
                        <p>View your loan applications.</p>
                        <span class="icon-badge"><i class="fas fa-paper-plane"></i><span class="badge">3</span></span>
                    </div>
                </a>
            </div>
            <div class="col-md-4">
                <a href="http://localhost:9010/LoanManagement/customer" class="dashboard-link">
                    <div class="dashboard-card">
                        <h2>Apply for a Loan</h2>
                        <p>Apply for a new loan.</p>
                        <span class="icon-badge"><i class="fas fa-file-alt"></i><span class="badge">New</span></span>
                    </div>
                </a>
            </div>
            <div class="col-md-4">
                <a href="http://localhost:9010/LoanManagement/checkeligibility" class="dashboard-link">
                    <div class="dashboard-card">
                        <h2>Check Eligibility</h2>
                        <p>Determine your loan eligibility.</p>
                        <span class="icon-badge"><i class="fas fa-check-circle"></i><span class="badge">High</span></span>
                    </div>
                </a>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <button class="logout-button" onclick="logout()">Logout</button>
            </div>
        </div>
    </div>

    <!-- Bootstrap and JavaScript -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
