package Oct13;

import java.util.Arrays;

public class PerfectSquares {

	public static int[] matrix;

	public static void main(String[] args) {
		int n = 12;
		int sqrt = (int) Math.sqrt(n);
		matrix = new int[n + 1];
		Arrays.fill(matrix, -1);
		System.out.println(solve(n, sqrt));
	}

	public static int solve(int total, int each) {
		if (total <= 0) {
			return 0;
		}
		if (matrix[total] != -1) {
			return matrix[total];
		}
		int min = Integer.MAX_VALUE;
		for (int i = 1; i <= each; i++) {
			int div = total - (i * i);
			int val = 1 + solve(div, (int) Math.sqrt(div));
			min = Math.min(min, val);
		}
		return matrix[total] = min;
	}

}
