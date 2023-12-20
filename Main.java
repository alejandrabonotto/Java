package exercise02;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		
		boolean userGuessed = false;
		
		for(int i = 0; i < 5; i++) {
			Lotto lotto1 = new Lotto();
			int sum = lotto1.sumLottoNumbers();
			
			System.out.println(sum);
			
			String userInput = JOptionPane.showInputDialog("Choose a number between 3 and 27: ");
			int userGuess = Integer.parseInt(userInput);
			
			if (userGuess == sum ) {
				JOptionPane.showMessageDialog(null, "Congratulations! You win!");
				userGuessed = true;
				break;
			}
		}
		
		if(!userGuessed) {
		JOptionPane.showMessageDialog(null, "Game over!");
		}
	}

}
