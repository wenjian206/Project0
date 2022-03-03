package com.training.pms;

import java.util.Scanner;

import com.training.pms.dao.AccountsDAO;
import com.training.pms.dao.AccountsDAOImpl;
import com.training.pms.dao.EmployeeDAO;
import com.training.pms.dao.EmployeeDAOImpl;
import com.training.pms.model.Accounts;
import com.training.pms.model.Employee;

public class EmployeePage {
	Scanner scanner = new Scanner(System.in);
	int choice = 0;
	AccountsDAO accountsDAO = new AccountsDAOImpl();
	EmployeeDAO employeeDAO = new EmployeeDAOImpl();
	Employee employee = new Employee();
	Accounts account = new Accounts();
	boolean result;

	int accountId = 0;
	String name = null;

	public void startEmployeePage(String username) {

		while (true) {
			System.out.println("Welcome " + username);

			System.out.println("1. Search Account By Account ID");
			System.out.println("2. Search Account By name");
			System.out.println("3. Deposit / Withdraw");
			System.out.println("4. Transfer Amount ");
			System.out.println("5. Delete account ");
			System.out.println("9. E X I T ");

			System.out.println("Please enter your choice: ");
			choice = scanner.nextInt();

			switch (choice) {

			case 1:
				//Search Account By Account ID
				System.out.println("Please enter Account ID for search: ");
				accountId = scanner.nextInt();

				if (employeeDAO.isAccountExists(accountId)) {
					Employee temp = employeeDAO.searchAccountById(accountId);
					System.out.println("AccountID: " + temp.getAccountId() + "  " + "Account Owner: " + temp.getName()
					+ "  " + "Balance: " + temp.getBalance());
				} else {
					System.out.println(
							"Account with account id : " + accountId + " does not exists");
				}
				break;
				
			case 2:
				//Search Account By name
				System.out.println("Please enter Account Owner's Name for search: ");
				name = scanner.next();

				if (employeeDAO.isAccountExists(name)) {
					Employee temp = employeeDAO.searchAccountByName(name);
					System.out.println("AccountID: " + temp.getAccountId() + "  " + "Account Owner: " + temp.getName()
					+ "  " + "Balance: " + temp.getBalance());
				} else {
					System.out.println(
							"Account with Owner's name : " + name + " does not exists");
				}
				break;

			case 3:
				//Deposit / Withdraw
				System.out.println("Coming soon... ");
				break;
				
			case 4:
				//Transfer Amount
				System.out.println("Coming soon... ");
				break;
				
			case 5:
				//Delete account
				System.out.println("Coming soon... ");
				break;

			case 9:
				// Exist App
				System.out.println("Thanks for using Banking app");
				System.exit(0);

			default:
				// Invalid Choice
				System.out.println("Invalid Choice, Please enter (1-3) or 9 to Exit.");
				break;
			}

		}

	}
}
