package com.sanjos30.problems;

import java.util.Random;

//Class to demonstrate the race condition

//Multiple thread using same resource and trying to modify it
//Core problem is accessing the shared condition


public class RaceCondition {

	public static void main(String[] args) {

		Metric m = new Metric();
		
		
		//Create 2 business logic objects
		BusinessLogic bLogic1 = new BusinessLogic(m);
		BusinessLogic bLogic2 = new BusinessLogic(m);
		
		
		MetricPrinter mPrinter = new MetricPrinter(m);
		
		
		bLogic1.start();
		bLogic2.start();
		
		mPrinter.start();
		
		
		
		
	}
	
	public static class MetricPrinter extends Thread{
		
		Metric metric;
		
		public MetricPrinter(Metric metric){
			this.metric=metric;
		}
		
		
		@Override
		public void run(){
			while(true){
				
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				System.out.println(" The current average is " + metric.getAverage());
				
				
				
			}
			
		}
		
		
	}

	public static class BusinessLogic extends Thread {
		private Metric metric;
		private Random random = new Random();

		public BusinessLogic(Metric metric) {
			this.metric = metric;
		}

		@Override
		public void run() {

			while (true) {
				long start = System.currentTimeMillis();

				try {
					Thread.sleep(random.nextInt(10));
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				long end = System.currentTimeMillis();

				metric.addSample(end - start);
			}
		}
	}

	public static class Metric {
		private  long count = 0;

		private  double average = 0.0;

		// Function to add sample. Any Method can add sample
		// Risk of concurrent access so using synchronized on method

		public synchronized void addSample(long sample) {
			double currentsum = average * count;
			count++;
			average = (currentsum + sample) / count;
		}

		public double getAverage() {
			return average;
		}

	}

}
