package may1;

import java.util.Arrays;

public class CountGoodStrings {

	static int mod;
	static long count;

	public static void main(String[] args) {
		int low = 1;
		int high = 100000;
		int zero = 1;
		int one = 1;

		mod = 1000000007;
		int[] matrix = new int[high + 1];
		Arrays.fill(matrix, -1);

		count = 0;

		for (int i = low; i <= high; i++) {
			count += (solve(i, zero, one, matrix) % mod);
		}

		System.out.println(count % mod);
	}

	private static int solve(int maxLength, int zero, int one, int[] matrix) {

		if (maxLength == 0) {
			return 1;
		}
		if (maxLength < 0) {
			return 0;
		}

		if (matrix[maxLength] != -1) {
			return matrix[maxLength];
		}

		int zeroVal = solve(maxLength - zero, zero, one, matrix) % mod;
		int oneVal = solve(maxLength - one, zero, one, matrix) % mod;

		return matrix[maxLength] = ((zeroVal + oneVal) % mod);

	}

}
