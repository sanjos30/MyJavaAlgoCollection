package com.sanjos30.problems;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;


class Order{
	String city;
	
	Order(String city){
		this.city=city;
	}
	
}

class City{
	String name;
	int totalOrders;
	
	City(String name){
		this.name=name;
		this.totalOrders++;
	}
	
	void incrementOrder(){
		this.totalOrders++;
	}
}


public class AmazonOrderByCity {

	public static void main(String[] args) {

		Order ord1=new Order("Udaipur");
		Order ord2=new Order("Mumbai");
		Order ord3=new Order("Indore");
		Order ord4=new Order("Indore");
		Order ord5=new Order("Udaipur");
		Order ord6=new Order("Mumbai");
		Order ord7=new Order("Mumbai");

		List<Order> amazonOrders=new ArrayList<Order>();
		amazonOrders.add(ord1);amazonOrders.add(ord2);amazonOrders.add(ord3);amazonOrders.add(ord4);
		amazonOrders.add(ord5);amazonOrders.add(ord6);amazonOrders.add(ord7);
		topNCities(amazonOrders, 2);
	}

	private static void topNCities(List<Order> amazonOrders, int n) {
		
		Map<String,City> cityOrderMap=new HashMap<String,City>();
		
		

		for(Order order:amazonOrders) {
			if(!cityOrderMap.containsKey(order.city)) {
				City c=new City(order.city);
				cityOrderMap.put(order.city, c);
			}else {
				City c=cityOrderMap.get(order.city);
				c.incrementOrder();
				cityOrderMap.put(order.city, c);
			}
		}
		
		PriorityQueue<City> topNCitiesMaxImpl=new PriorityQueue<City>(n, new Comparator<City>() {
			
			public int compare(City c1, City c2) {
				if(c2.totalOrders-c1.totalOrders >= 1) {
					return 1;
				}else if(c2.totalOrders-c1.totalOrders ==0) {
					return 0;
				}else {
					return -1;
				}
				
			}
			
		});
		
		PriorityQueue<City> topNCitiesMinImpl=new PriorityQueue<City>(n, new Comparator<City>() {
			
			public int compare(City c1, City c2) {
				if(c1.totalOrders-c2.totalOrders >= 1) {
					return 1;
				}else if(c1.totalOrders-c2.totalOrders ==0) {
					return 0;
				}else {
					return -1;
				}
				
			}
			
		});
		
		
		for(Map.Entry<String,City> entry:cityOrderMap.entrySet()) {
					String city=entry.getKey();
					if(topNCitiesMaxImpl.size()<n)
						topNCitiesMaxImpl.add(cityOrderMap.get(city));
					else {
						if(topNCitiesMaxImpl.peek().totalOrders<cityOrderMap.get(city).totalOrders) {
							topNCitiesMaxImpl.poll();
							topNCitiesMaxImpl.add(cityOrderMap.get(city));
							
						}
						
					}
		}
		
		
		
		System.out.println("Top " + n + " cities are: ");
		for(City c:topNCitiesMaxImpl) {
			System.out.println(c.name);
		}
		
	}

}
