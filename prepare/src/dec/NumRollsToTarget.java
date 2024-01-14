package dec;

import java.util.Arrays;

public class NumRollsToTarget {

	static long[][] matrix;

	public static void main(String[] args) {
		int n = 30, k = 30, target = 500;
		matrix = new long[n + 1][target + 1];
		for (long[] each : matrix) {
			Arrays.fill(each, -1l);
		}
		System.out.println(solve(n, k, target));

	}

	private static long solve(int n, int k, int target) {
		if (n < 0 || target < 0) {
			return 0;
		}

		if (target == 0 && n == 0) {
			return 1;
		}

		if (matrix[n][target] != -1) {
			return matrix[n][target];
		}
		long sum = 0L;
		for (int i = 1; i <= k; i++) {
			sum += (solve(n - 1, k, target - i) % 1000000007);
		}

		return matrix[n][target] = sum % 1000000007;
	}

}
