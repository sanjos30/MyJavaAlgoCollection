package com.sanjos30.problems;

//According to code, x should always be greater than y

//Hence, data race is not possible

/**
 * 
 * CPU process instructions out of order. as every line is independent. 
 * If the lines were dependant, order is guaranteed.
 * In our case, order in not guaranteed.
 * 
 * 
 * 
 * 
 * If you remove the volatile keywork from the x and y variable, you will have a data race.
 * 
 * 2 ways to avoid data race : Synchronized of read and write method
 * 								Declare share variable as volatile.
 * 
 * 
 * 
 * @author 139222
 *
 */
public class RaceConditionForData {

	public static void main(String[] args) {

		SharedDataClass sharedData = new SharedDataClass();

		// Create 2 - one checking for threads racing for the data and other
		// checking for race condition
		Thread thread1 = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < Integer.MAX_VALUE; i++) {
					sharedData.increment();
				}
			}
		});

		Thread thread2 = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < Integer.MAX_VALUE; i++) {
					sharedData.checkForDataRace();
				}
			}
		});

		// start the threads. we should not see the data race but reality is
		// different

		thread1.start();
		thread2.start();
	}

	public static class SharedDataClass {

		//remove volatile to see the data race - It slows down the execution
		volatile int x = 0;
		volatile int y = 0;

		public void increment() {
			x++;
			y++;
		}

		public void checkForDataRace() {
			if (y > x) {
				System.out.println(
						"We have a new datarace condition where y is greater than x. y =" + y + ", and x=" + x);
			}
		}
	}

}
