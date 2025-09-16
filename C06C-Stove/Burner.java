
public class Burner {
	public enum Temperature {BLAZING, HOT, WARM, COOL};
	private Temperature myTemperature;
	private Setting mySetting;
	private int timer;
	public static final int TIME_DURATION = 2;
	
	//enum getter
	public Temperature getTemp() {
		return myTemperature;
	}
	
	//Constructor for burner
	public Burner() {
		super();
		this.myTemperature = Temperature.COOL;
		this.mySetting = Setting.OFF;
		this.timer = 0;
	}

	//All functions we need

	//Hitting the plus button
	public void plusButton() {
		this.timer = TIME_DURATION;
		switch(mySetting) {
			case OFF:
				mySetting = Setting.LOW;
				break;
			case LOW:
				mySetting = Setting.MEDIUM;
				break;
			case MEDIUM:
				mySetting = Setting.HIGH;
				break;
			case HIGH:
				mySetting = Setting.HIGH;
				break;
			default:
				System.out.println("Shouldnt be called unless theres a problem");
		}
	}

	//Hitting minus button
	public void minusButton() {
		this.timer = TIME_DURATION;
		switch(mySetting) {
			case HIGH:
				mySetting = Setting.MEDIUM;
				break;
			case MEDIUM:
				mySetting = Setting.LOW;
				break;
			case LOW:
				mySetting = Setting.OFF;
				break;
			case OFF:
				mySetting = Setting.OFF;
				break;
			default:
				System.out.println("Shouldnt be called unless theres a problem");
		}
	}
	
	//Updating temp
	public void updateTemperature() {
		//update temp
	}
	
	public void display() {
		System.out.println("Priting stove");
	}
}
