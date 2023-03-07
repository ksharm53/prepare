package nov13;

import java.util.Arrays;

public class ZeroOneKnapsack {

	public static int[][] matrix;

	public static void main(String[] args) {
		int[] weight = { 1, 2, 3, 4 };
		int[] value = { 3, 4, 5, 8 };
		int capacity = 6;
		int length = weight.length - 1;

		matrix = new int[length + 1][capacity + 1];

		for (int[] each : matrix) {
			Arrays.fill(each, -1);
		}

		System.out.println(solve(weight, value, capacity, length));

	}

	private static int solve(int[] weight, int[] value, int W, int n) {
		if (n < 0) {
			return 0;
		}

		if (matrix[n][W] != -1) {
			return matrix[n][W];
		}

		if (weight[n] <= W) {
			return matrix[n][W] = Math.max(value[n] + solve(weight, value, W - weight[n], n - 1),
					solve(weight, value, W, n - 1));
		} else {
			return matrix[n][W] = solve(weight, value, W, n - 1);
		}
	}

}
