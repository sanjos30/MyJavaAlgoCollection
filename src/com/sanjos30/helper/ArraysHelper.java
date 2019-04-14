package com.sanjos30.helper;

import java.util.List;

public class ArraysHelper {

	public static void main(String args[]) {
		int[] preArr = { 0, 2, -3, 4, 9, -7 };
		for (int i : findArrayPrefixSum(preArr))
			System.out.println(i);

		// Min distance travelled at this point
		int n1 = 3; 
		int n2 = 3;
		int a[][] = new int[][] { { 1, 0, 1 }, { 1, 0, 0 }, { 1, 9, 0 } };
		System.out.println(findMinDistTravel(a, n1, n2));

	}

	public static int[] findArrayPrefixSum(int[] inputArr) {
		int[] prefixSum = new int[inputArr.length];

		int pre_sum_so_far = 0;
		for (int i = 0; i < inputArr.length; i++) {
			pre_sum_so_far = pre_sum_so_far + inputArr[i];
			prefixSum[i] = pre_sum_so_far;
		}
		return prefixSum;
	}

	public static int findMinDistTravel(int[][] a, int n1, int n2) {
		int res = 0;
		boolean[][] isVisited = new boolean[n1][n2];
		int i = 0, j = 0;
		while ((i <= n1 && j <= n2)) {

			if (a[i][j] == 1) {
				isVisited[i][j] = true;
			} else if (a[i][j] == 0) {
				isVisited[i][j] = false;
			} else if (a[i][j] == 9) {
				return res;
			}

		}
		return res;
	}

}
