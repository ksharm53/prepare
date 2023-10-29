package june;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class NumOfMinutes {

	static Map<Integer, List<Integer>> map;

	public static void main(String[] args) {
		int n = 11;
		int headID = 4;
		int[] manager = { 5, 9, 6, 10, -1, 8, 9, 1, 9, 3, 4 };
		int[] informTime = { 0, 213, 0, 253, 686, 170, 975, 0, 261, 309, 337 };
		map = new HashMap<>();
		System.out.println(solve(n, headID, manager, informTime));

	}

	private static int solve(int n, int headID, int[] manager, int[] informTime) {
		createMap(manager);
		int minTime = Integer.MIN_VALUE;

		Queue<long[]> queue = new LinkedList<>();
		queue.add(new long[] { headID, 0 });

		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				long[] node = queue.poll();
				long timeToBePassed = node[1] + informTime[(int) node[0]];
				List<Integer> lst = map.get((int) node[0]);
				if (lst != null) {
					for (int eachVal : lst) {
						queue.add(new long[] { eachVal, timeToBePassed });
					}
				} else {
					minTime = Math.max(minTime, (int) timeToBePassed);
				}
			}
		}
		return minTime;
	}

	private static void createMap(int[] manager) {
		for (int i = 0; i < manager.length; i++) {
			int each = manager[i];
			List<Integer> list = map.getOrDefault(each, new ArrayList<>());
			list.add(i);
			map.put(each, list);
		}

	}

}
