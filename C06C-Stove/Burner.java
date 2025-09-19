

public class Burner {
	public enum Temperature {COOL, WARM, HOT, BLAZING};
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
				System.out.println("Shouldn't be called unless theres a problem");
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
				System.out.println("Shouldn't be called unless theres a problem");
		}
	}
	
/*
	//Updating temp or timer depending on timer
	public void updateTemperature() {
		if(this.timer == 0) {
			switch(mySetting) {
				case OFF:
					this.myTemperature = Temperature.COOL;
					break;
				case LOW:
					this.myTemperature = Temperature.WARM;
					break;
				case MEDIUM:
					this.myTemperature = Temperature.HOT;
					break;
				case HIGH:
					this.myTemperature = Temperature.BLAZING;
					break;
				default:
					System.out.println("Shouldn't print");
			}
			this.timer = TIME_DURATION;
		} else {
			//clock ticks down
			timer--;
		}
	}
*/
	public void updateTemperature() {
		//.ordinal() returns an enum's index in its declaration array
		// For example, since COOL comes first here, its ordinal is 0
		// and the ordinal of WARM is 1 etc.
		
		//This makes it a heck of a lot easier to compare these enum values
		
		int intTemp = myTemperature.ordinal();
		int intSetting = mySetting.ordinal();
		
		if(this.timer!=0) {//Don't do anything if the timer is set to 0
			timer--; //update timer
			if(timer==0) { //Is it time to do stuff?
				if(intTemp!=intSetting) {//If they don't match (ex: COOL and OFF, WARM and LOW etc.)
					this.timer=TIME_DURATION;//then things need to change
					//Bring temperature closer to matching setting
					if(intTemp>intSetting) {
						intTemp--;
					}
					else {
						intTemp++;
					}
					//set actual myTemperature based on adjusted intTemp
					myTemperature=Temperature.values()[intTemp];
				}
			}
			
		}
		
	}
	
	
	//Print in one line, the current setting, dots, and then a message depending on the temp.
	public void display() {
		System.out.print(this.mySetting);
		System.out.print("......");
		
		//Temperature message
		switch(myTemperature) {
			case COOL:
				System.out.print("coooool\n");
				break;
			case WARM:
				System.out.print("warm\n");
				break;
			case HOT:
				System.out.print("CAREFUL\n");
				break;
			case BLAZING:
				System.out.print("VERY HOT! DON'T TOUCH\n");
				break;
			default:
				System.out.println("Shouldn't print");
		}
	}
}
