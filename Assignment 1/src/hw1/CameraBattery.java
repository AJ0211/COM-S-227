package hw1;

public class CameraBattery {
	//number of settings
	public static final int NUM_CHARGER_SETTINGS = 4; 
	//default charge rate
	public static final double CHARGE_RATE = 2.0; 
	//default power consumption
	public static final double DEFAULT_CAMERA_POWER_CONSUMPTION = 1.0;
	//tracks the setting of the charger
	private int chargerSetting = 0;
	//tracks the amount of charge in the battery
	private double batteryCharge;
	//tracks the amount of charge in the battery in the camera
	private double cameraCharge;
	//tracks the amount of charge in the battery in the external charger
	private double externalCharger;
	//static value of the capacity of the battery
	private double batteryCapacity;
	//allows the static value of the default consumption to be changed
	private double consumption = DEFAULT_CAMERA_POWER_CONSUMPTION;
	//tracks the total amount the battery has been change by 
	private double totalDrained;
	//tracks how much the battery is drained by when the method drain() is called
	private double drained;
	//tracks if the battery is in the camera
	private int inCamera;
	//tracks if the battery is in the external charger
	private int inCharger;
	//used to show how much the battery changed when the externalCharge method was called
	private double changeInCharge;
	//used to hold temporary values
	private double temp;
	/*
	 * constructor 
	 * @param batteryStartingCharge
	 * @param startingBatteryCapacity
	 */
	public CameraBattery(double batteryStartingCharge, double startingBatteryCapacity) {
		batteryCharge = Math.min(batteryStartingCharge, startingBatteryCapacity);
		batteryCapacity = startingBatteryCapacity;
	}
	/*
	 * simulates a button press
	 */
	public void buttonPress() {
		//User has pressed setting button on external charger, wraps around to 0 if at max
		chargerSetting = (chargerSetting + 1) % NUM_CHARGER_SETTINGS;
	}
	/*
	 * increases the charge of the battery if connected to the camera
	 * @param minutes
	 * @return amount charged
	 */
	public double cameraCharge(double minutes) {
		//Charges battery if connected, can't exceed maximum capacity of the battery, or if its not connected 
		temp = cameraCharge;
		cameraCharge += Math.min((batteryCapacity - cameraCharge), (minutes * CHARGE_RATE)) * inCamera;
		batteryCharge += Math.min((batteryCapacity - cameraCharge), (minutes * CHARGE_RATE)) * inCamera;
		return cameraCharge - temp;
	}
	/*
	 * simulates draining the battery if connected to the camera
	 * @param miutes
	 * @return ammount drained
	 */
	public double drain(double minutes) {
		//Drains battery if connected, can't exceed the amount of charge, or if not connected
		drained = consumption * minutes;
		drained = Math.min(drained,batteryCharge) * inCamera;
		totalDrained += drained; 
		
		batteryCharge -= (drained) * inCamera;
		cameraCharge -= (drained) * inCamera;
		
		return drained;
	}
	/*
	 * increases the charge of the battery if connected to the external charger
	 * @param minutes
	 * @return amount charged
	 */
	public double externalCharge(double minutes) {
		//Charges if connected to external charger
		temp = externalCharger;
		externalCharger = Math.min((minutes * chargerSetting * CHARGE_RATE),(batteryCapacity - batteryCharge)) * inCharger;
		batteryCharge += Math.min(batteryCapacity, externalCharger);
		changeInCharge = batteryCharge - temp;
		return Math.max(0, changeInCharge);
	}
	public void resetBatteryMonitor() {
		//resets battery monitoring system by setting total battery drain back to 0
		totalDrained = 0;
	}
	public double getBatteryCapacity() {
		//returns the batteries capacity 
		return batteryCapacity;
	}
	public double getBatteryCharge() {
		//returns the batteries current charge
		return Math.max(0, batteryCharge);
	}
	public double getCameraCharge() {
		//returns the current charge of the cameras battery
		return Math.max(0, cameraCharge);
	}
	public double getCameraPowerConsumption() {
		//returns cameras power consumption
		return consumption;
	}
	public int getChargerSetting() {
		//get external charge setting
		return chargerSetting;
	}
	public double getTotalDrain() {
		//total amount of battery drained since the last time it was reset
		return totalDrained;
	}
	public void moveBatteryExternal() {
		//moves the battery to the external charger
		externalCharger = batteryCharge;
		inCharger = 1;
		inCamera = 0;
		cameraCharge = 0;
	}
	public void moveBatteryCamera() {
		//moves the battery to the camera
		cameraCharge = batteryCharge;
		inCharger = 0;
		inCamera = 1;
		externalCharger = 0;
	}
	public void removeBattery() {
		//removes he battery from the camera or external charger
		inCamera = 0;
		cameraCharge = 0;
		
	}
	public void setCameraPowerConsumption(double cameraPowerConsumption) {
		//sets the power consumption of the camera
		consumption = cameraPowerConsumption;
	}
	
	
}
