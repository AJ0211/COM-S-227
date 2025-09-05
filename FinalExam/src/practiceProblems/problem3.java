package practiceProblems;

import java.util.Scanner;

public class problem3 {
	
	  public static void tryStuff(String text) {
		    int total = 0;
		    int i = 0;
		    Scanner scanner = new Scanner(text);
		    while (scanner.hasNext()) {
		      try {
		        String s = scanner.next();
		        i = Integer.parseInt(s);
		        total += i;
		      }
		      catch (NumberFormatException nfe)
		      {
		        total -= i;
		      }
		      System.out.println(total);
		    }
		  }

	
	public void main(String [] args) {
		tryStuff("10 20 23skidoo 30 foo bar");
	}
}
