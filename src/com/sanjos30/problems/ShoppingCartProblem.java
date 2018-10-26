package com.sanjos30.problems;


//Shopping Resources Problem
//Negative Scenario
//result is not zero
//Result will only be zero when you use thread.start thread.join thread.start and thread.join

public class ShoppingCartProblem {

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
		
		public int getItems(){
			return this.items;			
		}
		
		public void increment(){
			items++;
		}	
		
		public void decrement(){
			items--;
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
