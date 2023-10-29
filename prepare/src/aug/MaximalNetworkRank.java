package aug;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaximalNetworkRank {

	static Map<Integer, List<Integer>> map;

	public static void main(String[] args) {
		int n = 4;
		int[][] roads = { { 0, 1 }, { 0, 3 }, { 1, 2 }, { 1, 3 } };

		map = new HashMap<>();
		System.out.println(solve(n, roads));

	}

	private static int solve(int n, int[][] roads) {
		int max = Integer.MIN_VALUE;
		makeGraph(roads);
		int[][] visited;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				visited = new int[n][n];
				int eachCount = goBFS(new int[] { i, j }, visited);
				// System.out.println("For I: " + i + "For J:" + j + "we got count:" +
				// eachCount);
				max = Math.max(max, eachCount);
			}

		}

		return max;
	}

	private static int goBFS(int[] eachRoad, int[][] visited) {
		int count = 0;

		List<Integer> first = map.getOrDefault(eachRoad[0], new ArrayList<>());
		List<Integer> second = map.getOrDefault(eachRoad[1], new ArrayList<>());

		for (int each : first) {
			if (visited[eachRoad[0]][each] != -1) {
				count++;
				visited[eachRoad[0]][each] = -1;
				visited[each][eachRoad[0]] = -1;
			}
		}

		for (int each : second) {
			if (visited[eachRoad[1]][each] != -1) {
				count++;
				visited[eachRoad[1]][each] = -1;
				visited[each][eachRoad[1]] = -1;
			}
		}

		return count;
	}

	private static void makeGraph(int[][] roads) {
		for (int[] eachRoad : roads) {
			List<Integer> list = map.getOrDefault(eachRoad[0], new ArrayList<>());
			list.add(eachRoad[1]);
			map.put(eachRoad[0], list);

			list = map.getOrDefault(eachRoad[1], new ArrayList<>());
			list.add(eachRoad[0]);
			map.put(eachRoad[1], list);
		}

	}

}
