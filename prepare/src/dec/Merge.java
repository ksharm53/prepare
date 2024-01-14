package dec;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Merge {

	public static void main(String[] args) {
		int[][] intervals = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
		System.out.println(solve(intervals));
	}

	private static int[][] solve(int[][] intervals) {
		Arrays.sort(intervals, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});

		List<int[]> list = new ArrayList<>();
		for (int i = 0; i < intervals.length; i++) {
			if (list.isEmpty()) {
				list.add(intervals[i]);
			} else {
				if (intervals[i][0] <= list.get(list.size() - 1)[1]) {
					list.get(list.size() - 1)[0] = Math.min(list.get(list.size() - 1)[0], intervals[i][0]);
					list.get(list.size() - 1)[1] = Math.max(list.get(list.size() - 1)[1], intervals[i][1]);
				} else {
					list.add(intervals[i]);
				}
			}
		}

		int[][] res = new int[list.size()][2];
		for (int i = 0; i < list.size(); i++) {
			res[i] = list.get(i);
		}
		return res;
	}

}
