package com.sanjos30.helper;

public class NumberHelper {

	public static void main(String args[]) {
		System.out.println(isEvenNumber(50));
	}
	
	/**
	 * Returns the square of a number
	 * 
	 * @param num
	 * @return
	 */
	public static double findSquareOfNumber(int num) {
		return num*num;
	}
	
	public static boolean isEvenNumber(int n) {
		if(n%2==0) {
			return true;
		}else
			return false;
	}
	
	/**
	 * Returns the square root of a given number
	 * 
	 * @param num
	 * @return
	 */
	public static double findSquareRoot(double num) {
		if(num>0)
			return Math.sqrt(num);
		else 
			return 0;
	}
	
	public static double findSumOfDigits(int num) {
		long sum=0;
		
		return sum;
	}
	
	public static boolean isPowerOfK(int num, int k) {
		boolean isPowerOfK=false;
		
		return isPowerOfK;
	}
}
