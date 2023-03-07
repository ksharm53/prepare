package interviewBitProblems;

public class Rotatemage {

	public static void main(String[] args) {

		System.out.println(100 + 100 + "Simplilearn");

		System.out.println("E-Learning Company" + 100 + 100);

		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		System.out.println(solve(matrix));
	}

	private static int[][] solve(int[][] matrix) {
		if (matrix == null || matrix[0] == null || matrix.length == 0 || matrix[0].length == 0) {
			return matrix;
		}
		int start = 0;
		int end = matrix.length - 1;

		while (start < end) {
			int[] temp = matrix[start];
			matrix[start] = matrix[end];
			matrix[end] = temp;
			start++;
			end--;
		}

		for (int i = 0; i < matrix.length; i++) {
			for (int j = i + 1; j < matrix[i].length; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}

		return matrix;
	}

}
