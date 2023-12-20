package exercise03;

import java.util.Scanner;

public class ProcessMortgage {

	public static void main(String[] args) {
		
		int mortgageNumber = 0;
		String customerName = "";
		Double amount = 0.0;
		Double interestRate = 0.0; 
		int term = 0;
		Mortgage[] mortgages = new Mortgage[3];
	
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Welcome to City Toronto Bank - Mortgage Application");
		System.out.print("What is your current interest rate?\t ");
		interestRate = Double.parseDouble(scanner.nextLine());
		
		for (int i = 0; i <3; i++){
			System.out.println("\nChoose type of Mortgage");
			System.out.print("1. Business or 2. Personal: \t");
			int choice = Integer.parseInt(scanner.nextLine());
			
			System.out.println("\nPlease, provide the data below");
			
			System.out.print("\nMortgage number: \t");
			mortgageNumber = Integer.parseInt(scanner.nextLine());
			
			System.out.print("Customer name: \t\t");
			customerName = scanner.nextLine();
			
			System.out.print("Loan amount: \t\t");
			amount = Double.parseDouble(scanner.nextLine());
			
			System.out.print("Loan term: \t\t");
			term = Integer.parseInt(scanner.nextLine());
			
			if(choice == 1) {
				mortgages[i] = new PersonalMortgage(mortgageNumber, customerName, amount, interestRate, term);	
			} else if(choice ==2) {
				mortgages[i] = new PersonalMortgage(mortgageNumber, customerName, amount, interestRate, term);	
			} else {
				System.out.println("Invalid Option. Try again");
				i--;
			}
			
		}
		
		for (int i = 0; i <3; i++){
			 if (mortgages[i] != null) {
	                System.out.print(mortgages[i].getMortgageInfo());
			 }	
		}
	}
}
