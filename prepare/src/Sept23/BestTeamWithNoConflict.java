package Sept23;

import java.util.Arrays;
import java.util.Comparator;

public class BestTeamWithNoConflict {

	public static int[][] matrix;

	public static void main(String[] args) {
		int[] scores = { 1, 3, 7, 3, 2, 4, 10, 7, 5 };
		int[] ages = { 4, 5, 2, 1, 1, 2, 4, 1, 4 };

		matrix = new int[scores.length][scores.length];
		for (int[] each : matrix) {
			Arrays.fill(each, -1);
		}

		System.out.println(solve(scores, ages));

	}

	public static int solve(int[] scores, int[] ages) {
		int n = scores.length;

		int[][] combined = new int[n][2];
		for (int i = 0; i < n; i++) {
			combined[i] = new int[] { ages[i], scores[i] };
		}

		Arrays.sort(combined, new Comparator<>() {
			@Override
			public int compare(int[] a, int[] b) {
				return a[0] == b[0] ? a[1] - b[1] : a[0] - b[0];
			}
		});

		int[] list = new int[combined.length];
		for (int i = 0; i < combined.length; i++) {
			list[i] = combined[i][1];
		}

		int[] copyArray = Arrays.copyOf(list, list.length);
		Arrays.sort(copyArray);

		int lis = lis(list, list.length - 1, copyArray, copyArray.length - 1);

		return lis;
	}

	private static int lis(int[] is, int length, int[] copyArray, int length2) {
		if (length < 0 || length2 < 0) {
			return 0;
		}

		if (matrix[length][length2] != -1) {
			return matrix[length][length2];
		}

		if (is[length] == copyArray[length2]) {
			return matrix[length][length2] = (is[length] + lis(is, length - 1, copyArray, length2 - 1));
		} else {
			return matrix[length][length2] = Math.max(lis(is, length - 1, copyArray, length2),
					lis(is, length, copyArray, length2 - 1));
		}

	}

}
