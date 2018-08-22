package com.sanjos30.helper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapHelper {

	public static void iterateOneDMap() {
		Map<String, Integer> strMap = new HashMap<String, Integer>();
		for (Map.Entry<String, Integer> entry : strMap.entrySet()) {
			String key = entry.getKey();
			Integer value = entry.getValue();
			System.out.println(key + "," + value);
		}
	}

	public static void iterateTwoDMap() {
		Map<String, Map<String, Integer>> productMap = new HashMap<String, Map<String, Integer>>();
		for (String productName : productMap.keySet()) {
			Map<String,Integer> userMap=productMap.get(productName);			
			for (Map.Entry<String, Integer> userEntry : userMap.entrySet()) {
				String key = userEntry.getKey();
				Integer value = userEntry.getValue();
				System.out.println(key + ", " + value);
			}
		}
	}

	
	public static void MapOfList() {
		Map<String, List<String>> productMap = new HashMap<String, List<String>>();
		for (String productName : productMap.keySet()) {
			List<String> userList=productMap.get(productName);
			for (String userName : userList) {
				System.out.println(userName);
			}
		}
	}
}
