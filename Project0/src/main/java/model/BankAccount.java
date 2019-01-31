package model;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Scanner;

import application.App;
import service.BankAccountService;
import service.TransactionService;

public class BankAccount {
	
	private int bank_account_id;
	private double balance;
	private String type;
	
	/**
	 * Constructor used for getting a bank account from the database
	 * @param bank_account_id
	 * @param balance
	 * @param type
	 */
	public BankAccount(int bank_account_id, double balance, String type) {
		super();
		this.bank_account_id = bank_account_id;
		this.balance = balance;
		this.type = type;
	}
	
	/**
	 * Constructor used for adding a Bank Account to the database.
	 * Lacks a bank_account_id parameter because a SQL sequence will generate a new bank_account_id.
	 * @param balance
	 * @param type
	 */
	public BankAccount(double balance, String type) {
		super();
		this.balance = balance;
		this.type = type;
	}

	/**
	 * viewTransactions method
	 * Called from detailedAccountView() for a specific BankAccount.
	 * Displays the transactions for a bank account and allows the user
	 * to make deposits and withdrawals for this bank account.
	 * @param bank_account_id The id of the bank account
	 */
	public void viewTransactions() {
	
		System.out.println("Viewing transactions for account number " + bank_account_id);
		
		int choice;
		
		do {		
			// get all the transactions for this bank account and display them
			List<Transaction> transactions = TransactionService.allTransactions(bank_account_id);
			displayAllTransactions(transactions);

			// prompt user to make a deposit, withdrawal, or to return to their list
			// of bank accounts
			System.out.println("\nWould you like to: ");
			System.out.println("1. Make a deposit");
			System.out.println("2. Make a withdrawal");
			System.out.println("3. Return to list of accounts");
			System.out.print("Your choice: ");
			choice = App.scan.nextInt();
			App.scan.nextLine();
			System.out.println("---------------------------------------------------------\n");
			
			switch (choice) {
				case 1: // deposit
					deposit();
					break;
				case 2: // withdrawal
					withdraw();
					break;
				case 3: // return to list of accounts
					System.out.println("Returning to your list of accounts");
					break;
				default: // incorrect input
					System.out.println("Incorrect choice. Please select an option from 1-3.");
					break;	
			}
			// loop until the user decides to return to their accounts
		} while(choice != 3);	
	}
	
	/**
	 * displayAllTransactions method
	 * Displays the account balance before and after each transactions, as well
	 * as how much each transaction was.
	 * @param transactions A list of transactions associated with a bank account
	 */
	public void displayAllTransactions(List<Transaction> transactions) {
		
		System.out.println("\n---------------------------------------------------------");
		System.out.println("Your transactions");
		System.out.println("------------------");
		
		// only display transactions as long as at least one exists
		if (transactions.size() > 0) {
			// format the column headings
			DecimalFormat dollar = new DecimalFormat("#,##0.00");
			System.out.printf("%-12s%-16s%-12s\n", "Before", "Amount", "After");
			System.out.printf("%-12s%-16s%-12s\n", "---------", "---------", "---------");
			
			// loop through each transaction and display its values
			for (Transaction transaction : transactions) {
				
				// calculate how much the transaction was
				double amount = transaction.getBalance_after() - transaction.getBalance_before();
				
				// display balance before
				System.out.printf("$%-12s", dollar.format(transaction.getBalance_before()));
				
				// display a positive or negative amount to represent a depoist or withdrawal
				if (amount > 0) {
					System.out.printf("+$%-12s", dollar.format(amount));
				} else {
					System.out.printf("-$%-12s", dollar.format(-amount));
				}
				
				// display balance after
				System.out.printf("$%-12s\n", dollar.format(transaction.getBalance_after()));
			}
		} else {
			System.out.println("NO TRANSACTIONS FOUND");
		}
	}
	
	/**
	 * deposit method
	 * Asks the user how much they want to deposit. Only excepts deposits of
	 * at least one cent. A transaction is added in the database for this account
	 * and the account balance is also updated in the database.
	 */
	public void deposit() {
		
		// ask how much you would like to deposit
		System.out.println("Depositing into account number " + bank_account_id);
		System.out.println("How much would you like to deposit?");
		System.out.print("$");
		double amount = App.scan.nextDouble();
		App.scan.nextLine();
		
		DecimalFormat dollar = new DecimalFormat("#,##0.00");
		
		// only deposits of at least one cent are excepted
		if (amount > 0.0) {
			System.out.println("Deposited $" + dollar.format(amount));
	
			// add this transaction for this bank account in the database
			TransactionService.addTransaction(bank_account_id, new Transaction(balance, balance + amount));
			
			// update the balance for this bank account in the database
			balance = balance + amount;
			BankAccountService.updateBankAccount(this);
						
		} else {
			System.out.println("You must deposit more than $0.00");
		}
		
	}
	
	/**
	 * withdraw method
	 * Asks the user how much they want to withdraw
	 */
	public void withdraw() {
		
		// ask how much you want to withdraw
		System.out.println("Withdrawing from account number " + bank_account_id);
		System.out.println("How much would you like to withdraw?");
		System.out.print("$");
		double amount = App.scan.nextDouble();
		App.scan.nextLine();
		
		DecimalFormat dollar = new DecimalFormat("#,##0.00");
		
		// Withdrawals can only be made if they are at least one cent and they do
		// not overdraw your account balance
		if ((amount > 0.0) && (balance - amount >= 0.0)) {
			System.out.println("Withdrew $" + dollar.format(amount));
	
			// add this transaction for this bank account in the database
			TransactionService.addTransaction(bank_account_id, new Transaction(balance, balance - amount));
			
			// update the balance for this bank account in the database
			balance = balance - amount;
			BankAccountService.updateBankAccount(this);
						
		} else {
			System.out.println("You must withdraw more than $0.00 and you cannot overdraw your balance");
		}
	}

	/**
	 * @return the bank_account_id
	 */
	public int getBank_account_id() {
		return bank_account_id;
	}

	/**
	 * @param bank_account_id the bank_account_id to set
	 */
	public void setBank_account_id(int bank_account_id) {
		this.bank_account_id = bank_account_id;
	}

	/**
	 * @return the balance
	 */
	public double getBalance() {
		return balance;
	}

	/**
	 * @param balance the balance to set
	 */
	public void setBalance(double balance) {
		this.balance = balance;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BankAccount [bank_account_id=" + bank_account_id + ", balance=" + balance + ", type=" + type + "]";
	}
	
	
	
	
	
}
