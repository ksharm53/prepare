package arraysAndStrings;

import java.util.Arrays;

public class OutofBoundaryPaths {

	static int ourM;
	static int ourN;
	static long[][][] matrix;
	static int mod = 1000000007;

	public static void main(String[] args) {
		int m = 36;
		int n = 5;
		int maxMove = 50;
		int startRow = 15;
		int startColumn = 3;

		matrix = new long[m + 1][n + 1][maxMove + 1];

		for (long[][] first : matrix) {
			for (long[] second : first) {
				Arrays.fill(second, -1);
			}
		}

		ourM = m;
		ourN = n;

		System.out.println((int) recurse(startRow, startColumn, maxMove));

	}

	private static long recurse(int startRow, int startColumn, int maxMove) {

		if (startRow == ourM || startRow < 0 || startColumn == ourN || startColumn < 0) {
			return 1;
		}

		if (matrix[startRow][startColumn][maxMove] != -1) {
			return matrix[startRow][startColumn][maxMove];
		}

		if (maxMove == 0) {
			return matrix[startRow][startColumn][maxMove] = 0;
		}

		return matrix[startRow][startColumn][maxMove] = (recurse(startRow - 1, startColumn, maxMove - 1)
				+ recurse(startRow + 1, startColumn, maxMove - 1) + recurse(startRow, startColumn - 1, maxMove - 1)
				+ recurse(startRow, startColumn + 1, maxMove - 1)) % mod;
	}

}
