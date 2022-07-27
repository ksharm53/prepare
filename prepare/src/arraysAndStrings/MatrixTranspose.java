package arraysAndStrings;

public class MatrixTranspose {

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }};

		System.out.println(solve(matrix));

	}

	private static int[][] solve(int[][] matrix) {

		int[][] result = new int[matrix[0].length][matrix.length];

		for (int i = 0; i < matrix[0].length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				result[i][j] = matrix[j][i];
			}
		}
		return result;
	}

}
