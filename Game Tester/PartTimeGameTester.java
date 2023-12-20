package exercise02;

public class PartTimeGameTester extends GameTester {
	
	int hours; 
	
	public PartTimeGameTester (String name, int hours) {
		super(name,false);
		this.hours=hours;
		
	}
	
	@Override
	public int calcSalary() {
		return hours*20;
	}

}
