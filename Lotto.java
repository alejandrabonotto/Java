package exercise02;

import java.security.SecureRandom;

//Design a Lotto class
public class Lotto {
	
	//include one array instance variable to hold three random integer values
	int[] lottoNumbers = new int[3];
	
	//Include a constructor randomly populates the array for a lotto object:
	public Lotto() {
		SecureRandom randomNumbers = new SecureRandom();
		for(int i = 0; i < 3; i++) {
			lottoNumbers[i] = randomNumbers.nextInt(9) + 1;
		}
	}
	
	//include a method in the class to return the array.
	
	public int[] getLottoNumbers() {
		return lottoNumbers;
	}
	
	//method to sum the numbers in the array
	public int sumLottoNumbers() {
		int sum = 0;
		
		for (int lottoNumber : lottoNumbers) {
			sum += lottoNumber;
		}
		
		return sum;
	}
	

}
