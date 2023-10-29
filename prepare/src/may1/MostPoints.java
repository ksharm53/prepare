package may1;

import java.util.Arrays;

public class MostPoints {

	static long[] matrix;

	public static void main(String[] args) {
		int[][] questions = { { 3, 2 }, { 4, 3 }, { 4, 4 }, { 2, 5 } };

		matrix = new long[questions.length + 1];

		Arrays.fill(matrix, -1);

		System.out.println(solve(questions, 0));

	}

	private static long solve(int[][] questions, int idx) {
		if (idx >= questions.length) {
			return 0;
		}

		if (matrix[idx] != -1) {
			return matrix[idx];
		}

		long liya = questions[idx][0] + solve(questions, idx + questions[idx][1] + 1);
		long naiLiya = solve(questions, idx + 1);

		return matrix[idx] = Math.max(liya, naiLiya);
	}

}
