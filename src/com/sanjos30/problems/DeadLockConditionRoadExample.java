package com.sanjos30.problems;

import java.util.Random;

/**
 * 
 * A deadlock condition demonstration using classic ROAD-A and ROAD-B example intersection
 * 
 * This program displays the condition of a deadlock. It is caused by Mutual exclusion.
 * 
 * 
 * @author 139222
 *
 */
public class DeadLockConditionRoadExample {

	public static void main(String[] args) {
		Intersection intersect = new Intersection();
		
		TrainA trainA=new TrainA(intersect);
		TrainB trainB=new TrainB(intersect);
		
		trainA.setName("Train A");
		trainB.setName("Train B");
		
		trainA.start();
		trainB.start();
		

	}

	private static class TrainA extends Thread{
		Intersection intersection;
		Random random = new Random();
		
		public TrainA(Intersection intersection){
			this.intersection=intersection;
		}
		
		@Override
		public void run(){
			while(true){
				long sleepingtime=random.nextInt(5);
				
				try {
					Thread.sleep(sleepingtime);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				intersection.takeRoadA();
			}
			
		}
	}
	
	
	private static class TrainB extends Thread{
		
		Intersection intersection;
		Random random = new Random();
		
		public TrainB(Intersection intersection){
			this.intersection=intersection;
		}
		
		
		@Override
		public void run(){
			while(true){
				long sleepingtime=random.nextInt(5);
				
				try {
					Thread.sleep(sleepingtime);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				intersection.takeRoadB();
			}
			
		}
		
	}
	
	private static class Intersection{
		
		private Object roadA=new Object();
		private Object roadB=new Object();
		
		public void takeRoadA(){
			
			//Train is travelling on Road A - so taking a lock on Road A
			synchronized(roadA){
				System.out.println("Road A is locked by the thread " + Thread.currentThread().getName());
				
				//Take a lock on B so that other train doesn't pass
				
				synchronized(roadB){
					
					System.out.println("Train is passing to the road A");
					
					try {
						Thread.sleep(1);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			
				
				
				
				
			}
		}
		
		
		
		// Train is driving on Road B
		public void takeRoadB(){
			
			//Train is travelling on Road A - so taking a lock on Road A
			synchronized(roadB){
				System.out.println("Road B is locked by the thread " + Thread.currentThread().getName());
				
				//Take a lock on B so that other train doesn't pass
				
				synchronized(roadA){
					
					System.out.println("Train is passing to the road B");
					
					try {
						Thread.sleep(1);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			
				
				
				
				
			}
		}
		
	}
}
