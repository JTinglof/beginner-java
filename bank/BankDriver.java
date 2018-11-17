/**
 * File: BankDriver.java
 * Description: Demonstrates polymorphism and inheritance
 * Dependencies: Bank, Account, Transactions, CheckingAccount, SavingsAccount <, IRAAccount> 
 * 
 * @author Joseph Tinglof
 */

import java.util.ArrayList;

public class BankDriver {
	
	public static void main(String[] args) {
		Bank bank = new Bank();

		System.out.println("Creating accounts...");
		bank.addNewAccount(new SavingsAccount("Waterford Ellingsworth", 4350.0, 0.002));
		bank.addNewAccount(new CheckingAccount("Bethanie Treadwell", 500.0, 0.35));
		bank.addNewAccount(new IRAAccount("Ira Standish", 50000, 0.1, 59, 0.1));
		

		@SuppressWarnings("unchecked")
		ArrayList<Account> list = bank.getAccounts();
		printAccts(list, true);
		
		System.out.println("\nPerforming transactions...");
		bank.getAccountByIndex(0).deposit(200.00);
		bank.getAccountByIndex(1).withdraw(213.13);
		
		printAccts(list);

		System.out.println("\nUpdating accounts...");
		for (Account a : list){
			a.updateAccount();
		}
		printAccts(list, false);
	}

	private static void printAccts(ArrayList<Account> list){
		for (Account a : list){
			System.out.println(a);
		} 
	}
	private static void printAccts(ArrayList<Account> list, boolean printHolder){
		if (printHolder)
			for (Account a : list){
				System.out.println("Customer: " + a.getHolder() + ", " + a);
			} 
		else
			printAccts(list);
	}
}
