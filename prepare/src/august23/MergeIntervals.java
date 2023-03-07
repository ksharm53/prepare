package august23;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {

	public static void main(String[] args) {
		int[][] intervals = { { 1, 4 }, { 0, 2 }, { 3, 5 } };
		System.out.println(solve(intervals));

	}

	private static int[][] solve(int[][] intervals) {
		List<int[]> list = new ArrayList<>();

		if (intervals.length == 0) {
			return new int[][] {};
		}

		Arrays.sort(intervals, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});

		int[] firstInterval = intervals[0];
		list.add(firstInterval);

		for (int i = 1; i < intervals.length; i++) {
			int[] currentInterval = intervals[i];
			int[] listLastInterval = list.get(list.size() - 1);
			if (listLastInterval[1] >= currentInterval[0]) {
				int[] temp = new int[] { Math.min(listLastInterval[0], currentInterval[0]),
						Math.max(listLastInterval[1], currentInterval[1]) };
				list.remove(list.size() - 1);
				list.add(temp);
			} else {
				list.add(currentInterval);
			}
		}

		int[][] arrayResult = new int[list.size()][list.get(0).length];

		for (int i = 0; i < list.size(); i++) {

			arrayResult[i] = list.get(i);
		}
		return arrayResult;
	}

}
