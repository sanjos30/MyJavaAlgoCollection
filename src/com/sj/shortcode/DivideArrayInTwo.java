package com.sj.shortcode;

import java.util.Stack;

/**
 * Divide an array in two parts
 * 
 * @author Sanjos30
 *
 */
public class DivideArrayInTwo {

	public static void main(String[] args) {

		int[] arr = { 1, 2, 2, 2, 3, 4, 3, 4, 5 };

		Stack<Integer> stck = new Stack<Integer>();

		for (int i = 0; i < arr.length; i++) {
			int elem = arr[i];
			if (!stck.isEmpty()) {
				if (stck.peek() == elem - 1) {
					stck.push(elem);
				}

			} else {
				stck.push(elem);
			}

		}

		for (int a : stck) {
			System.out.println(a);
		}

		for (int b : arr) {
			System.out.println(b);
		}
	}

}
