package exercise03;

public abstract class Mortgage implements MortgageConstants{
	public int mortgageNumber;
	public String customerName;
	public double amount;
	public double interestRate;
	public int term;
	
	public Mortgage (int mortgageNumber, String customerName, double amount, double interestRate, int term ) {
		this.mortgageNumber = mortgageNumber;
		this.customerName = customerName;
		
		//maxAmount
		if(amount <= maxAmount)this.amount = amount;
		else this.amount = maxAmount;
		
		this.interestRate = interestRate;
		
		//term
		if(term == 1 ) {
			this.term = shortTerm;
		} else if (term == 3) {
			this.term = mediumTerm;
		} else if( term == 5) {
			this.term=longTerm;
		}else {
			this.term = shortTerm;
		}
		
	}
	
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
