package Apr1;

import java.util.Arrays;

public class MinInsertions {

	static int[][] matrix;

	public static void main(String[] args) {
		String s = "leetcode";
		matrix = new int[s.length() + 1][s.length() + 1];

		for (int[] each : matrix) {
			Arrays.fill(each, -1);
		}

		System.out.println(solve(s));

	}

	private static int solve(String s) {
		StringBuilder sb = new StringBuilder(s);
		sb.reverse();

		int lcs = findLCS(s, sb.toString(), s.length() - 1, sb.length() - 1);

		return s.length() - lcs;
	}

	private static int findLCS(String s, String sb, int lengthS, int lengthSb) {
		if (lengthS < 0 || lengthSb < 0) {
			return 0;
		}

		if (matrix[lengthS][lengthSb] != -1) {
			return matrix[lengthS][lengthSb];
		}

		if (s.charAt(lengthS) == sb.charAt(lengthSb)) {
			return matrix[lengthS][lengthSb] = findLCS(s, sb, lengthS - 1, lengthSb - 1) + 1;
		} else {
			int liya = findLCS(s, sb, lengthS - 1, lengthSb);
			int naiLiya = findLCS(s, sb, lengthS, lengthSb - 1);
			return matrix[lengthS][lengthSb] = Math.max(liya, naiLiya);
		}

	}

}
