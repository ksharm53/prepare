package Oct21;

import java.util.Arrays;
import java.util.Comparator;

public class TwoBestNonOverlappingEvents {
	public static int max;
	public static int[][] matrix;

	public static void main(String[] args) {
		int[][] events = { { 1, 5, 3 }, { 1, 5, 1 }, { 6, 6, 5 } };
		max = Integer.MIN_VALUE;

		Arrays.sort(events, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});

		matrix = new int[events.length + 1][3];

		for (int[] is : matrix) {
			Arrays.fill(is, -1);
		}

		System.out.println(solve(events, 0, 0, 0));

	}

	private static int solve(int[][] events, int pos, int count, int sum) {
		if (pos >= events.length || count == 2) {
			return 0;
		}

		if (matrix[pos][count] != -1) {
			return matrix[pos][count];
		}

		int currEndIdx = events[pos][1];
		int ceilIdx = ceiling(events, currEndIdx, pos + 1);
		int lele = 0;
		if (ceilIdx < events.length && events[ceilIdx][0] > currEndIdx) {
			lele = events[pos][2] + solve(events, ceilIdx, count + 1, sum);
		} else {
			lele = events[pos][2] + 0;
		}
		int naiLena = solve(events, pos + 1, count, sum);
		return matrix[pos][count] = Math.max(lele, naiLena);

	}

	private static int ceiling(int[][] events, int val, int idx) {
		int low = idx;
		int high = events.length - 1;
		while (low < high) {
			int mid = low + ((high - low) >> 1);
			if (events[mid][0] > val)
				high = mid;
			else
				low = mid + 1;
		}
		return low;
	}

}
