package arraysAndStrings;

import java.util.Arrays;
import java.util.List;

public class CountSubSetSum {

	public static void main(String[] args) {
		List<Integer> A = Arrays.asList(6, 10, 1, 4, 7, 1, 9, 5, 10, 5, 3, 5, 10, 1, 5, 4, 4, 3, 8, 10, 10, 7, 4, 1, 6,
				7, 6, 6, 8, 3, 4, 4, 2, 7, 7, 1, 9, 6, 5, 9, 10, 9, 5, 1, 2, 2, 4, 5, 4, 3, 4, 5, 9, 10, 8, 4, 6, 3, 1,
				5, 8, 7, 8, 9, 3, 5, 1, 1, 2, 5, 1, 3, 6, 8, 3, 7, 9, 8, 3, 4, 2, 8, 8, 10, 7, 7, 5, 4, 2, 8, 9, 9, 4,
				6, 7, 8);
		int B = 185;

		int[][] matrix = new int[A.size() + 1][B + 1];

		System.out.println(solution(matrix, B, A));
	}

	private static int solution(int[][] matrix, int B, List<Integer> A) {

		int n = A.size();

		for (int i = 0; i < B + 1; i++) {
			matrix[0][i] = 0;
		}

		for (int i = 0; i < n + 1; i++) {
			matrix[i][0] = 1;
		}

		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < B + 1; j++) {

				if (A.get(i - 1) <= j) {
					matrix[i][j] = (matrix[i][j - A.get(i - 1)] % 1000000007) + (matrix[i - 1][j] % 1000000007);
				}

				else {
					matrix[i][j] = matrix[i - 1][j] % 1000000007;
				}
			}
		}

		return matrix[n][B] % 1000000007;

	}

}
