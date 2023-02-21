
public class CameraBattery {
	
	public static final int NUM_CHARGER_SETTINGS = 4; 
	public static final double CHARGE_RATE = 2.0; 
	public static final double DEFAULT_CAMERA_POWER_CONSUMPTION = 1.0;
	public int chargerSetting = 0;
	public double charge;
	public double capacity;
	public CameraBattery(double batteryStartingCharge, double batteryCapacity) {
		charge = batteryStartingCharge;
		capacity = batteryCapacity;
	}
	
	public void buttonPress() {
		//User has pressed setting button on external charger, wraps around to 0 if at max
		chargerSetting++;
	}
	public double cameraCharge(double minutes) {
		//Charges battery if connected, can't exceed maximum capacity of the battery, or if its not connected 
		charge = minutes * CHARGE_RATE;
		return 0;
	}
	public double drain(double minutes) {
		//Drains battery if connected, can't exceed the amount of charge, or if not connected
		return 0;
	}
	public double externalCharge(double minutes) {
		//Charges if connected to external charger
		return 0;
	}
	public void resetBatteryMonitor() {
		//resets battery monitoring system by setting total battery drain back to 0
		
	}
	public double getBatteryCapacity() {
		//returns the batteries capacity 
		return capacity;
	}
	public double getBatteryCharge() {
		//returns the batteries current charge
		return charge;
	}
	public double getCameraCharge() {
		//returns the current charge of the cameras battery
		return 0;
	}
	public double getCameraPowerConsumption() {
		//returns cameras power consumption
		return 0;
	}
	public int getChargerSetting() {
		//get external charge setting
		return 0;
	}
	public double getTotalDrain() {
		//total amount of battery drained since the last time it was reset
		return 0;
	}
	public void moveBatteryExternal() {
		//moves the battery to the external charger
		
	}
	public void moveBatteryCamera() {
		//moves the battery to the camera
		
	}
	public void removeBattery() {
		//removes he battery from the camera or external charger
		
	}
	public void setCameraPowerConsumption(double cameraPowerConsumption) {
		//sets the power consumption of the camera
	}
	
	
}
