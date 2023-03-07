package arrays09162022;

import java.util.Arrays;

public class StoneGameVII {
	static int[][][] matrix;

	public static void main(String[] args) {
		int[] stones = { 5, 3, 4, 3 };

		matrix = new int[stones.length + 1][stones.length + 1][3];
		for (int[][] is : matrix) {
			for (int[] is2 : is) {
				Arrays.fill(is2, -1);
			}
		}

		int value = solve(stones, 0, stones.length - 1, 1);

		if (value > 0) {
			System.out.println(true);
		} else {
			System.out.println(false);
		}

	}

	private static int solve(int[] stones, int left, int right, int alexTurn) {
		if (left == right) {
			return 0;
		}

		if (matrix[left][right][alexTurn] != -1) {
			return matrix[left][right][alexTurn];
		}

		if (alexTurn == 1) {
			return matrix[left][right][alexTurn] = Math.max(stones[left] + solve(stones, left + 1, right, 0),
					stones[right] + solve(stones, left, right - 1, 0));
		} else {
			return matrix[left][right][alexTurn] = Math.min(solve(stones, left + 1, right, 1) - stones[left],
					solve(stones, left, right - 1, 1) - stones[right]);
		}
	}

}
