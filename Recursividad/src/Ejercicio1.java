
public class Ejercicio1 {

	private static int producto(int[] A, int n, int left, int i) {
		if (i == n) {
			return 1;
		}

		// take backup of the current element
		int curr = A[i];

		// calculate the product of the right subarray
		int right = producto(A, n, left * A[i], i + 1);

		// replace the current element with the product of the left and right subarray
		A[i] = left * right;

		// return product of right the subarray, including the current element
		return curr * right;
    }
	
	public static void main(String[] args) {
		//int[] array = {4,7,3,2,1};
		int[] array = {1,20,3,40,5,6,7,8,9};
		//producto(array, array.length, 1, 0);
		
		//for (int i : array) {
			//System.out.println(i);
		//}
		
		int indice = findPeakElement(array, 0, array.length-1);
		System.out.println(indice);
	}
	
	
	
	
	
	
	
	
	
	
	 public static int binarySearch(int[] nums, int left, int right, int target)
	    {
	        // Base condition (search space is exhausted)
	        if (left > right) {
	            return -1;
	        }
	 
	        // find the mid-value in the search space and
	        // compares it with the target
	 
	        int mid = (left + right) / 2;
	 
	        // overflow can happen. Use below
	        // int mid = left + (right - left) / 2;
	 
	        // Base condition (a target is found)
	        if (target == nums[mid]) {
	            return mid;
	        }
	 
	        // discard all elements in the right search space,
	        // including the middle element
	        else if (target < nums[mid]) {
	            return binarySearch(nums, left, mid - 1, target);
	        }
	 
	        // discard all elements in the left search space,
	        // including the middle element
	        else {
	            return binarySearch(nums, mid + 1, right, target);
	        }
	    }
	 
	 public static int findPeakElement(int[] nums, int left, int right) {
		// find the middle element. To avoid overflow, use mid = low + (high - low) / 2
	        if(left>right) {
	        	return -1;
	        }
		 
		 	int mid = (left + right) / 2;
	 
	        // check if the middle element is greater than its neighbors
	        
	        if(nums[mid]>nums[mid+1] && nums[mid]>nums[mid-1]) {
	        	return nums[mid];
	        }
	        else if(nums[mid - 1] > nums[mid]) {
	        	return findPeakElement(nums, left, mid - 1);
	        } else {
	        	return findPeakElement(nums, mid+1, right);
	        }
	        
	        
	        
	        
	        
	        
	        
	 }
}
