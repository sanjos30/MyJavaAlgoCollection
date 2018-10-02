package com.sanjos30.problems;

public class RemoveUnderScore {

	public static void main(String[] args) {
		
		String str = "Amazon_w_e_b_services are___widely__used_acc__ro___ss_the_wor_d";

		System.out.println(removeUndScr(str));
	}
	
	public static String removeUndScr(String str) {
		
		//remove ' ' and double and triple dashes
		str = str.replace("___" , "_");
		str = str.replace("__" , "_");
		str = str.replace(" " , "_");	
	
		String newStr = "";
		String arr [] = str.split("_");
	 
		for(int i=0; i < arr.length; i++) {
			
			String words []  = newStr.split(" ");
			int  nWord = words[words.length -1].length();
			
			if (nWord + arr[i].length() > 5 && arr[i].length() != 2)
			{
					newStr +=  " ";
			}
			newStr +=  arr[i];		
		}
		
		return newStr;

	}

}
