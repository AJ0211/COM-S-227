import java.io.File;

public class Checkpoint2 {
	
	public static int countPatterns(int n) {
		if(n == 0)
			return 1;
		if(n <= 0)
			return 0;
		
		int ways = 0;
		ways += countPatterns(n - 1);
		ways += countPatterns(n - 3);
		
		return ways;
	}
	
	public static int countFiles(File f) {
			//base case
		int count = 0;
			if(f.isFile()) {
				System.out.println("File: " + f.getName());
				return 1;
			}
			
			//recursion
			File[] subFiles = f.listFiles();
			for(File subFile : subFiles)
				count += countFiles(subFile);
			return count;
		}

	public static void main(String[] args) {
		File file = new File(".");
		//System.out.println(countFiles(file));
		System.out.println(countPatterns(4));

	}

}
