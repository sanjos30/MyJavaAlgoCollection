package com.sanjos30.problems;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class JavaMaxKElems {

	public static void main(String args[]) {
		
		PriorityQueue<Integer> n=new PriorityQueue<Integer>(10, new Comparator<Integer>() {
			 public int compare(Integer o1, Integer o2){
	                return o2 - o1;
	            }
		});
		
		
		n.add(10);
		n.add(12);
		
		n.add(13);
		n.add(14);
		n.add(15);
		n.add(16);
		n.add(17);
		
		n.poll();
		
		System.out.println(n);

		//System.out.println(n);
		
		
		
		
		PriorityQueue<Integer> n1=new PriorityQueue<Integer>(10);
		
		n1.add(1);
		n1.add(121);
		n1.add(12);
		n1.add(1222);

		System.out.println(n1);
	}
	
	
	
}
