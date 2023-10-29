package june;

import java.util.Arrays;

public class PaintWalls {

	static int[][] matrix;

	public static void main(String[] args) {
		int[] cost = { 26, 53, 10, 24, 25, 20, 63, 51 };
		int[] time = { 1, 1, 1, 1, 2, 2, 2, 1 };

		matrix = new int[cost.length + 1][time.length + 1];

		for (int[] each : matrix) {
			Arrays.fill(each, -1);
		}

		System.out.println(solve(cost, time, cost.length - 1, time.length));

	}

	private static int solve(int[] cost, int[] time, int idx, int totalWalls) {
		if (totalWalls <= 0) {
			return 0;
		}

		if (idx < 0) {
			return 100000000;
		}

		if (matrix[idx][totalWalls] != -1) {
			return matrix[idx][totalWalls];
		}

		int lenge = cost[idx] + solve(cost, time, idx - 1, totalWalls - time[idx] - 1);
		int naiLenge = solve(cost, time, idx - 1, totalWalls);

		return matrix[idx][totalWalls] = Math.min(lenge, naiLenge);
	}

}
