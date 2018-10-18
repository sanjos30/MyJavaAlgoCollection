package com.sanjos30.problems;

public class BucketBallProblem {

	
	public static void main(String args[]){
		
		//number of balls
		int m= 12;
		
		//number of bins
		int n = 1;
		
		System.out.println(assignBalls(m,n));
		
	}
	
	public static int assignBalls(int m, int n) {
        if (m == 0 || n == 1) {
            return 1;
        }
        if (n > m) {
            return assignBalls(m, m);
        } else {
            return assignBalls(m, n - 1) + assignBalls(m - n, n);
        }
    }

}
