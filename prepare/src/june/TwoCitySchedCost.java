package june;

import java.util.Arrays;

public class TwoCitySchedCost {

	static int[][][] matrix;

	public static void main(String[] args) {
		int[][] costs = { { 10, 20 }, { 30, 200 }, { 400, 50 }, { 30, 20 } };
		matrix = new int[102][51][51];

		for (int[][] each : matrix) {
			for (int[] inner : each) {
				Arrays.fill(inner, -1);
			}
		}

		System.out.println(solve(costs, 0, 0, 0));

	}

	private static int solve(int[][] costs, int idx, int countA, int countB) {
		if (idx >= costs.length) {
			return 0;
		}

		int sumA = 0;
		int sumB = 0;
		if (countA < costs.length / 2) {
			sumA = costs[idx][0] + solve(costs, idx + 1, countA + 1, countB);
		}
		if (countB < costs.length / 2) {
			sumB = costs[idx][1] + solve(costs, idx + 1, countA, countB + 1);
		}

		return Math.min(sumA, sumB);
	}

}
