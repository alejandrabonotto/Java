package exercise01;

import javax.swing.JOptionPane;

public class Life extends Insurance {

	public Life(String typeOfInsurance) {
			super (typeOfInsurance);
	}

	@Override
	public void setInsuranceCost(double monthlyCost) {
		this.monthlyCost = monthlyCost;
	}

	@Override
	public void displayInfo() {
		
		JOptionPane.showMessageDialog(null,
				"Type:  " + typeOfInsurance +
				" || Cost:  $ " + monthlyCost);
	}
}
