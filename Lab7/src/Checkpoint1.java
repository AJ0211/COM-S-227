
public class Checkpoint1 {
	
	public static int getPyramidCount(int n){
		int count = 0;
		if(n == 1)
			return 1;
		count += n * n + (getPyramidCount(n-1));
		return count;
		
		
	}
	
	public static int max(int[] arr, int start, int end) {
		if (start == end){
	      return arr[start];
	    }
	    else{
	      int mid = (start + end) / 2;
	      int leftSum = max(arr, start, mid);
	      int rightSum = max(arr, mid + 1, end);
	      
	      if(leftSum > rightSum)
	    	  return leftSum;
	      else
	    	  return rightSum;
	    }
	}
	
	
	
	public static void main(String[] args) {
		int[] nums = {4,2,2,96,27,5};
		//System.out.println(max(nums, 0, 5));
		System.out.println(getPyramidCount(3));
	}
}
