package exercise03;

public class Main {

	public static void main(String[] args) {
		
		Overloaded s1 = new Overloaded();
		
		System.out.println("OVERLOADED METHODS");
		System.out.println("\nFirst sum method: \t" + s1.sum(5,10));
		System.out.println("\nSecond sum method: \t" + s1.sum(10, 20, 30));
		System.out.println("\nThird sum method: \t" + s1.sum(2, 4, 6, 8));

	}

}
