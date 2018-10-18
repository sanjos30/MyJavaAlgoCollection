package com.sanjos30.problems;

import java.util.HashSet;
import java.util.Set;

public class FindDuplicateInArrayWithLengthRestriction {

	public static void main(String[] args) {
		
		int[] a1= {2,3,1,4,1,4,5,2,1};
		int[] a2= {1,2,1};
		
		findDuplicates(a1);

	}

	private static void findDuplicates(int[] a2) {
		
		int n=a2.length;
		Set<Integer> st=new HashSet<Integer>();
		
		for(int a:a2) {
			
			if(!st.add(a)) {
				System.out.println(a + " ");
			}
		}
	}

}
