package com.sanjos30.helper;

import java.util.HashMap;
import java.util.List;

public class StringHelper {

	/**
	 * Check if the string is numeric - returns true if yes
	 * @param s
	 * @return
	 */
	public static boolean isNumeric(String s){
	    return s!=null && s.matches("[-+]?\\d*\\.?\\d+");
	}
	
	
	public static boolean isAlphaNumericString(String str) {
		boolean isAlphaNumeric=false;
		
		return isAlphaNumeric;
	}
	
	public static boolean isAnagram(String str1, String str2) {
		boolean isAnagram=false;
		
		return isAnagram;
	}
	
	public static boolean isPalindromString(String str) {
		boolean isPalindromeString=false;
		
		return isPalindromeString;
	}
	
	public static List<String> findAnagram(String str){
		List<String> strAnagramList=null;
		
		return strAnagramList;
	}
	
	public static HashMap<String,Integer> charCountInInputString(String str) {
		HashMap<String,Integer> charCountMap=new HashMap<String,Integer>();
		
		return charCountMap;
	}
	
	public static int[] findUniqueCharPrefixSum(String str) {
		int[] strPrefixSum=new int[str.length()];
		
		return strPrefixSum;
	}
}
