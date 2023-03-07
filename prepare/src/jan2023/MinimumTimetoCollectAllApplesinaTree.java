package jan2023;

import java.util.HashSet;
import java.util.Set;

public class MinimumTimetoCollectAllApplesinaTree {

	public static void main(String[] args) {
		int n = 4;
		int[][] flights = { { 0, 1, 1 }, { 0, 2, 5 }, { 1, 2, 1 }, { 2, 3, 1 } };
		int src = 0;
		int dst = 3;
		int k = 1;

		System.out.println(solve(n, flights, src, dst, k));

	}

	private static int solve(int n, int[][] flights, int src, int dst, int k) {
		int[] distance = new int[n];
		int[] hops = new int[n];
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < n; i++) {
			if (src == i) {
				distance[i] = 0;
			} else {
				distance[i] = Integer.MAX_VALUE;
			}
		}

		while (n > 0) {
			int minIdx = findMinimum(distance, set);
			for (int i = 0; i < flights.length; i++) {
				if (flights[i][0] == minIdx && !set.contains(minIdx) && hops[flights[i][0]] <= k) {
					if (distance[flights[i][1]] > flights[i][2] + distance[flights[i][0]]) {
						distance[flights[i][1]] = flights[i][2] + distance[flights[i][0]];
						hops[flights[i][1]] = hops[flights[i][0]] + 1;
					}
				}
			}
			set.add(minIdx);
			n--;
		}

		return distance[dst] == Integer.MAX_VALUE ? -1 : distance[dst];

	}

	private static int findMinimum(int[] distance, Set<Integer> set) {
		int min = Integer.MAX_VALUE;
		int minIdx = -1;
		for (int i = 0; i < distance.length; i++) {
			if (distance[i] < min && !set.contains(i)) {
				min = distance[i];
				minIdx = i;
			}
		}
		return minIdx;
	}

}
