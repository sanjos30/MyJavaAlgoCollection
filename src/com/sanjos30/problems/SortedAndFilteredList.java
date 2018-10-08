package com.sanjos30.problems;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortedAndFilteredList {
	
	private List<String> aList = null;
	private List<String> bList = null;
	private List<String> cList = null;
	
	public SortedAndFilteredList(List<String> aList, List<String> bList, List<String> cList) {
		this.aList = aList;
		this.bList = bList;
		this.cList = cList;
	}
	
	public List<String> sortAndFilter() {
		List<String> aListElementsToBeRemoved = new ArrayList<>();
		for (String element : aList) {
			if (bList.contains(element)) {
				bList.remove(element);
				aListElementsToBeRemoved.add(element);
			}
			
			if (cList.contains(element)) {
				cList.remove(element);
				if (!aListElementsToBeRemoved.contains(element)) {
					aListElementsToBeRemoved.add(element);
				}
			}
		}
		
		aList.removeAll(aListElementsToBeRemoved);
		
		List<String> bListElementsToBeRemoved = new ArrayList<>();
		for (String element : bList) {
			if (cList.contains(element)) {
				cList.remove(element);
				bListElementsToBeRemoved.add(element);
			}
		}
		
		bList.removeAll(bListElementsToBeRemoved);
		
		aList.addAll(bList);
		aList.addAll(cList);
		
		Collections.sort(aList);
		
		return aList;
	}
	
	public static void main(String[] args) {
		List<String> aList = new ArrayList<>();
		aList.add("aaa");
		aList.add("bbb");
		aList.add("ddd");
		aList.add("xyxz");
			
		List<String> bList = new ArrayList<>();
		bList.add("bbb");
		bList.add("ccc");
		bList.add("ccc");
		bList.add("hkp");
		
		List<String> cList = new ArrayList<>();
		cList.add("ddd");
		cList.add("eee");
		cList.add("ffff");
		cList.add("lmn");
		
		SortedAndFilteredList sortedAndFilteredList = new SortedAndFilteredList(aList, bList, cList);
		
		List<String> filteredList = sortedAndFilteredList.sortAndFilter();
		
		for (String str : filteredList) {
			System.out.println(str);
		}
	}
}
