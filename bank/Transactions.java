/**
 *  Program #5
 *  This is the interface for accounts in the bank, allowing them to deposit and withdraw.
 *  CS108-2
 *  11-1-16
 *  @author  Joseph Tinglof
 */


public interface Transactions {
	
	boolean deposit(double amt);
	
	boolean withdraw(double amt);

}
