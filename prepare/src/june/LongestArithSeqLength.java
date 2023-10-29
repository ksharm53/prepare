package june;

import java.util.Arrays;

public class LongestArithSeqLength {

	static StringBuilder str;
	static int max;
	static int[][][] matrix;

	public static void main(String[] args) {
		int x = 20;
		int y = 20;
		int z = 20;
		str = new StringBuilder();
		max = Integer.MIN_VALUE;
		matrix = new int[51][51][51];

		for (int[][] each : matrix) {
			for (int[] inner : each) {
				Arrays.fill(inner, -1);
			}
		}

		solve(x, y, z, 0, 0, 0);

		System.out.println(max);

	}

	private static void solve(int x, int y, int z, int xC, int yC, int zC) {

		if (str.toString().contains("AAA") || str.toString().contains("BBB")) {
			if (!str.isEmpty())
				str.deleteCharAt(str.length() - 1);
			if (!str.isEmpty())
				str.deleteCharAt(str.length() - 1);
			return;
		}
		if (xC + 1 <= x) {
			str.append("AA");
			solve(x, y, z, xC + 1, yC, zC);
		}

		if (yC + 1 <= y) {
			str.append("BB");
			solve(x, y, z, xC, yC + 1, zC);
		}

		if (zC + 1 <= z) {
			str.append("AB");
			solve(x, y, z, xC, yC, zC + 1);
		}

		max = Math.max(max, str.length());

		if (!str.isEmpty())
			str.deleteCharAt(str.length() - 1);
		if (!str.isEmpty())
			str.deleteCharAt(str.length() - 1);

	}

}
