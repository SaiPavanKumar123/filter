<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Page</title>
   <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.5.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous">
    <!-- Add your custom CSS -->
    <style>
        /* Custom CSS for the login page */
        body {
            background-color: #f5f5f5;
            font-family: Arial, sans-serif;
        }
        .login-container {
            max-width: 400px;
            margin: 0 auto;
            padding: 20px;
            margin-top:200px;
            border-radius: 5px;
            border: 2px solid white;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        .login-header {
            text-align: center;
        }
        .login-form {
            margin-top: 20px;
        }
        .form-control {
            border-radius: 20px;
        }
        .login-button {
            margin-top: 20px;
        }
    </style>
</head>
<body style="background-image:url(https://moneylion.nyc3.cdn.digitaloceanspaces.com/wp-content/uploads/2023/02/24191720/Untitled-design-30.jpg);">
    <div class="container">
        <div class="row">
            <div class="col-md-6 mx-auto">
                <div class="login-container">
                    <div class="login-header">
                      <h2 style="color: white;">Login</h2>

                    </div>
                    <form class="login-form" action="http://localhost:9010/LoanManagement/verify">
                        <div class="mb-3">
                            <input type="text" class="form-control" placeholder="Username" name="user" required>
                        </div>
                        <div class="mb-3">
                            <input type="password" class="form-control" placeholder="Password" name="password" required>
                        </div><div align="center">
                        <button type="submit" class="btn btn-primary btn-block login-button">Login</button></div>
                    </form>
                </div>
            </div>
        </div>
    </div>


    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.5.2/dist/js/bootstrap.min.js" integrity="sha384-i3e5xjNqeA/By/ZsLmAB/8Fjk5B6Ld5uH3+p5z5uO5A+V0F5Bb9ECbF6F5u0If5z5u" crossorigin="anonymous"></script>
</body>
</html>
