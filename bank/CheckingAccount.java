/**
 *  11-1-16
 *  @author  Joseph Tinglof
 */

public class CheckingAccount extends Account {
	
	private double costPerMonth;
	
	public CheckingAccount() {}
	
	public CheckingAccount(String holderName, double amount, double costPerMonth){
		super(holderName, amount);
		this.costPerMonth = costPerMonth;
	}

	@Override
	public void updateAccount() {
		setAccountBalance(getAccountBalance()-costPerMonth);
	}
	
	public java.lang.String toString(){
		return String.format("Checking account "+super.toString()+" Balance: $%.2f", getAccountBalance());
	}

}
