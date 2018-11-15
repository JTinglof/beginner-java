/**
 *  Program #5
 *  This is the super class for all account types in the bank.
 *  CS108-2
 *  11-1-16
 *  @author  Joseph Tinglof
 */

public abstract class Account implements Transactions {
	
	public String customer;
	public double currentBalance;
	public int accountNumber;
	private static int lastAccountID = 1;
	
	public Account() {}
	
	public Account(String customerName, double initialInvestment){
		customer = customerName;
		currentBalance = initialInvestment;
		accountNumber = lastAccountID;
		lastAccountID++;
	}
	
	public static int getLastAccountId(){
		return lastAccountID;
	}
	
	public int getAccountNumber(){
		return accountNumber;
	}
	
	public void setId(int id){
		lastAccountID = id;
	}
	
	public String getHolder(){
		return customer;
	}
	
	public void setHolder(String name){
		customer = name;
	}
	
	public double getAccountBalance(){
		return currentBalance;
	}
	
	public void setAccountBalance(double monies){
		currentBalance = monies;
	}
	
	public boolean deposit(double depositAmount){
		currentBalance += depositAmount;
		return true;
	}
	
	public boolean withdraw(double withdrawAmount){
		currentBalance -= withdrawAmount;
		return true;
	}
	
	public abstract void updateAccount();
	
	public String toString(){
		return ""+getAccountNumber();
	}

}
