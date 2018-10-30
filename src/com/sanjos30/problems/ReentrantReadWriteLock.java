package com.sanjos30.problems;

import java.util.NavigableMap;
import java.util.Random;
import java.util.TreeMap;
/// In progress - Incomplete class

public class ReentrantReadWriteLock {

	public static final int HIGHEST_PRICE=1000;
	
	public static void main(String args[]) {
		Random random = new Random();	
	}
	
	
	public static class InventoryDatabase{
		private TreeMap<Integer, Integer> priceToCountMap = new TreeMap<>();
		
		public int getNumberOfItemsInPriceRange(int lowerBound, int upperBound) {
			
			Integer fromKey  = priceToCountMap.ceilingKey(lowerBound);
			Integer toKey = priceToCountMap.floorKey(upperBound);
			
			if(fromKey ==null || toKey == null) {
				return 0;
			}
			
			
			return 0;
			
		}
		
		public void addItem(int price) {}
		
		public void removeItem(int price) {}
		
	}
	
}
