package com.sanjos30.problems;

import java.util.HashMap;
import java.util.Map;

public class FindArrayElemWithSumX {

	public static void main(String[] args) {
		
		int[] arr= {1,4,2,7,6,10,5};
		
		int k=12;

		findElemWithSumK(arr,k);
		
	}

	private static void findElemWithSumK(int[] arr, int k) {

	Map<Integer,Integer> hMap=new HashMap<Integer,Integer>();
		
		for(int i:arr) {
			
			if(!hMap.containsKey(i))
				hMap.put(i, 1);
			else {
				int count=hMap.get(i);
				hMap.put(i, ++count);				
			}
		}
		
		int count=0;
		for(int i:arr) {
			int temp=k-i;
			
			if(hMap.containsKey(temp)) {
				
				count++;
				System.out.println(i + ", " + temp);
			}
				
			
		}
		
		System.out.println(count);
	}

}
