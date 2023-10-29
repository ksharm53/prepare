package mar01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class MinScore {

	public static Map<Integer, List<int[]>> graph;

	public static void main(String[] args) {
		int n = 18;
		int[][] roads = { { 8, 5, 6357 }, { 8, 12, 979 }, { 1, 14, 7145 }, { 11, 16, 1109 }, { 11, 2, 1214 },
				{ 8, 14, 6543 }, { 17, 13, 7881 }, { 12, 18, 9162 }, { 14, 5, 6548 }, { 2, 16, 8107 }, { 6, 13, 4204 },
				{ 17, 6, 7215 }, { 18, 8, 6943 }, { 8, 1, 9279 }, { 5, 12, 5929 } };
		System.out.println(solve(roads, n));
	}

	private static int solve(int[][] roads, int n) {
		int min = Integer.MAX_VALUE;
		graph = new HashMap<>();
		Set<Integer> set = new HashSet<>();
		createGraph(roads);

		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { 1, Integer.MAX_VALUE });

		while (!queue.isEmpty()) {
			int[] temp = queue.poll();
			set.add(temp[0]);
			min = Math.min(temp[1], min);
			List<int[]> list = graph.get(temp[0]);
			if (list != null) {
				for (int i = 0; i < list.size(); i++) {
					if (!set.contains(list.get(i)[0])) {
						queue.add(new int[] { list.get(i)[0], list.get(i)[1] });
					}
				}
			}

		}

		return min;
	}

	private static void createGraph(int[][] roads) {
		for (int[] each : roads) {
			List<int[]> list = graph.getOrDefault(each[0], new ArrayList<>());
			list.add(new int[] { each[1], each[2] });
			graph.put(each[0], list);

			list = graph.getOrDefault(each[1], new ArrayList<>());
			list.add(new int[] { each[0], each[2] });
			graph.put(each[1], list);
		}
	}

}
