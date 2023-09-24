
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style>
        /* Reset some default styles for the page */
         body,ul {
            margin: 0;
            padding: 0;
            
        }

        /* Style for the menu */
        .menu {
            background-color: #333;
            color: white;
            width: 200px; /* Adjust the width as needed */
            height: 100%; /* Full height menu */
            position: fixed;
            top: 0;
            left: 0;
        }

        .menu ul {
            list-style-type: none;
            padding: 20px;
        }

        .menu ul li {
            margin-bottom: 10px;
        }

        .menu a {
            color: white;
            text-decoration: none;
        }

        /* Style for the content */
        .content {
            margin-left: 220px; 
            padding: 20px;
            
        }

        /* Example styles for the content area */
        .content h1 {
            font-size: 24px;
        }

        .content p {
            font-size: 16px;
        }
    </style>
    <title>Left Top Menu Page</title>
</head>
<body>

    <div class="menu">
        <ul>
            <li><a href="http://localhost:9010/LoanManagement/applications">Loan Applicants</a></li>
            <li><a href="#">Loans</a></li>
            <li><a href="#">Repayments</a></li>
            <li><a href="#">Contact</a></li>
        </ul>
    </div>
    <div class="content">
       <nav class="navbar navbar-light bg-light">
  <div class="container-fluid">
    <a class="navbar-brand" href="http://localhost:9010/LoanManagement/applications">back</a>
    <form class="d-flex" action="http://localhost:9010/LoanManagement/mobilesearch">
      <input class="form-control me-2" type="search" placeholder="mobile number" aria-label="Search" name="mobile">
      <button class="btn btn-outline-success" type="submit">Search</button>
    </form>
  </div>
</nav>
        
    </div>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
     <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    
</body>
</html>
