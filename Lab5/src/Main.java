import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String name = "";
		System.out.println("Enter your full name: ");
		name = scan.nextLine();
		System.out.println("Your initals are: " + Initals(name));
		System.out.println("The first vowel is at: " + Vowel(name));
	}
	public static String Initals(String name) {
		String initals = "";
		initals += name.charAt(0);
		for(int i = 1; i < name.length() - 1; i++) 
            if(name.charAt(i) == ' ')
            	initals += name.charAt(i+1);
		
		return initals;
	}
	
	public static int Vowel(String str){
		int location = 0;
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == 'a' || str.charAt(i) == 'A') {
				location = i;
				return location;
			}
			if(str.charAt(i) == 'e' || str.charAt(i) == 'E'){
				location = i;
				return location;
			
			}
			if(str.charAt(i) == 'i' || str.charAt(i) == 'I') {
				location = i;
				return location;
				
			}
			if(str.charAt(i) == 'o' || str.charAt(i) == 'O' ) {
				location = i;
				return location;
			}
			if(str.charAt(i) == 'u' || str.charAt(i) == 'U') {
				location = i;
				return location;
			}
		}
		return -1;
	}
}
