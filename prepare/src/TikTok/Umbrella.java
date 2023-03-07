package TikTok;

import java.util.Arrays;

public class Umbrella {

	public static int matrix[][];

	public static void main(String[] args) {
		int requirement = 7;
		int[] sizes = { 3, 5 };
		Arrays.sort(sizes);
		matrix = new int[requirement + 1][sizes.length + 1];

		for (int[] each : matrix) {
			Arrays.fill(each, -1);
		}

		int result = getMinCount(sizes, requirement, sizes.length - 1);

		if (result == Integer.MAX_VALUE - 1) {
			System.out.println(-1);
		} else {
			System.out.println(result);
		}

	}

	private static int getMinCount(int[] arr, int n, int arraySize) {
		if (arraySize < 0 || n <= 0) {
			return n == 0 ? 0 : Integer.MAX_VALUE - 1;
		}

		if (matrix[n][arraySize] != -1) {
			return matrix[n][arraySize];
		}

		if (arr[arraySize] <= n) {
			return matrix[n][arraySize] = Math.min(1 + getMinCount(arr, n - arr[arraySize], arraySize),
					getMinCount(arr, n, arraySize - 1));
		} else {
			return matrix[n][arraySize] = getMinCount(arr, n, arraySize - 1);
		}

	}

}
