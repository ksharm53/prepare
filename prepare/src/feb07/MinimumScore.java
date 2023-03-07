package feb07;

import java.util.Arrays;

public class MinimumScore {

	public static int[][] matrix;

	public static void main(String[] args) {
		String s = "abacaba";
		String t = "bzaa";

		matrix = new int[s.length() + 1][t.length() + 1];

		for (int[] string : matrix) {
			Arrays.fill(string, -1);
		}

		System.out.println(solve(s, t));

	}

	private static int solve(String s, String t) {
		int length = findLCS(s, t, s.length() - 1, t.length() - 1);
		return length;
	}

	private static int findLCS(String s, String t, int sLength, int tLength) {
		if (sLength < 0 || tLength < 0) {
			return 0;
		}
		if (matrix[sLength][tLength] != -1) {
			return matrix[sLength][tLength];
		}

		if (s.charAt(sLength) == t.charAt(tLength)) {
			return matrix[sLength][tLength] = 1 + findLCS(s, t, sLength - 1, tLength - 1);
		} else {
			return matrix[sLength][tLength] = Math.max(findLCS(s, t, sLength - 1, tLength),
					findLCS(s, t, sLength, tLength - 1));
		}
	}

}
