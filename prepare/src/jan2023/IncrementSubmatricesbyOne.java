package jan2023;

public class IncrementSubmatricesbyOne {

	public static void main(String[] args) {
		int n = 3;
		int[][] queries = { { 1, 1, 2, 2 }, { 0, 0, 1, 1 } };
		System.out.println(solve(n, queries));

		String s = "1234";
		

	}

	private static int[][] solve(int n, int[][] queries) {
		int[][] matrix = new int[n][n];
		for (int[] is : queries) {
			int rowStart = is[0];
			int colStart = is[1];
			int rowEnd = is[2];
			int colEnd = is[3];

			for (int i = rowStart; i <= rowEnd; i++) {
				for (int j = colStart; j <= colEnd; j++) {
					matrix[i][j] += 1;
				}
			}

		}
		return matrix;

	}

}
