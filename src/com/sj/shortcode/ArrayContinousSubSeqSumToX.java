public class ArrayContinousSubSeqSumToX {
	
	public static void main(String args[]) {
		int[] arr = {23, 5, 4, 7, 2, 11,6,3};
		int sum = 20;
		
		System.out.println(subArraySum(arr,arr.length,sum));
	}

	/**
	 * Returns true if sum exist and false if sum doesn't exist
	 *
	 * @param arr
	 * @param n
	 * @param sum
	 * @return
	 */
	static int subArraySum(int arr[], int n, int sum) 
	{ 
		int curr_sum = arr[0], start = 0, i; 

		// Pick a starting point 
		for (i = 1; i <= n; i++) 
		{ 
			// If curr_sum exceeds the sum, then remove the starting elements 
			while (curr_sum > sum && start < i-1) 
			{ 
				curr_sum = curr_sum - arr[start]; 
				start++; 
			} 
			
			// If curr_sum becomes equal to sum, then return true 
			if (curr_sum == sum) 
			{ 
				int p = i-1; 
				System.out.println("Sum found between indexes " + start 
						+ " and " + p); 
				return 1; 
			} 
			
			// Add this element to curr_sum 
			if (i < n) 
			curr_sum = curr_sum + arr[i]; 
			
		} 

		System.out.println("No subarray found"); 
		return 0; 
	} 
}
