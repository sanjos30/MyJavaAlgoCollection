package com.sanjos30.problems;

import java.util.LinkedList;
import java.util.Queue;

public class IceCreamChangeProblem {

	public static void main(String[] args) {


		int[] cust1= {5,5,5,10};
		
		int[] cust2= {5,10,5,5,20};
		
		int[] cust3= {5,5,10,20};
		
		System.out.println(isChangeable(cust3));

	}

	/**
	 * Keep a count of only 10 and 5 dollars.
	 * Below use case arises:
	 * 
	 * 1) The first elem should always be 5 - Increment the counter
	 * 2) The second elem can only be a 5 or 10 - If it's a ten, increment the 10 counter and decrement the 5 counter
	 * 3) The third element & hereforth can either be 5, 10 or 20. In case it is twenty below use case arises:
	 * 		If count of 10 and count of 5 is greater than 1, then decrement them each
	 * 		If the count of 10 is 0 and 5 count is greater than 2, then decrement the 5 counter by 3
	 * 		else return a false
	 * 
	 * 
	 * @param dollars
	 * @return
	 */
	
	private static boolean isChangeable(int[] dollars){
		if(dollars == null || dollars.length == 0)
			return true;
		int fiveCount = 0;
		int tenCount = 0;
		for(int i : dollars){
			if(i == 5){
				++fiveCount;
			} else if(i == 10){
				if(fiveCount < 1){
					return false;
				}
				++tenCount;
				--fiveCount;
			} else if(i == 20){
				if(tenCount > 0 && fiveCount > 0){
					--tenCount;
					--fiveCount;
				}else if (fiveCount > 2){
					fiveCount -= 3;
				}else{
					return false;
				}
			}
		}
		return true;
	}
	
	


}
