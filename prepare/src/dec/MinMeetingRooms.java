package dec;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MinMeetingRooms {

	public static void main(String[] args) {
		int[][] intervals = { { 7, 10 }, { 2, 4 } };
		System.out.println(solve(intervals));
	}

	private static int solve(int[][] intervals) {
		Arrays.sort(intervals, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}

		});
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}
		});

		int count = 0;

		for (int i = 0; i < intervals.length; i++) {
			if (pq.isEmpty() || intervals[i][0] < pq.peek()[1]) {
				count++;
			} else {
				pq.poll();
			}
			pq.add(intervals[i]);
		}

		return count;
	}

}
