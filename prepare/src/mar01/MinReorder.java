package mar01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class MinReorder {

	public static Map<Integer, List<Integer>> map;
	public static boolean[] done;

	public static void main(String[] args) {
		int n = 3;
		int[][] connections = { { 1, 2 }, { 2, 0 } };

		map = new HashMap<>();
		done = new boolean[n];

		System.out.println(solve(n, connections));

	}

	private static int solve(int n, int[][] connections) {
		createGraph(n, connections);
		int counter = 0;

		for (int i = 0; i < n; i++) {
			if (!done[i]) {
				counter += doBfs(i);
			}
		}
		return counter;
	}

	private static int doBfs(int val) {
		int counter = 0;
		Queue<Integer> queue = new LinkedList<>();
		queue.add(val);
		done[val] = true;

		while (!queue.isEmpty()) {
			int temp = queue.poll();
			List<Integer> list = map.get(temp);
			if (list != null) {
				for (Integer eachList : list) {
					if (!done[eachList]) {
						counter++;
						queue.add(eachList);
						done[eachList] = true;
					}
				}
			}

		}
		return counter;
	}

	private static void createGraph(int n, int[][] connections) {
		for (int[] each : connections) {
			List<Integer> list = map.getOrDefault(each[0], new ArrayList<>());
			list.add(each[1]);
			map.put(each[0], list);
		}
	}

}
