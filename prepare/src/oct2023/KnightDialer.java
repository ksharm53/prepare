package oct2023;

import java.util.Arrays;

public class KnightDialer {

	static int mod = 1000000007;
	static long[][][] dp;

	public static void main(String[] args) {
		int n = 3131;
		dp = new long[n + 1][4][3];
		for (long[][] each : dp) {
			for (long[] innerEach : each) {
				Arrays.fill(innerEach, -1L);
			}
		}

		System.out.println(solve(n));

	}

	private static int solve(int n) {
		long count = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 3; j++) {

				if ((i == 3 && j == 0) || (i == 3 && j == 2)) {
					continue;
				}

				count += recurse(i, j, n);
			}
		}
		return (int) (count % mod);
	}

	private static long recurse(int row, int col, int n) {
		if (row >= 4 || row < 0 || col >= 3 || col < 0) {
			return 0;
		}
		if ((row == 3 && col == 0) || (row == 3 && col == 2)) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		if (dp[n][row][col] != -1) {
			return dp[n][row][col];
		}

		long val = recurse(row - 2, col - 1, n - 1) % mod + recurse(row - 2, col + 1, n - 1) % mod
				+ recurse(row - 1, col - 2, n - 1) % mod + recurse(row - 1, col + 2, n - 1) % mod
				+ recurse(row + 1, col - 2, n - 1) % mod + recurse(row + 1, col + 2, n - 1) % mod
				+ recurse(row + 2, col - 1, n - 1) % mod + recurse(row + 2, col + 1, n - 1) % mod;

		return dp[n][row][col] = val;

	}

}
