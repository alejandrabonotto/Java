package exercise02;

public class FullTimeGameTester extends GameTester {
	
	public FullTimeGameTester(String name) {
		super(name, true);
	}
	
	@Override
	public int calcSalary() {
		return 3000;
	}

}
