package mar01;

import java.util.Arrays;

public class Test {

	public static int[][] matrix;

	public static void main(String[] args) {
		int[] satisfaction = { 34, -27, -49, -6, 65, 70, 72, -37, -57, 92, -72, 36, 6, -91, 18, 61, 77, -91, 5, 64, -16,
				5, 20, -60, -94, -15, -23, -10, -61, 27, 89, 38, 46, 57, 33, 94, -79, 43, -67, -73, -39, 72, -52, 13,
				65, -82, 26, 69, 67 };

		matrix = new int[satisfaction.length + 1][satisfaction.length + 1];
		for (int[] i : matrix) {
			Arrays.fill(i, -1);
		}
		Arrays.sort(satisfaction);

		System.out.println(solve(satisfaction, 0, 0));
	}

	private static int solve(int[] satisfaction, int idx, int counter) {
		if (idx >= satisfaction.length) {
			return 0;
		}

		if (matrix[idx][counter] != -1) {
			return matrix[idx][counter];
		}

		int liya = ((counter + 1) * satisfaction[idx]) + solve(satisfaction, idx + 1, counter + 1);
		int naiLiya = solve(satisfaction, idx + 1, counter);

		return matrix[idx][counter] = Math.max(liya, naiLiya);
	}

}
