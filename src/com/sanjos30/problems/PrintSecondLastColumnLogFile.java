package com.sanjos30.problems;

import java.util.ArrayList;
import java.util.List;

public class PrintSecondLastColumnLogFile {

	public static void main(String[] args) {


		List<String> l1 = new ArrayList<String>();
		l1.add("a,b,c,d,e,f");
		
		List<String> l2 = new ArrayList<String>();
		l1.add("1,2,3,4,5,6");

		List<String> l3 = new ArrayList<String>();
		l1.add("x,y,z");	
		
		List<List<String>> log=new ArrayList<List<String>>();
		log.add(l1);log.add(l2);log.add(l3);
		
		printSecondLastCol(log);
	}

	private static void printSecondLastCol(List<List<String>> log) {
		
		for(int i=0;i<log.size();i++) {
			List<String> logLine=log.get(i);
			
			for(String line:logLine) {
					String[] colStr=line.split(",");
					System.out.println(colStr[colStr.length-2]);
				
				
			}
			
			
		}
		
		
	}

}
