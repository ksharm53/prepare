package oct3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class NumberOfWaysToAriveAtDestination {

	public static Map<Integer, Long> map;

	public static void main(String[] args) {
		map = new TreeMap<>();
		int result = 0;
		int n = 7;
		int[][] roads = { { 0, 6, 7 }, { 0, 1, 2 }, { 1, 2, 3 }, { 1, 3, 3 }, { 6, 3, 3 }, { 3, 5, 1 }, { 6, 5, 1 },
				{ 2, 5, 1 }, { 0, 4, 5 }, { 4, 6, 2 } };

		Map<Integer, Map<Integer, Integer>> graph = createGraph(roads);

		countPaths(graph, n - 1, 0, 0, new ArrayList<>());
		for (Map.Entry<Integer, Long> entrySet : map.entrySet()) {
			result = (int) (entrySet.getValue() % 1000000007);
			break;
		}
		System.out.println(result);
	}

	public static void countPaths(Map<Integer, Map<Integer, Integer>> graph, int target, int curr, int sum,
			List<Integer> list) {
		list.add(curr);
		if (curr == target) {
			map.put(sum, map.getOrDefault(sum, 0L) + 1);
			list.remove(list.size() - 1);
			return;
		}

		for (Map.Entry<Integer, Integer> entrySet : graph.get(curr).entrySet()) {
			if (!list.contains(entrySet.getKey())) {
				countPaths(graph, target, entrySet.getKey(), sum + entrySet.getValue(), list);
			}
		}
		if (list.size() > 0) {
			list.remove(list.size() - 1);
		}

	}

	public static Map<Integer, Map<Integer, Integer>> createGraph(int[][] roads) {
		Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
		for (int[] intersection : roads) {
			graph.putIfAbsent(intersection[0], new HashMap<>());
			graph.get(intersection[0]).put(intersection[1], intersection[2]);

			graph.putIfAbsent(intersection[1], new HashMap<>());
			graph.get(intersection[1]).put(intersection[0], intersection[2]);
		}

		return graph;
	}

}
