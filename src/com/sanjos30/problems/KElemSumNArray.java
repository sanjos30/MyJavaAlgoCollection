package com.sanjos30.problems;

//Find K elem whose sum is n
public class KElemSumNArray {

	public static void main(String[] args) {
		
		int arr[]= {1,2,3,4,5,6,7,8,9};
		int k=3;
		int n=9;

		getElemWithSumN(arr,k,n);
	}

	
	
	/**
	 * 
	 * The algo is broken into 3 parts:
	 * 
	 * 1)   Starting from 0th index, do a linear scan to 
	 * 		find first k elements whose sum is n; If you find one, add 
	 * 		to result array and continue with the (i+1)th element
	 * 
	 * 2)   Repeat the 1st part until you find a part with sum K
	 * 
	 * 
	 * @param arr
	 * @param k
	 * @param n
	 */
	private static void getElemWithSumN(int[] arr, int k, int n) {
		
		int length=arr.length;
		
		//Section 1
		for(int i=0;i<length;i++) {
				int sum_so_far=arr[i];
				for(int j=i;j<length;j++) {
					sum_so_far=sum_so_far+arr[j];
					
					if(sum_so_far==n && (j-i)<=k) {
						
						break;
						
					}
					
				}
			
		}
		
		
	}

}
