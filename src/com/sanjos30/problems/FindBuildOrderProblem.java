package com.sanjos30.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Given a list of packages that need to be built and the dependencies for each package, determine a valid order in which to build the packages.


public class FindBuildOrderProblem {

	public static void main(String[] args) {
		Map<String,List<String>> buildMap=new HashMap<String,List<String>>();
		
		List<String> ls =new ArrayList<String>();
		ls.add("0");
		buildMap.put("1",ls );
		
		buildMap.put("0", null);
		

		
		List<String> ls2 =new ArrayList<String>();
		ls.add("1");
		ls.add("2");
		buildMap.put("2",ls2 );

		findOrder(buildMap);
	}

	private static void findOrder(Map<String, List<String>> buildMap) {
		
		
	}

}
