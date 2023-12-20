package exercise02;

public abstract class GameTester {
	public String name;
	public boolean fullTime;
	
	public GameTester(String name, boolean fullTime)
    {
        this.name = name;
        this.fullTime = fullTime;
    }
	
	public abstract int calcSalary();
}
