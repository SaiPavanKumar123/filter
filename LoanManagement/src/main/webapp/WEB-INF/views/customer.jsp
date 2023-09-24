<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Add Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
       /* Custom styles */
        .tab-content {
            display: none;
        }
        .active {
            display: block;
        }
        .tab-indicator {
            background-color: #007bff;
            color: #fff;
            padding: 5px;
            font-weight: bold;
        }
        /* Style for the "Next" and "Previous" buttons */
        .next-button,
        .prev-button {
            margin-right: 10px;
        }
        .submit-button {
            margin-left: 10px;
        }
        /* Style for the tabs */
        .tab-list {
            list-style-type: none;
            display: flex;
            justify-content: space-between;
            padding: 0;
		
        }
        .tab-list-item {
            flex: 1;
            text-align: center;
            cursor: pointer;
            padding: 10px;
            background-color: #f0f0f0;
            color: #000;
        }
        .tab-list-item.active {
            background-color: #007bff;
            color: #fff;
        }
        /* Unique styling for each tab */
        #tabCustomer {
            background-color: #d0d0d0;
            padding: 30px;
width:1000px;

        }
        #tabLoan {
            background-color: #d0d0d0;
            padding: 30px;
		width:1000px;
        }
        #tabNominee {
            background-color: #d0d0d0;
            padding: 30px;
width:1000px;
        }
    </style>
</head>
<body>
    <div class="container mt-5">
        <div class="row">
            <div class="col-md-12">
                <ul class="tab-list">
                    <li class="tab-list-item active" onclick="showTab(0)">Customer Details</li>
                    <li class="tab-list-item" onclick="showTab(1)">Loan Details</li>
                    <li class="tab-list-item" onclick="showTab(2)">Nominee Details</li>
                </ul>
            </div>
        
        </div>
        <!-- Customer Details Form -->
        <form id="customerForm" action="http://localhost:9010/LoanManagement/applicant" method="get">
            <div class="row mt-4">
                <div class="col-md-12">
                    <div class="tab-content active" id="tabCustomer">
                        <h2>Customer Information</h2>
                        <div class="form-group">
                            <label for="firstName">First Name</label>
                            <input type="text" class="form-control" id="firstName" name="cust_firstname" placeholder="Enter First Name" required>
                        </div>
                        <div class="form-group">
                            <label for="lastName">Last Name</label>
                            <input type="text" class="form-control" id="lastName" name="cust_lastname" placeholder="Enter Last Name" required>
                        </div>
                        <div class="form-group">
                            <label for="dob">Date of Birth</label>
                            <input type="date" class="form-control" id="dob" name="cust_dob" required>
                        </div>
                        <div class="form-group">
                            <label for="panNumber">PAN Number</label>
                            <input type="text" class="form-control" id="panNumber" name="cust_panno" placeholder="Enter PAN Number" required>
                        </div>
                        <div class="form-group">
                            <label for="mobileNumber">Mobile Number</label>
                            <input type="text" class="form-control" id="mobileNumber" name="cust_mobile" placeholder="10digit mobile number" required>
                        </div>
                        <div class="form-group">
                            <label for="address">Address</label>
                            <textarea class="form-control" id="address" name="cust_address" placeholder="Enter your address" required></textarea>
			<div class="form-group">
                            <label for="gurdian_name">Gurdian Name</label>
                            <input type="text" class="form-control" id="cust_gname" name="cust_gname" placeholder="Gurdain name" required>
                        </div>
			<br><br><br>
				<div>
                            <!-- "Next" button for the 1st tab --><center>
                            <button class="btn btn-primary next-button" onclick="nextTab('tabLoan')">Next</button></center>
                        </div>
                    </div>
                </div>
            </div>
