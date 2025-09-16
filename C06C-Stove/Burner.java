
public class Burner {
	public enum Temperature {BLAZING, HOT, WARM, COOL};
	private Temperature myTemperature;
	private Setting mySetting;
	private int Timer;
	public static final int TIME_DURATION = 2;
	
	//Constructor for burner
	

	public Temperature getTemp() {
		return myTemperature;
	}
	
	public Burner(Burner.Temperature myTemperature, Setting mySetting, int timer) {
		super();
		this.myTemperature = myTemperature.COOL;
		this.mySetting = mySetting.OFF;
		Timer = timer;
	}

	//All functions we need

	//Hitting the plus button
	public void plusButton() {
		System.out.println("you hit the plus button");
	}

	//Hitting minus button
	public void minusButton() {
		System.out.println("You hit the minus button");
	}
	
	//Updating temp
	public void updateTemperature() {
		System.out.println("You are updating temps");
	}
	
	public void display() {
		System.out.println("Priting stove");
	}
}
