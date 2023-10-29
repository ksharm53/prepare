package aug;

public class SearchMatrix {

	public static void main(String[] args) {
		int[][] matrix = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 60 } };
		int target = 13;

		System.out.println(solve(matrix, target));

	}

	private static boolean solve(int[][] matrix, int target) {
		int row = 0;
		int col = 0;

		while (row < matrix.length && col < matrix[0].length) {
			if (matrix[row][col] == target) {
				return true;
			} else if (row + 1 < matrix.length && matrix[row + 1][col] <= target) {
				row = row + 1;
			} else {
				col = col + 1;
			}
		}

		return false;
	}

}
