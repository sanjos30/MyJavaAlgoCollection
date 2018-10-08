package com.sanjos30.problems;

import java.util.Stack;

public class DecodeString {

	  public static void main(String[] args)
	  {
	    String input = "2[a2[bd]g2[ef]h]";
	    System.out.println(decode(input));
	  }
	  
	/**
	 * ITERATIVE METHOD
	 */
	public static String decode(String str) {
		Stack<String> s = new Stack<>();
		String ns = "";
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			// string that will be repeated
			if (Character.isLetter(c)) {
				ns += String.valueOf(c);
			}
			// encountered number
			if (!Character.isLetter(c) && !"[".equals(String.valueOf(c)) && !"]".equals(String.valueOf(c))) {
				// stack is empty this is our first encounter so push number to stack
				if (s.isEmpty()) {
					s.push(String.valueOf(c));
				} else {
					// second encounter we push the ns we have constructed so far
					// then the new number
					// then clear the string to continue creating the string that will need to be repeated
					s.push(ns);
					s.push(String.valueOf(c));
					ns = "";
				}
			}
			if ("]".equals(String.valueOf(c)) && i < str.length() - 1) {
				// we reached our repeat case the ']' so get the number of times we need to repeat
				// repeat the string that has been constructed
				// pop the other string we have pushed to the stack and concat it to the repeated string
				int repeat = Integer.valueOf(s.pop());
				ns = repeatCopy(ns, repeat);
				ns = s.pop() + ns;
			}

		}

		if (!s.isEmpty()) {
			int repeat = Integer.valueOf(s.pop());
			ns = repeatCopy(ns, repeat);
		}
		return ns;
	}
	
	public static String repeatCopy(String str, int num) {
		if (num == 0) {
			return str;
		}
		String temp = "";
		for (int i = 0; i < num; i++) {
			temp += str;
		}
		return temp;
	}	
}