</div>
        </form>
        <!-- Loan Details Form -->
        <form id="loanForm" action="http://localhost:9010/LoanManagement/loan" method="get">
            <div class="row mt-4">
                <div class="col-md-12">
                    <div class="tab-content" id="tabLoan">
                        <h2>Loan Details</h2>
                        <%
                java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat("yyyy-MM-dd");
                java.util.Date currentDate = new java.util.Date();
                String formattedDate = dateFormat.format(currentDate);
            %>
                        <div class="form-group">
                            <label for="applicationDate">Last Name</label>
                            <input type="date" class="form-control" id="applicationDate" name="applicationDate" value="<%=formattedDate %>">
                        </div>
                        <div class="form-group">
                           <label for="loanType">Loan Type:</label>
                <select class="form-control" name="loanTypeID" id="loanType">
                    <option value="1">Personal Loan</option>
                    <option value="2">Home Loan</option>
                    <option value="3">Vehicle Loan</option>
                    <!-- Add more loan types as needed -->
                </select>
                        </div>
                        <div class="form-group">
                            <label for="amountRequired">Amount Required</label>
                            <input type="number" class="form-control" id="amountRequired" name="amountRequired" placeholder="Enter the loan amount required in number" required>
                        </div>
                        <div class="form-group">
                            <label for="numMonths">Number of Months</label>
                            <input type="number" class="form-control" id="numMonths" name="monthsRequired" placeholder="Loan Period required" required>
                        </div>
                        <div class="form-group">
                            <label for="annualIncome">Annual Income</label>
                            <input type="number" class="form-control" id="annualIncome" name="annualincome" placeholder="Enter your Annual Income" required>
                        </div>
                        <div class="form-group">
                            <label for="disposalIncome">Disposable Income</label>
                            <input type="number" class="form-control" id="disposalIncome" name="disposalincome" placeholder="Enter your Disposal Income" required><br><br><br>
					<div>
                            <!-- "Previous" and "Next" buttons for the 2nd tab --><center>
                            <button class="btn btn-primary prev-button" onclick="prevTab('tabCustomer')">Previous</button>
                            <button class="btn btn-primary next-button" onclick="nextTab('tabNominee')">Next</button></center></div>
                        </div>
                    </div>
                </div>
            </div>
        </form>
        <!-- Nominee Details Form -->
        <form id="nomineeForm" action="http://localhost:9010/LoanManagement/nominee" method="get">
            <div class="row mt-4">
                <div class="col-md-12">
                    <div class="tab-content" id="tabNominee">
                        <h2>Nominee Information</h2>
                        <div class="form-group">
                            <label for="nomineeName">Nominee Name</label>
                            <input type="text" class="form-control" id="nomineeName" name="name" placeholder="Enter Nominee name" required>
                        </div>
                        <div class="form-group">
                            <label for="nomineeRelation">Nominee Relation</label>
                            <input type="text" class="form-control" id="nomineeRelation" name="relation" placeholder="Enter Nominee relation " required><br><br><br>
				<div>
                            <!-- "Previous" button and "Submit" button for the 3rd tab --><center>
                            <button class="btn btn-primary prev-button" onclick="prevTab('tabLoan')">Previous</button>
                            <button class="btn btn-success submit-button" onclick="submitForm()">Submit</button></center></div>
                        </div>
                    </div>
                </div>
            </div>
        </form>
    </div>

    <!-- Add Bootstrap JS and jQuery -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

    <script>
      const tabNames = ["Customer Details", "Loan Details", "Nominee Details"];
        let currentTab = 0; // Initialize with 0 to match the array index
        showTab(currentTab);

        function showTab(tabIndex) {
            const tabs = document.querySelectorAll(".tab-content");
            tabs.forEach((tab) => tab.style.display = "none");
            tabs[tabIndex].style.display = "block";
            currentTab = tabIndex;
            document.getElementById("currentTabIndicator").textContent = tabNames[tabIndex];

            // Update tab colors in the tab list
            const tabListItems = document.querySelectorAll(".tab-list-item");
            tabListItems.forEach((item, index) => {
                if (index === tabIndex) {
                    item.classList.add("active");
                } else {
                    item.classList.remove("active");
                }
            });
        }

        function nextTab(tabId) {
            if (currentTab < 2) {
                showTab(currentTab + 1);
            }
            if (tabId) {
                document.getElementById(tabId).scrollIntoView();
            }
        }

        function prevTab(tabId) {
            if (currentTab > 0) {
                showTab(currentTab - 1);
            }
            if (tabId) {
                document.getElementById(tabId).scrollIntoView();
            }
        }

        function submitForm() {
            // Depending on the active tab, submit the corresponding form.
            if (currentTab === 0) {
                // Submit Customer Details Form
                document.getElementById("customerForm").submit();
            } else if (currentTab === 1) {
                // Submit Loan Details Form
                document.getElementById("loanForm").submit();
            } else if (currentTab === 2) {
                // Submit Nominee Details Form
                document.getElementById("nomineeForm").submit();
            }
        }
        
        $(document).ready(function () {
            $("#customerForm").on("submit", function (e) {
                e.preventDefault(); // Prevent the default form submission

                // Serialize the form data (convert to a format that can be sent via AJAX)
                var formData = $(this).serialize();

                // Send the form data via AJAX to your controller endpoint
                $.ajax({
                    type: "GET", // Use POST or GET as per your form's method
                    url: "http://localhost:9010/LoanManagement/applicant", // Replace with your actual controller URL
                    data: formData,
                    success: function (response) {
                        // Handle the response if needed (e.g., update UI)
                    },
                    error: function (xhr, status, error) {
                        // Handle any errors if necessary
                    },
                });
            });
        });

      

    </script>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>

</body>
</html>
