package arraysAndStrings;

import java.util.Arrays;
import java.util.List;

public class CountSubSetSum {

	public static void main(String[] args) {
		List<Integer> A = Arrays.asList(30, 4, 1, 4, 6, 7, 13, 10, 8, 1, 2, 2, 4, 13, 28);
		int B = 15;

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
