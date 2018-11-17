/**
 *  11-1-16
 *  @author  Joseph Tinglof
 */

public class IRAAccount extends SavingsAccount {
	
	public int disbursementAge;
	public double earlyWithdrawalPenalty;

	public IRAAccount(java.lang.String holderName, double amount, double rate, int disbursementAge,
            double earlyWithdrawalPenalty){
		super(holderName, amount, rate);
		this.disbursementAge = disbursementAge;
		this.earlyWithdrawalPenalty = earlyWithdrawalPenalty;
	}
	
	public int getDisbursementAge(){
		return disbursementAge;
	}
	
	public void setDisbursementAge(int disbursementAge){
		this.disbursementAge = disbursementAge;
	}
	
	public double getEarlyWithdrawalPenalty(){
		return earlyWithdrawalPenalty;
	}
	
	public void setEarlyWithdrawalPenalty(double earlyWithdrawalPenalty){
		this.earlyWithdrawalPenalty = earlyWithdrawalPenalty;
	}

	public java.lang.String toString(){
		return "IRA "+super.toString()+", Disbursement Age="+getDisbursementAge()+
				", Early Withdrawal Penalty="+getEarlyWithdrawalPenalty();
	}

}
