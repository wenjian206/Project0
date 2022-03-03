# Project0
# This is the project0 that aim to create a Banking App.
The Banking app is a console-based application that simulates banking operations. 
A customer can apply for an account, view their balance, and make withdrawals, deposits and transfer. 
An employee can manage accounts and view account balances for their customers.

# Requirement
The Banking app should meet the requirement as below:
    1. Functionality should reflect the below user stories.
    2. Data is stored in a database. 
    3. A custom stored procedure is called to perform some portion of the functionality. 
    4. Data Access is performed through the use of JDBC in a data layer consisting of Data Access Objects.
    5. All input is received using the java.util.Scanner class. 
    6. A minimum of one (1) JUnit test is written to test some functionality. 

# User Story:
1. Register New Account
#####################################
B A N K I N G  -  APP   MENU
#####################################
1. Register 
2. Customer Login 
3. Employee Login 
4. About Us 
Please enter your choice : 
1
WELCOME TO Register SECTION
Please enter username: 
Coco
Please enter password: 
Coco@123
Adding users: Login [loginId=-1, username=Coco, password=Coco@123]
1 user registered successfully
Congratulations, your Account: Coco is registered successfully

2.Login as Customer
#####################################
B A N K I N G  -  APP   MENU
#####################################
1. Register 
2. Customer Login 
3. Employee Login 
4. About Us 
Please enter your choice : 
2
WELCOME TO Login SECTION
Please enter username: 
Coco
Please enter password: 
Coco@123
Log you in ...
Welcome Coco
1. View Balance 
2. Deposit
3. Withdraw
4. Transfer Amount 
5. Logout 
9. E X I T 
Please enter your choice: 

3. Login as Employee
#####################################
B A N K I N G  -  APP   MENU
#####################################
1. Register 
2. Customer Login 
3. Employee Login 
4. About Us 
Please enter your choice : 
3
WELCOME TO Employee SECTION
Please enter employeeID: 
1000
Please enter username: 
Wade
Please enter password: 
Wade@emp
Log you in ...
Welcome Wade
1. Search Account By Account ID
2. Search Account By name
3. Deposit / Withdraw
4. Transfer Amount 
5. Delete account 
9. E X I T 
Please enter your choice: 
