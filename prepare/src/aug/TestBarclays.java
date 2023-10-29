package aug;

import java.util.Arrays;

public class TestBarclays {

	static int[][] matrix;

	public static void main(String[] args) {
		int[] arr = { 5, 8, 10, 6 };
		int target = 23;

		matrix = new int[arr.length + 1][target + 1];

		for (int[] each : matrix) {
			Arrays.fill(each, -1);
		}

		System.out.println(solve(arr, target, 0));

	}

	private static int solve(int[] arr, int target, int idx) {
		if (idx >= arr.length || target < 0) {
			return 0;
		}

		if (matrix[idx][target] != -1) {
			return matrix[idx][target];
		}

		int liya = 1 + solve(arr, target - arr[idx], idx + 1);
		int naiLiya = solve(arr, target, idx + 1);

		return matrix[idx][target] = Math.max(liya, naiLiya);
	}

}
