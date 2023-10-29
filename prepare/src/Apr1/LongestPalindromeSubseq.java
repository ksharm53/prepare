package Apr1;

import java.util.Arrays;

public class LongestPalindromeSubseq {

	static int[][] matrix;

	public static void main(String[] args) {
		String s = "bbbab";
		matrix = new int[s.length() + 1][s.length() + 1];

		for (int[] each : matrix) {
			Arrays.fill(each, -1);
		}

		System.out.println(solve(s));

		System.out.println(matrix);
	}

	private static int solve(String s) {
		StringBuilder reverse = new StringBuilder(s);
		reverse.reverse();

		return lcs(s, reverse, s.length() - 1, reverse.length() - 1);
	}

	private static int lcs(String s, StringBuilder reverse, int lengthString, int lengthReverse) {
		if (lengthString < 0 || lengthReverse < 0) {
			return 0;
		}

		if (matrix[lengthString][lengthReverse] != -1) {
			return matrix[lengthString][lengthReverse];
		}

		if (s.charAt(lengthString) == reverse.charAt(lengthReverse)) {
			return matrix[lengthString][lengthReverse] = lcs(s, reverse, lengthString - 1, lengthReverse - 1) + 1;
		} else {
			return matrix[lengthString][lengthReverse] = Math.max(lcs(s, reverse, lengthString - 1, lengthReverse),
					lcs(s, reverse, lengthString, lengthReverse - 1));
		}
	}

}
