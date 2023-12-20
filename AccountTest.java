package exercise01;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//creating account test class
public class AccountTest {

	public static void main(String[] args) {
		
		Account a = new Account(25000.00);

	    //ArrayList to create a list of three or more Transaction objects
	    ArrayList<Transaction> transactions = new ArrayList<>();

	    transactions.add(new Transaction(a, "Deposit", 1500.50));
	    transactions.add(new Transaction(a, "Deposit", 4500.00));
	    transactions.add(new Transaction(a, "Withdraw", 500.50));
	    transactions.add(new Transaction(a, "Withdraw", 35600.50));

	    //using ExecutorService 
	    ExecutorService executorService = Executors.newFixedThreadPool(2);

	    //using threads
	    Thread thread1 = new Thread(new Transaction(a, "Deposit", 8000.50));
	    Thread thread2 = new Thread(new Transaction(a, "Withdraw", 3000.0));

	    executorService.execute(thread1);
	    executorService.execute(thread2);

	    for (Transaction transaction : transactions) {
	    	executorService.execute(transaction);
	    }

	    executorService.shutdown();

	}

}
