package may1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class CountCompleteComponents {

	static Map<Integer, List<Integer>> graph;
	static Set<Integer> set;

	public static void main(String[] args) {
		int n = 6;
		int[][] edges = { { 0, 1 }, { 0, 2 }, { 1, 2 }, { 3, 4 } };

		graph = new HashMap<>();
		set = new HashSet<>();
		int count = 0;
		makeGraph(edges, n);

		for (int i = 0; i < n; i++) {
			if (!set.contains(i)) {
				if (solve(n, edges, i)) {
					count++;
				}

			}

		}
		System.out.println(count);

	}

	private static boolean solve(int n, int[][] edges, int curr) {
		int nodeCount = 0;

		Set<String> innerSet = new HashSet<>();

		Queue<Integer> queue = new LinkedList<>();
		queue.add(curr);
		set.add(curr);
		nodeCount++;

		while (!queue.isEmpty()) {
			int each = queue.poll();
			if (graph.get(each) != null) {
				List<Integer> innerList = graph.get(each);
				for (int val : innerList) {
					if (!innerSet.contains(val + "-" + each)) {
						innerSet.add(each + "-" + val);
					}

					if (!set.contains(val)) {
						queue.add(val);
						set.add(val);
						nodeCount++;
					}
				}
			}

		}

		int allowedEdgeCount = (nodeCount * (nodeCount - 1) / 2);
		if (innerSet.size() == allowedEdgeCount) {
			return true;
		} else {
			return false;
		}
	}

	private static void makeGraph(int[][] edges, int n) {
		int[] arr = new int[n];
		for (int[] each : edges) {
			arr[each[0]] = -1;
			arr[each[1]] = -1;
			List<Integer> list = graph.getOrDefault(each[0], new ArrayList<>());
			list.add(each[1]);
			graph.put(each[0], list);

			list = graph.getOrDefault(each[1], new ArrayList<>());
			list.add(each[0]);
			graph.put(each[1], list);

		}

		for (int i = 0; i < n; i++) {
			if (arr[i] != -1) {
				graph.put(i, new ArrayList<>());
			}
		}
	}

}
