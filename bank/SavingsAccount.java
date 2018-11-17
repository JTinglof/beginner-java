/**
 *  11-1-16
 *  @author  Joseph Tinglof
 */

public class SavingsAccount extends Account {
	
	public double rate;

	public SavingsAccount(){}
	
	public SavingsAccount(String holderName, double amount, double rate){
		super(holderName, amount);
		this.rate = rate;
	}

	@Override
	public void updateAccount() {
		setAccountBalance(getAccountBalance()*(1+rate));

	}
	
	public java.lang.String toString(){
		return String.format("Savings account "+super.toString()+" Balance: $%.2f", getAccountBalance());
	}

}
