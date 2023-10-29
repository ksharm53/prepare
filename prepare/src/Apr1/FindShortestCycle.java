package Apr1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class FindShortestCycle {

	static Map<Integer, List<Integer>> map;
	static Map<Integer, Integer> level;
	static Set<Integer> set;
	static int min;

	public static void main(String[] args) {
		int n = 13;
		int[][] edges = { { 0, 1 }, { 1, 2 }, { 2, 0 }, { 0, 3 }, { 3, 4 }, { 4, 5 }, { 6, 7 }, { 7, 8 }, { 8, 9 },
				{ 9, 10 }, { 10, 11 }, { 11, 12 }, { 12, 0 }, { 2, 7 }, { 2, 4 }, { 1, 8 }, { 1, 11 } };

		map = new HashMap<>();
		level = new HashMap<>();
		min = Integer.MAX_VALUE;

		solve(n, edges);
		System.out.println(min == Integer.MAX_VALUE ? -1 : min + 1);

	}

	private static void solve(int n, int[][] edges) {
		createMap(edges);

		set = new HashSet<>();

		for (int[] each : edges) {
			if (!set.contains(each[0])) {
				doBfs(each[0]);
			}
		}
	}

	private static void doBfs(int each) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(each);
		level.put(each, 1);
		set.add(each);

		while (!queue.isEmpty()) {
			int val = queue.poll();
			List<Integer> list = map.get(val);
			if (list == null) {
				continue;
			}
			for (int lev : list) {
				if (!set.contains(lev)) {
					queue.add(lev);
					level.put(lev, level.get(val) + 1);
					set.add(lev);
				} else {
					min = Math.min(min, Math.abs(level.get(lev) - level.get(val)));
				}
			}
		}

		for (int intval : level.keySet()) {
			level.put(intval, Integer.MAX_VALUE);
		}
	}

	private static void createMap(int[][] edges) {

		for (int[] each : edges) {
			List<Integer> list = map.getOrDefault(each[0], new ArrayList<>());
			list.add(each[1]);

			map.put(each[0], list);
		}

	}

}
