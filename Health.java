package exercise01;

import javax.swing.JOptionPane;

public class Health extends Insurance {

	public Health(String typeOfInsurance) {
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
