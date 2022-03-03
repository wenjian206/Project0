package com.training.pms;

import java.util.Scanner;

import com.training.pms.dao.AccountsDAO;
import com.training.pms.dao.AccountsDAOImpl;
import com.training.pms.dao.LoginDAO;
import com.training.pms.dao.LoginDAOImpl;
import com.training.pms.model.Accounts;

public class CustomerPage {
	Scanner scanner = new Scanner(System.in);
	int choice = 0;
	AccountsDAO accountsDAO = new AccountsDAOImpl();
	LoginDAO loginDAO = new LoginDAOImpl();
	Accounts account = new Accounts();
	boolean result;

	public void startCustomerPage(String username) {

		int balance = 0;
		int currentBalance = 0;
		int debitorBalance = 0;
		int creditorBalance = 0;

		while (true) {
			// Customer Page
			System.out.println("Welcome " + username);

			System.out.println("1. View Balance ");
			System.out.println("2. Deposit");
			System.out.println("3. Withdraw");
			System.out.println("4. Transfer Amount ");
			System.out.println("5. Logout ");
			System.out.println("9. E X I T ");

			System.out.println("Please enter your choice: ");
			choice = scanner.nextInt();

			Accounts temp = accountsDAO.viewBalance(username);
			switch (choice) {

			case 1:
				// View Balance
				System.out.println("AccountID: " + temp.getAccountId() + "  " + "Account Owner: " + temp.getName()
						+ "  " + "Balance: " + temp.getBalance());

				break;

			case 2:
				// Deposit
				System.out.println("WELCOME TO DEPOSIT SECTION");

				System.out.println("Please enter the amount to deposit: ");
				int deposit = scanner.nextInt();

				// call dao layer to save the product
				currentBalance = accountsDAO.deposit(currentBalance, deposit, username);
				currentBalance = temp.getBalance() + deposit;
				System.out.println("Congratulations, deposit completed. Your balance is: " + currentBalance);

				break;

			case 3:
				// Withdraw
				System.out.println("WELCOME TO DEPOSIT SECTION");

				System.out.println("Please enter the amount to deposit: ");
				int withdraw = scanner.nextInt();

				// call dao layer to save the product
				currentBalance = accountsDAO.withdraw(currentBalance, withdraw, username);
				currentBalance = temp.getBalance() - withdraw;
				System.out.println("Congratulations, deposit completed. Your balance is: " + currentBalance);

				break;

			case 4:
				// Transfer
				System.out.println("**WELCOME TO Transfer SECTION**");

				System.out.println("Enter the account Id to debit the amount: ");
				int sender = scanner.nextInt();

				System.out.println("Enter the account Id to credit the amount: ");
				int receiver = scanner.nextInt();

				System.out.println("Enter the amount to be transferred: ");
				int amount = scanner.nextInt();

				balance = temp.getBalance();

				if (balance < amount) {
					System.out
							.println("The amount you transfer is greater than your account balance, please try again.");
				} else {
					debitorBalance = accountsDAO.transferAmountAndGetbalance(sender, receiver, amount, debitorBalance,
							creditorBalance);

					System.out.println("Transfer done/completed and the balance is : ");
					System.out.println(
							"The amount transfered: " + amount + "     " + "Debitor balance remain: " + debitorBalance);
				}
				break;

			case 5:
				// Log out
				System.out.println("Log you out ... ");
				System.exit(0);

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
