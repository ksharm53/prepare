package june;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class TotalCost {

	public static void main(String[] args) {
		int[] costs = { 1, 2, 4, 1 };
		int k = 3;
		int candidates = 3;

		System.out.println(solve(costs, k, candidates));

	}

	private static long solve(int[] costs, int k, int candidates) {
		long cost = 0;
		Set<Integer> set = new HashSet<>();

		PriorityQueue<int[]> left = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});

		PriorityQueue<int[]> right = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});

		int i = 0;
		int j = costs.length - 1;
		while (k > 0) {
			while (i < costs.length && !set.contains(i) && left.size() < candidates) {
				left.add(new int[] { costs[i], i });
				i++;
			}

			while (j >= 0 && !set.contains(j) && right.size() < candidates) {
				right.add(new int[] { costs[j], j });
				j--;
			}

			if (!left.isEmpty() && !right.isEmpty()) {
				if (left.peek()[0] < right.peek()[0]) {
					if (set.contains(left.peek()[1])) {
						left.poll();
						continue;
					}
					int[] val = left.poll();
					cost += val[0];
					set.add(val[1]);
				} else if (left.peek()[0] > right.peek()[0]) {
					if (set.contains(right.peek()[1])) {
						right.poll();
						continue;
					}
					int[] val = right.poll();
					cost += val[0];
					set.add(val[1]);
				} else {
					if (left.peek()[1] < right.peek()[1]) {
						if (set.contains(left.peek()[1])) {
							left.poll();
							continue;
						}
						int[] val = left.poll();
						cost += val[0];
						set.add(val[1]);
					} else if (left.peek()[1] > right.peek()[1]) {
						if (set.contains(right.peek()[1])) {
							right.poll();
							continue;
						}
						int[] val = right.poll();
						cost += val[0];
						set.add(val[1]);
					} else {
						int[] val = right.poll();
						left.poll();
						cost += val[0];
						set.add(val[1]);
					}
				}
			} else {
				if (left.isEmpty() && !right.isEmpty()) {
					if (set.contains(right.peek()[1])) {
						right.poll();
						continue;
					}
					int[] val = right.poll();
					cost += val[0];
					set.add(val[1]);
				} else if (!left.isEmpty() && right.isEmpty()) {
					if (set.contains(left.peek()[1])) {
						left.poll();
						continue;
					}
					int[] val = left.poll();
					cost += val[0];
					set.add(val[1]);
				} else {
					break;
				}
			}

			k--;
		}

		return cost;
	}

}
