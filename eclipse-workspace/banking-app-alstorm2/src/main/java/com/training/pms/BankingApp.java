package com.training.pms;

import java.util.Scanner;
import com.training.pms.dao.AccountsDAO;
import com.training.pms.dao.AccountsDAOImpl;
import com.training.pms.dao.LoginDAO;
import com.training.pms.dao.LoginDAOImpl;
import com.training.pms.model.Login;
import com.training.pms.model.Accounts;

public class BankingApp {

	Scanner scanner = new Scanner(System.in);
	int choice = 0;
	AccountsDAO accountsDAO = new AccountsDAOImpl();
	LoginDAO loginDAO = new LoginDAOImpl();
	Accounts account = new Accounts();
	boolean result;
	// List<Product> products = new ArrayList<Product>();

	public void startBankingApp() {

		// declaring local variables for input
		int loginId = 0;
		String username = null;
		String password = null;

		while (true) {
			System.out.println("B A N K I N G  -  APP   MENU");

			System.out.println("1. Register ");
			System.out.println("2. Customer Login ");
			System.out.println("3. Employee Login ");
			System.out.println("Please enter your choice : ");
			choice = scanner.nextInt();

			switch (choice) {
			case 1:
				// register section
				System.out.println("WELCOME TO Register SECTION");

				// take input from user to register an account
				System.out.println("Please enter username: ");
				username = scanner.next();

				if (loginDAO.isAccountExists(username)) {
					System.out.println("Account with username : " + username + " already exists, please try again");
					continue;
				}

				System.out.println("Please enter password: ");
				password = scanner.next();

				Login login = new Login(-1, username, password);
				// call dao layer to save the product
				result = loginDAO.register(login,account);
				if (result)
					System.out.println("Congratulations, your Account: " + username + " is registered successfully");
				else
					System.out.println("Sorry, your Account cannot be register");
				break;

			case 2:
				// Customer login section
				System.out.println("WELCOME TO Login SECTION");

				// take input from user to login
				System.out.println("Please enter username: ");
				username = scanner.next();

				System.out.println("Please enter password: ");
				password = scanner.next();

				if (loginDAO.validate(username, password)) {
					System.out.println("Log you in ...");

				} else {
					System.out.println("Account is not exist, pleas try again");
					continue;
				}
				
				CustomerPage cp = new CustomerPage();
				cp.startCustomerPage(username);
				
			case 3:
				//Employee login Section
				System.out.println("WELCOME TO Employee SECTION");

				// take input from user to login
				System.out.println("Please enter employeeID: ");
				loginId = scanner.nextInt();
				
				System.out.println("Please enter username: ");
				username = scanner.next();

				System.out.println("Please enter password: ");
				password = scanner.next();

				if (loginDAO.validate(loginId, username, password)) {
					System.out.println("Log you in ...");
					
					EmployeePage ep = new EmployeePage();
					ep.startEmployeePage(username);
				} else {
					System.out.println("Account is not exist, please try again");
					continue;
				}
				

			default:
				System.out.println("Invalid choice");
				continue;
			}
		}
	}
     
}
