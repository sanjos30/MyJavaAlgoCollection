package com.sanjos30.problems;

public class GetBinarySequenceOfSizeK {

	public static void main(String[] args) {
		
		int k =3;
		String format = "%0" +2 + "d"; 
        for(int i = 0; i < Math.pow(2, k); i++) {
        	System.out.println(String.format(format, Integer.valueOf(Integer.toBinaryString(i))));
        }
        
        

	}

}
