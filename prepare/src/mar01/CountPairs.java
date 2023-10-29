package mar01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CountPairs {

	public static Map<Integer, List<Integer>> map;
	public static boolean[] set;

	public static void main(String[] args) {
		int n = 100000;
		int[][] edges = {};

		map = new HashMap<>();
		set = new boolean[n];

		System.out.println(solve(n, edges));
	}

	private static long solve(int n, int[][] edges) {

		createGraph(edges);
		List<Long> list = new ArrayList<>();
		long res = 0;

		for (int i = 0; i < n; i++) {
			if (!set[i]) {
				list.add(doBfs(i));
			}
		}

		if (list.size() < 2) {
			return 0;
		}

		long remainingNodes = n;

		for (int i = 0; i < list.size() - 1; i++) {
			long temp = list.get(i);
			res += temp * (remainingNodes - temp);
			remainingNodes -= temp;
		}

		return res;
	}

	private static long doBfs(int val) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(val);
		long counter = 1;
		set[val] = true;

		while (!queue.isEmpty()) {
			int temp = queue.poll();
			if (!map.containsKey(temp)) {
				continue;
			}
			for (int each : map.get(temp)) {
				if (!set[each]) {
					queue.add(each);
					set[each] = true;
					counter++;
				}
			}
		}
		return counter;
	}

	private static void createGraph(int[][] edges) {
		for (int[] each : edges) {
			List<Integer> list = map.getOrDefault(each[0], new ArrayList<>());
			list.add(each[1]);
			map.put(each[0], list);

			list = map.getOrDefault(each[1], new ArrayList<>());
			list.add(each[0]);
			map.put(each[1], list);
		}

	}

}
