package Apr1;

import java.util.Arrays;
import java.util.Comparator;

public class MinGroups {

	public static void main(String[] args) {
		int[][] intervals = { { 5, 10 }, { 6, 8 }, { 1, 5 }, { 2, 3 }, { 1, 10 } };
		System.out.println(solve(intervals));
	}
	//[[1, 5], [1, 10], [2, 3], [5, 10], [6, 8]]

	private static int solve(int[][] intervals) {

		Arrays.sort(intervals, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});

		int start = 0;
		int end = intervals.length - 1;

		int partitions = 1;

		while (start < end) {

		}

		return 0;
	}

}