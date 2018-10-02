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
