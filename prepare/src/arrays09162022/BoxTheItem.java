package arrays09162022;

import java.util.Arrays;

public class BoxTheItem {

	static int mod = 100000008;
	static int[][] matrix;

	public static void main(String[] args) {
		int total = 500;
		int k = 100;
		int[] value = new int[k];
		for (int i = 0; i < k; i++) {
			value[i] = i + 1;
		}

		matrix = new int[total + 1][value.length + 1];
		for (int[] i : matrix) {
			Arrays.fill(i, -1);
		}

		System.out.println(solve(total, k, value, value.length - 1));
	}

	private static int solve(int total, int k, int[] value, int valueLength) {
		if (valueLength < 0) {
			return 0;
		}
		if (total == 0) {
			return 1;
		}

		if (matrix[total][valueLength] != -1) {
			return matrix[total][valueLength];
		}

		if (value[valueLength] <= total) {
			long considered = solve(total - value[valueLength], k, value, valueLength);
			long notConsiderd = solve(total, k, value, valueLength - 1);
			return matrix[total][valueLength] = (int) ((considered + notConsiderd) % mod);
		} else {
			long notConsiderd = solve(total, k, value, valueLength - 1);
			return matrix[total][valueLength] = (int) ((notConsiderd) % mod);
		}

	}

}
