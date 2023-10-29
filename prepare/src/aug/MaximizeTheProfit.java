package aug;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MaximizeTheProfit {

	static int[][] matrix;
	static boolean used;

	public static void main(String[] args) {
		int n = 4;
		List<List<Integer>> offers = new ArrayList<>();

		List<Integer> one = new ArrayList<>();
		one.add(0);
		one.add(0);
		one.add(5);

		offers.add(one);

		List<Integer> two = new ArrayList<>();
		two.add(3);
		two.add(3);
		two.add(1);

		offers.add(two);

		List<Integer> three = new ArrayList<>();
		three.add(1);
		three.add(2);
		three.add(5);

		offers.add(three);

		List<Integer> four = new ArrayList<>();
		four.add(0);
		four.add(0);
		four.add(7);

		offers.add(four);

		matrix = new int[offers.size()][n];
		used = false;
		for (int[] each : matrix) {
			Arrays.fill(each, -1);
		}

		Collections.sort(offers, new Comparator<List<Integer>>() {

			@Override
			public int compare(List<Integer> o1, List<Integer> o2) {
				return o1.get(0) - o2.get(0);
			}
		});

		System.out.println(solve(n, offers, 0, 0));
	}

	private static int solve(int n, List<List<Integer>> offers, int idx, int limit) {
		if (idx >= offers.size()) {
			return 0;
		}

		/*
		 * if (matrix[idx][limit] != -1) { return matrix[idx][limit]; }
		 */

		if (offers.get(idx).get(0) > limit) {
			int liya = offers.get(idx).get(2) + solve(n, offers, idx + 1, offers.get(idx).get(1));
			int naiLiya = solve(n, offers, idx + 1, limit);

			return /* matrix[idx][limit] = */ Math.max(liya, naiLiya);

		} else {
			return /* matrix[idx][limit] = */solve(n, offers, idx + 1, limit);

		}

	}

}
