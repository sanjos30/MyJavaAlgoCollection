package com.sanjos30.helper;

import java.util.ArrayList;
import java.util.List;

public class ListHelper {

	public static void main(String args[]) {
		System.out.println(findMinimumDistanceToTravel2DList(prepareTestDataMatrixProb()));
	}
	
	private static List<List<Integer>> prepareTestDataMatrixProb() {
		List<List<Integer>> mList=new ArrayList<List<Integer>>();
		List<Integer> a1=new ArrayList<Integer>();
		List<Integer> a2=new ArrayList<Integer>();
		List<Integer> a3=new ArrayList<Integer>();
		List<Integer> a4=new ArrayList<Integer>();
		a1.add(1);a1.add(0);a1.add(0);
		a2.add(1);a2.add(0);a2.add(0);
		a3.add(1);a3.add(1);a3.add(0);
		a4.add(1);a4.add(1);a4.add(9);
		mList.add(a1);
		mList.add(a2);
		mList.add(a3);mList.add(a4);
		return mList;
	}

	public static List<String> sortStrList(List<String> strList){	
		
		return null;
	}
	
	public static List<String> reverseList(List<String> strList) {
		return null;
	}
	
	public static int findMinimumDistanceToTravel2DList(List<List<Integer>> matList) {
		int res=0;
		for(int i=0;i<matList.size();i++) {
			List<Integer> rowList=matList.get(i);
				for(int j=0;j<rowList.size();j++) {
					int elem=rowList.get(j);
					
				}
		}
		
		return res;
	}
	
	public static void convertListToArray(List<Integer> intList) {
		int[] arr=new int[intList.size()];
		
		for(int i=0;i<intList.size();i++) {
			arr[i]=intList.get(i);
		}
		
		for(int i:arr) {
			System.out.println(i);
		}
	}
}
