package dec;

import java.util.Arrays;
import java.util.Comparator;

public class MaxWidthOfVerticalArea {

	public static void main(String[] args) {
		int[][] points = { { 3, 1 }, { 9, 0 }, { 1, 0 }, { 1, 4 }, { 5, 3 }, { 8, 8 } };
		System.out.println(solve(points));
	}

	private static int solve(int[][] points) {
		Arrays.sort(points, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}

		});

		int max = Integer.MIN_VALUE;
		for (int i = 1; i < points.length; i++) {
			max = Math.max(max, points[i][0] - points[i - 1][0]);
		}

		return max;
	}

}
