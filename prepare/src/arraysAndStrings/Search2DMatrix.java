package arraysAndStrings;

public class Search2DMatrix {

	public static void main(String[] args) {
		int[][] matrix = { { 1, 1 } };
		int target = 1;

		System.out.println(solve(matrix, target));

	}

	private static boolean solve(int[][] matrix, int target) {

		if (matrix.length == 0) {
			return false;
		}
		int i = 0;
		int j = matrix[0].length - 1;

		while (i >= 0 && i < matrix.length && j >= 0 && j < matrix[0].length) {
			if (matrix[i][j] == target) {
				return true;
			} else if (matrix[i][j] > target) {
				j--;
			} else {
				i++;
			}
		}
		return false;
	}

}
