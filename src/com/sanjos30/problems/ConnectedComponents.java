package com.sanjos30.problems;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class ConnectedComponents {

	public static void main(String[] args) {
		
		List<Order> list = new ArrayList<>();
		
		List<String> o1 = new ArrayList<>();
		o1.add("Item 1");
		o1.add("Item 2");
		o1.add("Item 2");
		
		
		List<String> o2 = new ArrayList<>();
		//o2.add("B");
		o2.add("Item 3");
		o2.add("Item 1");
		
		List<String> o3 = new ArrayList<>();
		o3.add("Item 6");
		o1.add("Item 2");
		o1.add("Item 3");
		

		

		
		list.add(new Order("O1", o1));
		list.add(new Order("O2", o2));
		list.add(new Order("O3", o3));
		
		merge(list);		

	}
	
	
	static class Order{ 
		String orderId; 
		public Order(String orderId, List<String> items) {
			super();
			this.orderId = orderId;
			this.items = items;
		}
		List<String> items; 
	} 
	
	/**
	 * This is the node of a Graph.
	 * We have simplified the problem to be a connected component problem.
	 * The graph must be visited using a DFS.
	 * @author Sandeep
	 *
	 */
	
	static class GNode{ 
		String item;
		List<String> orderid = new ArrayList<>();
		List<GNode> list = new ArrayList<>();;
		boolean visited;
		
	}
		
	static void merge(List<Order> list) 
	{
		Map<String, GNode> map = new HashMap<>();
		
		
		for(Order order : list)
		{
			
			String orderid = order.orderId;
			List<String> items = order.items;
			
			GNode prev = null;
			
			for(String item : items) {
				
				GNode g = map.get(item);
				
				if(g == null) {
					
					GNode gnode = new GNode();
					gnode.item = item;
					gnode.orderid.add(orderid);
					map.put(item, gnode);
 					if(prev == null) {
						prev = gnode;
					}
					else {
						prev.list.add(gnode);
						gnode.list.add(prev);
						prev = gnode;
					}
				}
				else {
					g.orderid.add(orderid);
					
					if(prev == null) {
						prev = g;
					}
					else {
						prev.list.add(g);
						g.list.add(prev);
						prev = g;
					}
				}							
			}
			
			
		}
		
		Queue<GNode> q = new LinkedList<>();
		Set<String> current_order_group = new HashSet<>();
				
		for(String key : map.keySet()) {
			GNode g = map.get(key);	
			
			if(!g.visited) {
				q.add(g);
				g.visited = true;
				
				while(!q.isEmpty()) {
					GNode i = q.poll();
					current_order_group.addAll(i.orderid);
					
					List<GNode> i_list = i.list;
					
					for(GNode gg : i_list) {
						if(!gg.visited) {
							q.add(gg);
							gg.visited = true;
						}
					}
					
				}
				
				System.out.println(current_order_group);
				current_order_group.clear();
			}		
		}
	

}
}