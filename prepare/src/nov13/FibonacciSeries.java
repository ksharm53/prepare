package nov13;

import java.util.Arrays;

public class FibonacciSeries {
	public static int[] matrix;

	public static void main(String[] args) {
		int n = 45;
		matrix = new int[n + 1];
		Arrays.fill(matrix, -1);
		System.out.println(solve(n));
	}

	private static int solve(int n) {
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}

		if (matrix[n] != -1) {
			return matrix[n];
		}

		return matrix[n] = solve(n - 1) + solve(n - 2);
	}

}
