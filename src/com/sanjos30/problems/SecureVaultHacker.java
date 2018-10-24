package com.sanjos30.problems;

import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class SecureVaultHacker {

	
	public static final int MAX_PASSWORD = 20000;
	
	// VAULT class
	private static class Vault extends Thread {
		private int password;
		
		public Vault(int password){
			this.password=password;
		}
		
		public boolean isValidPassword(int guess){
			
				try {
					Thread.sleep(5);
				} catch (InterruptedException e) {
				
					e.printStackTrace();
				}
				
			return this.password==guess;
		}
	}
	
	//Abstract class for Hacker
	private static abstract class HackerThread extends Thread{
		protected Vault vault;
	
		public HackerThread(Vault vault){
			this.vault=vault;
			this.setName(this.getClass().getSimpleName());
			this.setPriority(Thread.MAX_PRIORITY);
		}
		
		
		@Override
		public void start(){
			System.out.println("Starting thread " + this.getName());
			super.start();
		}
		
		@Override
		public void run(){
			
		}
		
	}

	//AscendingHacker
	private static class AscendingHackerThread extends HackerThread {
		
		public AscendingHackerThread(Vault vault){
			super(vault);
		}
		
		@Override
		public void run(){			
			for(int guess=0;guess<MAX_PASSWORD;guess++){
				if(vault.isValidPassword(guess)){
					System.out.println(this.getName() + " guessed the password correctly as " + guess);
					System.exit(0);
				}
				
			}
			
			
		}			
	}
	
	//DescendingHacker
	private static class DescendingHacker extends HackerThread{
		
		public DescendingHacker(Vault vault){
			super(vault);
		}
		
		@Override
		public void run(){
			for(int guess=MAX_PASSWORD;guess>0;guess--){
				if(vault.isValidPassword(guess)){
					System.out.println(this.getName() + " guessed the password correctly as " + guess);
					System.exit(0);
				}
			}
		}
	}

	//PoliceThread
	private static class PoliceThread extends Thread{
		
		@Override
		public void run(){
			for(int i=10;i>=0;i--){			
				//Police waits for 1 second per loop before catching the thief
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {						
						e.printStackTrace();
					}
				System.out.println(i);
				
			}
			System.out.println("Hacker caught. Game over for you!");
			System.exit(0);
		}
	}


	
	//Main program
	public static void main(String[] args) {
		
		//Random password generator
		Random random = new Random();	
		Vault vault = new Vault(random.nextInt(MAX_PASSWORD));

		//Have all the hackers and police in a List and see who gets caught first
		
		List<Thread> threads = new ArrayList<Thread>();
		
		threads.add(new AscendingHackerThread(vault));
		threads.add(new DescendingHacker(vault));
		threads.add(new PoliceThread());
		
		for(Thread thread:threads){
			thread.start();
		}
	}


}

