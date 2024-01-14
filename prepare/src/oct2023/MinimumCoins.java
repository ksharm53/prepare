package oct2023;

import java.util.Arrays;

public class MinimumCoins {

	static int[][] matrix;

	public static void main(String[] args) {
		int[] prices = { 3, 1, 2 };
		matrix = new int[prices.length + 1][prices.length + 1];

		for (int[] each : matrix) {
			Arrays.fill(each, -1);
		}

		System.out.println(solve(prices, 0, 0));
	}

	private static int solve(int[] prices, int idx, int freeItems) {
		if (idx >= prices.length) {
			return 0;
		}

		if (matrix[idx][freeItems] != -1) {
			return matrix[idx][freeItems];
		}

		if (freeItems > 0) {
			int liya = prices[idx] + solve(prices, idx + 1, idx + 1);
			int naiLiya = solve(prices, idx + 1, freeItems - 1);
			return matrix[idx][freeItems] = Math.min(liya, naiLiya);
		} else {
			return matrix[idx][freeItems] = prices[idx] + solve(prices, idx + 1, idx + 1);
		}
	}

}
