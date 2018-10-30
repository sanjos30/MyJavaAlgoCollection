package com.sanjos30.problems;


import java.util.List;

public class AsynchronousCallBackTask {

	
	private static class BB {
		private EventListener myListeners;
		
		
		  // setting the listener 
	    public void registerEventListener(EventListener myListeners) 
	    { 
	        this.myListeners = myListeners	; 
	    }
	    
	    
		public void doSynchronousTask() {
			//This will happen before
			System.out.println("Doing something before the synchronous task");
			
			 // check if listener is registered. 
	        if (this.myListeners != null) { 
	  
	            // invoke the callback method of class A 
	        	myListeners.handleEvent(); 
	        } 
		}
		
	}
	
	
	   // Driver Function 
    public static void main(String[] args) 
    { 
    	BB obj = new BB();
        EventListener mListener = new A(); 
        obj.registerEventListener(mListener); 
        
        Thread thread = new Thread (new Runnable() {        	
        	@Override
        	public void run() {
        		obj.doSynchronousTask(); 
        	}        	
        });
        
        thread.start();

		System.out.println("All done..");

    } 
	
	public interface EventListener{
		
		public void handleEvent(); 
	}

	
	private static class A implements EventListener{
		
		@Override
		public void handleEvent() {
			System.out.println("Doing something after the synchronous task");
		}
	}
	

}
