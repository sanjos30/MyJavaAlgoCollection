package com.sanjos30.problems;

import java.util.TreeMap;

public class IntegerToRomanNumber {

    private final static TreeMap<Integer, String> romanMap = new TreeMap<Integer, String>();

    private static final String[] numerals = 
    	    new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", 
    	                 "V", "IV", "I"};
    	private static final int[] values =
    	    new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    	    
    	public static String integerToRoman(int value) {
    	    // We are only considering the range for standard roman numerals
    	    if (value > 3999 || value < 1) throw new IllegalArgumentException();
    	    
    	    StringBuilder numeral = new StringBuilder();
    	    int i = 0;
    	    // Greedily append the largest numeral possible until the value is 0
    	    while (value > 0) {
    	        if (value - values[i] >= 0) {
    	            numeral.append(numerals[i]);
    	            value -= values[i];
    	        } else {
    	            i++;
    	        }
    	    }
    	    return numeral.toString();
    	}
    	
    	
    static {

        romanMap.put(1000, "M");
        romanMap.put(900, "CM");
        romanMap.put(500, "D");
        romanMap.put(400, "CD");
        romanMap.put(100, "C");
        romanMap.put(90, "XC");
        romanMap.put(50, "L");
        romanMap.put(40, "XL");
        romanMap.put(10, "X");
        romanMap.put(9, "IX");
        romanMap.put(5, "V");
        romanMap.put(4, "IV");
        romanMap.put(1, "I");

    }

    public final static String convertToRoman(int number) {
        int l =  romanMap.floorKey(number);
        if ( number == l ) {
            return romanMap.get(number);
        }
        return romanMap.get(l) + convertToRoman(number-l);
    }
    public static void main(String[] args) {
    	/*  	for (int i = 3999; i<= 4000; i++) {
           System.out.println(i+"\t =\t "+IntegerToRomanNumber.convertToRoman(i));
        }
    	*/
    	System.out.println(integerToRoman(3999));
    	System.out.println(integerToRoman(3999).equals(IntegerToRomanNumber.convertToRoman(3999)));
	}

}