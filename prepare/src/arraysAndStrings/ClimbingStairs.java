package arraysAndStrings;

import java.util.Arrays;

public class ClimbingStairs {
	static int[] matrix;

	public static void main(String[] args) {
		int n = 45;
		matrix = new int[n + 1];
		Arrays.fill(matrix, -1);
		System.out.println(solve(n));

	}

	private static int solve(int n) {

		if (n < 0) {
			return 0;
		}

		if (matrix[n] != -1) {
			return matrix[n];
		}
		if (n == 0) {
			return matrix[n] = 1;
		}

		return matrix[n] = solve(n - 1) + solve(n - 2);
	}

}
