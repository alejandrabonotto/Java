package exercise01;


//creating class Account
public class Account {
    
	private double balance;

    
    public Account(double balance) {this.balance = balance;} //constructor

    //depositing operation
    public synchronized void deposit(double depositAmount)
    {
        balance = balance + depositAmount;
        System.out.println("DEPOSIT: \t$\t" + depositAmount  );
        System.out.println("BALANCE: \t$\t" + balance);
    }

    //withdrawing operation
    public synchronized void withdraw(double withdrawAmount)
    {
        if (withdrawAmount <= balance)
        {
            balance = balance - withdrawAmount;
            System.out.println("WITHDRAW: \t$\t" + withdrawAmount);
            System.out.println("BALANCE: \t$\t" + balance);
        }
        else {
            System.out.println("\nYOU CANNOT WITHDRAW: \t$\t" + withdrawAmount);
            System.out.println("YOUR BALANCE IS: \t$\t" + balance);
            System.out.println("MAKE A DEPOSIT FIRST OR ASK YOUR MANAGER LOANS OPTIONS");
        }
    }

}
