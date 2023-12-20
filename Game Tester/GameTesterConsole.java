package exercise02;

import java.util.Scanner;

public class GameTesterConsole {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("**Welcome to Game Tester Application**\n\n");
		System.out.print("Provide the data below");
		System.out.print("Game Tester's name:\t");
		String name = scanner.nextLine();
				
		System.out.print("Full-Time (1) or Part-Time (2):\t\t\t");
		int userChoice = Integer.parseInt(scanner.nextLine());
		
		if (userChoice == 1) {
			FullTimeGameTester fullTimeTester = new FullTimeGameTester (name);
			System.out.println("\n**Object fullTimeTester created**");
			System.out.print("\nFull-Time Game Tester " + name 
			+ " earns $" + fullTimeTester.calcSalary() + " per month.");
		}else if (userChoice == 2) {
			System.out.print("Hours worked (int):\t\t\t\t");
			int hours = Integer.parseInt(scanner.nextLine());
			PartTimeGameTester partTimeTester = new PartTimeGameTester (name, hours);
			System.out.println("\n**Object partTimeTester created**");
			System.out.print("\nPart-Time Game Tester " + name 
			+ " earns a total of $" + partTimeTester.calcSalary() + ".");
			
		}else {
			System.out.print("Invalid choice. Try again");
		}
		
		scanner.close();
	}
}
