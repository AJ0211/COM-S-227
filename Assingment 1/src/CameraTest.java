
public class CameraTest {

	public static void main(String[] args) {
		CameraBattery cb = new CameraBattery(1000, 2000); 
		System.out.println("Test 1:"); 
		System.out.println("Battery charge is " + cb.getBatteryCharge() + " expected 1000.0"); 
		System.out.println("Camera charge is " + cb.getCameraCharge() + " expected 0.0"); 

	}

}
