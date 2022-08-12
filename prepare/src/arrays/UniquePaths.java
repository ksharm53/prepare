package arrays;

import java.util.Arrays;

public class UniquePaths {
	static long[][] matrix;

	public static void main(String[] args) {
		int m = 18;
		int n = 18;
		matrix = new long[m + 1][n + 1];

		for (long[] each : matrix) {
			Arrays.fill(each, -1);
		}

		System.out.println(solve(m - 1, n - 1, 0, 0));

	}

	private static long solve(int m, int n, int row, int column) {
		if (matrix[row][column] != -1) {
			return matrix[row][column];
		}

		if (row > m || column > n) {
			return matrix[row][column] = 0;
		}

		else if (row == m && column == n) {
			return matrix[row][column] = 1;
		} else {
			return matrix[row][column] = solve(m, n, row + 1, column) + solve(m, n, row, column + 1);
		}
	}
}
