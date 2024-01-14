package dec;

import java.util.Arrays;
import java.util.Comparator;

public class MaxValue {
	static int[][][] matrix;

	public static void main(String[] args) {

		int[][] events = { { 19, 42, 7 }, { 41, 73, 15 }, { 52, 73, 84 }, { 84, 92, 96 }, { 6, 64, 50 }, { 12, 56, 27 },
				{ 22, 74, 44 }, { 38, 85, 61 } };
		int k = 5;
		Arrays.sort(events, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0];
			}
		});

		matrix = new int[k + 1][events.length + 1][100000];
		for (int[][] each : matrix) {
			for (int[] innerEach : each) {
				Arrays.fill(innerEach, -1);
			}
		}
		System.out.println(solve(events, k, 0, 0));

	}

	private static int solve(int[][] events, int k, int idx, int max) {
		if (idx == events.length || k == 0) {
			return 0;
		}

		if (matrix[k][idx][max] != -1) {
			return matrix[k][idx][max];
		}

		if (events[idx][0] > max) {
			int liya = events[idx][2] + solve(events, k - 1, idx + 1, Math.max(max, events[idx][1]));
			int naiLiya = solve(events, k, idx + 1, max);
			return matrix[k][idx][max] = Math.max(liya, naiLiya);
		} else {
			return matrix[k][idx][max] = solve(events, k, idx + 1, max);
		}
	}

}
