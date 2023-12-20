package exercise03;

public class BusinessMortgage extends Mortgage{
	
	public BusinessMortgage(int mortgageNumber, String customerName, double amount, int interestRate, int term){
		super(mortgageNumber, customerName, amount *(1 + 0.01), interestRate, term);
	}
	
	@Override
	public String getMortgageInfo() {
		return 
				"\n\n**********" + bank + "**********" +
				
				"\n\nMortgage: " + mortgageNumber +
				" || Customer: " + customerName +
				" || Loan amount: " + amount +
				" || Rate: " + interestRate +
				" || Loan Term: " + term;
	}

}
