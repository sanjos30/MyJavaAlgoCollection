package com.sanjos30.problems;

public class HelloWorldThread {

	public static void main(String[] args) throws InterruptedException {

		// Scenario 1 - Using standard way
		Thread thread = new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("I am basic Thread - " + Thread.currentThread().getName());
				System.out.println("Current thread priority is -" + Thread.currentThread().getPriority());
				
				//Let's now throw a runtime exception
				throw new RuntimeException("Intentional Exception");
			}
		});
		
		//Set the name of the thread
		thread.setName("My Basic Thread");
		
		//Set the priority of the thread
		thread.setPriority(Thread.MAX_PRIORITY);
		
		//Handle uncaught exception
		thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
			
			@Override
			public void uncaughtException(Thread t, Throwable e) {
				System.out.println("An uncaught exception has occured in thread - " + Thread.currentThread().getName()
									+ " and the error is: " + e.getMessage());	
				
			}
		});
		
		
		//Start the Thread
		thread.start();


	}

}
