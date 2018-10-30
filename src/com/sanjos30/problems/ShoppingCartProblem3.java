package com.sanjos30.problems;


/**
 * 
 * This class make use of the synchronized keyword on the block that does the increment and decrement.
 * This allows for methods to increment and decrement in a phased manner and than sign off
 * 
 * 
 * @author 139222
 *
 */

public class ShoppingCartProblem3 {

	public static void main(String[] args) {

		ShoppingCart originalCart = new ShoppingCart();
		
		IncrementThread iThread = new IncrementThread(originalCart);
		DecrementThread dThread = new DecrementThread(originalCart);
		
		
		iThread.start();
		dThread.start();
		
		
		try {
			iThread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		try {
			iThread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("IThread Interrupted ");
		}
		
		
		try {
			dThread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("DThread Interrupted ");
		}
		
		//for(int i=0;i<1000;i++)
			System.out.println(originalCart.getItems());
		

	}

	
	
	private static class ShoppingCart {
		
		private int items = 0;
		
		//Create an object for synchronization
		Object lock = new Object();
		
		public int getItems(){
			return this.items;			
		}
		
		public   void increment(){
			synchronized(lock){
				items++;
			}
			
		}	
		
		public synchronized  void decrement(){
			synchronized(lock){
				items--;
			}
		}
	}
	
	
	private static class IncrementThread extends Thread {
		
		ShoppingCart sCart;
		
		public IncrementThread(ShoppingCart sCart){
			this.sCart=sCart;
		}
		
		
		@Override
		public void run(){
			
			for(int i=0;i<10000;i++)
				sCart.increment();
		}
		
	}
	
	
	private static class DecrementThread extends Thread {
		
		ShoppingCart sCart;
		
		public DecrementThread(ShoppingCart sCart){
			this.sCart=sCart;
		}
		
		
		@Override
		public void run(){
			for(int i=0;i<10000;i++)
				sCart.decrement();
		}
		
	}
}