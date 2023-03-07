package Sept23;

import java.util.Arrays;

public class NumberofDiceRollsWithTargetSum {

	public static int[][] matrix;

	public static void main(String[] args) {
		int n = 30, k = 30, target = 500;
		matrix = new int[n + 1][target + 1];

		for (int[] eachMatrix : matrix) {
			Arrays.fill(eachMatrix, -1);
		}

		System.out.println(solve(n, k, target));

	}

	private static int solve(int n, int k, int target) {

		if (n < 0 || target < 0) {
			return 0;
		}
		if (target == 0 && n == 0) {
			return 1;
		}

		if (matrix[n][target] != -1) {
			return matrix[n][target];
		}

		long ans = 0;
		for (int i = 1; i <= k; i++) {
			ans += solve(n - 1, k, target - i);
		}
		return matrix[n][target] =(int) (ans % 1000000007);
	}

}
