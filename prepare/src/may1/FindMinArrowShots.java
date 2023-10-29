package may1;

import java.util.Arrays;
import java.util.Comparator;

public class FindMinArrowShots {

	public static void main(String[] args) {
		int[][] points = { { -2147483646, -2147483645 }, { 2147483646, 2147483647 } };
		System.out.println(solve(points));

	}

	private static int solve(int[][] points) {
		Arrays.sort(points, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[0], o2[0]);
			}
		});

		int count = 0;
		for (int i = 0; i < points.length; i++) {
			count++;
			int min = Integer.MAX_VALUE;
			min = Math.min(min, points[i][1]);
			while (i + 1 < points.length && points[i + 1][0] <= min) {
				min = Math.min(min, points[i + 1][1]);
				i++;
			}
		}

		return count;
	}

}
