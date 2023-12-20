package exercise01;

import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;


public class Main {

	public static void main(String[] args) {
				
		String[] options = {"Health", "Life"};
		List<Insurance> insurances = new ArrayList<>();
		Insurance insurance;
				
		while(true) {
			
			int addPolicy = JOptionPane.showConfirmDialog(
					null,
		            "Would you like to add an Insurance Policy?", 
		            "INSURANCE APPLICATION", 
		            JOptionPane.YES_NO_OPTION);
			if(addPolicy == JOptionPane.NO_OPTION) break;
				
			int typeOfInsurance = JOptionPane.showOptionDialog(
						null, 
						"Select the type of Insurance", 
						"INSURANCE TYPE", 
						JOptionPane.DEFAULT_OPTION, 
						JOptionPane.QUESTION_MESSAGE, 
						null, options,null);
			
			String typeOfInsuranceSelected = "";
			
			switch(typeOfInsurance) {
			case 0: typeOfInsuranceSelected = "Health";
				break;
			case 1: typeOfInsuranceSelected = "Life";
				break;
			}
			
			Double monthlyCost = 0.0;
			
			String monthlyCostInput = JOptionPane.showInputDialog("Enter the apolice monthly cost: ");
			try {
				monthlyCost = Double.parseDouble(monthlyCostInput);
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Type only numbers to set the policy cost. Try again.", "Format Invalid", JOptionPane.ERROR_MESSAGE);
			}
			
			if(typeOfInsuranceSelected == "Health") {
				insurance = new Health(typeOfInsuranceSelected);
				insurance.setInsuranceCost(monthlyCost);
				
			} else {
				insurance = new Life(typeOfInsuranceSelected);
				insurance.setInsuranceCost(monthlyCost);
				
				
			}
			insurances.add(insurance);
									
		}
		
		for (Insurance insurance1 : insurances) {
            insurance1.displayInfo();
        }
	}
}
