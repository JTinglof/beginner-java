/**
 *  11-1-16
 *  @author  Joseph Tinglof
 */

import java.util.ArrayList;

public class Bank {
	
	ArrayList<Account>accounts = new ArrayList<Account>();
	
	public Bank(){}
	
	public void addNewAccount(Account a){
		accounts.add(a);
	}
	
	public ArrayList getAccounts(){
		return accounts;
	}
	
	public Account getAccountByIndex(int idx){
		return accounts.get(idx);
	}
	
	public String toString(){
		return "";
	}

}
