package arraysAndStrings;

import java.util.Arrays;

public class KnapsackRecursion {
	public static int[][] matrix;

	public static void main(String[] args) {
		int wt[] = { 1, 2, 3, 4 };
		int value[] = { 3, 4, 5, 8 };
		int n = wt.length;
		int W = 6;

		matrix = new int[n + 1][W + 1];

		for (int[] i : matrix) {
			Arrays.fill(i, -1);
		}

		System.out.println(solution(wt, value, W, n));
		System.out.println("");

	}

	private static int solution(int[] wt, int[] value, int W, int n) {

		if (W == 0 || n == 0) {
			return 0;
		}

		if (matrix[n][W] != -1) {
			return matrix[n][W];
		}

		if (wt[n - 1] <= W) {
			return matrix[n][W] = Math.max(value[n - 1] + solution(wt, value, W - wt[n - 1], n - 1),
					solution(wt, value, W, n - 1));
		} else {
			return matrix[n][W] = solution(wt, value, W, n - 1);
		}

	}

}
