
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
		//update timer
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
		//update timer
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
	
	//Updating temp or timer depending on timer
	public void updateTemperature() {
		if(this.timer == 0) {
			turnBurnersUp();
			this.timer = TIME_DURATION;
		} else {
			//clock ticks down
			timer--;
		}
	}
	
	//Turning burners up whenever the temps are updated
	public void turnBurnersUp() {
		switch(myTemperature) {
			case COOL:
				this.myTemperature = Temperature.WARM;
				break;
			case WARM:
				this.myTemperature = Temperature.HOT;
				break;
			case HOT:
				this.myTemperature = Temperature.BLAZING;
				break;
			case BLAZING:
				this.myTemperature = Temperature.BLAZING;
				break;
			default:
				System.out.println("Shouldnt print");
		}
	}
	
	public void display() {
		System.out.println("Priting stove");
	}
}
