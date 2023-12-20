package exercise01;

//Use Java Runnable interface to implement a Transaction class
public class Transaction implements Runnable{
	
	private Account account;
	private String transaction;
	private double transactionAmount; 
	
	//constructor
	public Transaction (Account account, String transaction, double transactionAmount) {
		this.account = account;
		this.transaction = transaction;
		this.transactionAmount = transactionAmount;
		
	}
	//Perform withdraw and deposit operations in run method
	@Override
	public void run() {
		String deposit = "Deposit";
		String withdraw = "Withdraw";
		
		if (deposit.equals(transaction)) {
			account.deposit(transactionAmount);
		} else if (withdraw.equals(transaction)) {
			account.withdraw(transactionAmount);

		}
		
	}

}
