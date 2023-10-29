package aug;

import java.util.Arrays;
import java.util.Comparator;

public class FindLongestChain {

	static int[][] matrix;

	public static void main(String[] args) {
		int[][] pairs = { { 7, 9 }, { 4, 5 }, { 7, 9 }, { -7, -1 }, { 0, 10 }, { 3, 10 }, { 3, 6 }, { 2, 3 } };
		Arrays.sort(pairs, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0];
			}
		});

		matrix = new int[pairs.length][2002];

		for (int[] each : matrix) {
			Arrays.fill(each, -1);
		}

		System.out.println(solve(pairs, 0, -1001));
	}

	private static int solve(int[][] pairs, int idx, int lastMin) {
		if (idx >= pairs.length) {
			return 0;
		}

		int temp = lastMin < 0 ? Math.abs(lastMin) + 1000 : lastMin;

		if (matrix[idx][temp] != -1) {
			return matrix[idx][temp];
		}

		if (pairs[idx][0] > lastMin) {
			int liya = 1 + solve(pairs, idx + 1, pairs[idx][1]);
			int naiLiya = solve(pairs, idx + 1, lastMin);

			return matrix[idx][temp] = Math.max(liya, naiLiya);
		} else {
			return matrix[idx][temp] = solve(pairs, idx + 1, lastMin);
		}

	}

}
