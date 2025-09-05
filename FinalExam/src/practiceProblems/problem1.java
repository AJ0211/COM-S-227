package practiceProblems;

import java.util.ArrayList;
import java.util.Scanner;

public class problem1 {
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
	
	public static ArrayList<String> ways(int n){
		ArrayList<String> result = new ArrayList<String>();
		if(n == 0) {
			result.add("");
			return result;
		}
		if(n < 0) {
			return result;
		}
		
		ArrayList<String> way1 = ways(n-1);
		ArrayList<String> way2 = ways(n-2);
		ArrayList<String> way3 = ways(n-3);
		
		for(String s: way1) {
			result.add("1" + s);
		}
		for(String s: way2) {
			result.add("2" + s);
		}
		for(String s: way3) {
			result.add("3" + s);
		}
		return result;
	}
	
	public static int howManyWays(int n) {
		int count = 0;
		if(n == 0 || n== 1) {
			return 1;
		}
		if(n <= 1) {
			return 0;
		}
		count += howManyWays(n-1);
		count += howManyWays(n-2);
		count += howManyWays(n-3);
		return count;
	}
	
	
	public static void main(String[] args) {
		//System.out.println(howManyWays(3));
		//System.out.println(ways(10));
		tryStuff("10 20 23skidoo 30 foo bar");
	}

}
