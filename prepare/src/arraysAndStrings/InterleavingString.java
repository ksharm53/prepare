package arraysAndStrings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InterleavingString {

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		String s1 = "aabd";
		String s2 = "abdc";
		String s3 = "aabdbadc";

		System.out.println(solve(s1, s2, s3));
	}

	private static boolean solve(String s1, String s2, String s3) {

		sb = new StringBuilder(s3);

		if (s3.length() != s2.length() + s1.length()) {
			return false;
		} else if (s1.equalsIgnoreCase(s2) && s2.equalsIgnoreCase(s3)) {
			return true;
		} else if (s1.isBlank() && !s2.equalsIgnoreCase(s3)) {
			return false;
		} else if (s2.isBlank() && !s1.equalsIgnoreCase(s3)) {
			return false;
		}

		int[][] matrix = validate(s1, s3);

		if (matrix[s1.length()][s3.length()] == s1.length()) {
			List<Integer> list = findLCS(s1, s3, matrix);
			StringBuilder sb = new StringBuilder();

			for (int i = 0; i < s3.length(); i++) {
				if (!list.contains(i)) {
					sb.append(s3.charAt(i));
				}
			}
			s3 = sb.toString();
		} else {
			return false;
		}

		int[][] matrixS3 = validate(s2, s3);

		if (matrixS3[s2.length()][s3.length()] == s2.length()) {
			return true;
		} else {
			return false;
		}
	}

	private static int[][] validate(String s1, String s3) {

		int[][] matrix = new int[s1.length() + 1][s3.length() + 1];

		for (int i = 0; i < matrix.length; i++) {
			matrix[i][0] = 0;
		}

		for (int j = 0; j < matrix[0].length; j++) {
			matrix[0][j] = 0;
		}

		for (int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix[0].length; j++) {
				if (s1.charAt(i - 1) == s3.charAt(j - 1)) {
					matrix[i][j] = 1 + matrix[i - 1][j - 1];
				} else {
					matrix[i][j] = Math.max(matrix[i - 1][j], matrix[i][j - 1]);
				}
			}
		}

		return matrix;

	}

	private static List<Integer> findLCS(String s1, String s3, int[][] matrix) {
		List<Integer> list = new ArrayList<>();

		int i = s1.length();
		int j = s3.length();

		while (i > 0 && j > 0) {
			if (s1.charAt(i - 1) == s3.charAt(j - 1)) {
				list.add(j - 1);
				j--;
				i--;
			} else if (matrix[i][j - 1] > matrix[i - 1][j]) {
				j--;
			} else {
				i--;
			}
		}
		Collections.reverse(list);
		return list;

	}

}
