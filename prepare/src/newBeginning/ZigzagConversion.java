package newBeginning;

import java.util.Arrays;

public class ZigzagConversion {

	public static void main(String[] args) {
		String s = "ABCD";
		int numRows = 2;
		System.out.println(solve(s, numRows));
	}

	private static String solve(String s, int numRows) {
		int length = s.length();
		int col = 0;
		boolean flag = false;
		StringBuilder sb = new StringBuilder();
		if (numRows > 2) {
			while (length > 0) {
				if (!flag) {
					col += 1;
					length -= numRows;
				} else {
					col += (numRows - 2);
					length -= (numRows - 2);
				}

				flag = !flag;
			}
		} else {
			col = s.length();
		}

		char[][] matrix = new char[numRows][col];
		for (char[] cs : matrix) {
			Arrays.fill(cs, ' ');
		}
		int idx = 0;
		int dir = 0;
		int row = 0;
		int colum = 0;

		while (row >= 0 && row < matrix.length && colum >= 0 && colum < matrix[0].length && idx < s.length()) {
			if (dir == 0) {
				matrix[row][colum] = s.charAt(idx);
				idx++;
				if (row + 1 < matrix.length) {
					row++;
				} else {
					dir = 1;
					colum++;
				}

			} else {
				if (row == matrix.length - 1 && matrix.length > 1) {
					row--;
					continue;
				} else {
					matrix[row][colum] = s.charAt(idx);
					idx++;
					if (row == 0 || row - 1 == 0 || matrix.length == 1) {
						dir = 0;
						if (matrix.length != 1 && row != 0)
							row--;
						colum++;
					} else {
						row--;
					}
				}

			}

		}

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				// if (Character.compare(matrix[i][j], ' ') != 0) {
				if (matrix[i][j] != ' ') {
					sb.append(matrix[i][j]);
				}
			}
		}

		return sb.toString();
	}

}
