package com.sanjos30.helper;

public class SyntaxHelper {

	public static void main(String args[]) {

		switchStr();

		switchInt();
		
		ternaryOperator();
	}

	public static void switchInt() {
		int n = 10;
		switch (n / 2) {
		case 5:
			System.out.println(5);
			break;
		case 2:
			System.out.println(2);
			break;
		default:
			System.out.println("default" + n / 10);
			break;
		}

	}

	public static void switchStr() {
		String name = "sandeep";
		for (int i = 0; i < name.length(); i++) {
			char c = name.charAt(i);
			switch (c) {
			case 's':
				System.out.println(c);
				break;
			case 'e':
				System.out.println(c);
				break;
			case 'p':
				System.out.println(c);
				break;
			default:
				System.out.println("default");
				break;
			}
		}
	}
	
	public static void ternaryOperator() {
		int n=101;
		n=n%10==0?1:0;
		System.out.println(n);
	}
}
