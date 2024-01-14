package dec;

import java.util.Arrays;

public class MinDifficulty {

	static int[][] matrix;

	public static void main(String[] args) {
		int[] jobDifficulty = { 1, 1, 1 };
		int d = 3;
		matrix = new int[jobDifficulty.length + 1][d + 1];
		for (int[] each : matrix) {
			Arrays.fill(each, -1);
		}
		if (jobDifficulty.length < d) {
			System.out.println(-1);
		}
		int val = solve(jobDifficulty, 0, d);
		System.out.println(val == Integer.MAX_VALUE ? -1 : val);
	}

	private static int solve(int[] jobDifficulty, int idx, int d) {
		if (matrix[idx][d] != -1) {
			return matrix[idx][d];
		}
		if (d == 1) {
			int res = Integer.MIN_VALUE;
			for (int i = idx; i < jobDifficulty.length; i++) {
				res = Math.max(res, jobDifficulty[i]);
			}
			return matrix[idx][d] = res;
		}

		int res = Integer.MAX_VALUE;
		int dailyMaxJobDiff = 0;
		for (int i = idx; i < jobDifficulty.length - d + 1; i++) {
			dailyMaxJobDiff = Math.max(dailyMaxJobDiff, jobDifficulty[i]);
			res = Math.min(res, dailyMaxJobDiff + solve(jobDifficulty, i + 1, d - 1));
		}
		return matrix[idx][d] = res;
	}

}
