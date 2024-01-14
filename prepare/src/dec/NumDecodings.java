package dec;

import java.util.Arrays;

public class NumDecodings {

	static int[] matrix;

	public static void main(String[] args) {
		String s = "10";

		matrix = new int[s.length()];
		Arrays.fill(matrix, -1);
		System.out.println(solve(new StringBuilder(s), 0));

	}

	private static int solve(StringBuilder sb, int idx) {
		if (idx > sb.length()) {
			return 0;
		}

		if (idx == sb.length()) {
			return 1;
		}
		if (sb.charAt(idx) == '0') {
			return 0;
		}

		if (matrix[idx] != -1) {
			return matrix[idx];
		}

		int donoSath = 0;
		int sirfPehla = solve(sb, idx + 1);

		int endIdx = idx + 2 <= sb.length() ? idx + 2 : sb.length();
		if (Integer.valueOf(sb.substring(idx, endIdx)) <= 26) {
			donoSath = solve(sb, idx + 2);
		}

		return matrix[idx] = sirfPehla + donoSath;
	}

}
