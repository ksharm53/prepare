package feb07;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CanFinish {

	public static void main(String[] args) {
		int n = 3;
		int[][] arr = { { 1, 0 }, { 0, 2 }, { 1, 2 } };

		System.out.println(solve(n, arr));

	}

	private static boolean solve(int n, int[][] arr) {

		if (arr.length == 0) {
			return true;
		}
		boolean[] find = new boolean[n];
		boolean[] available = new boolean[n];
		boolean[] visited = new boolean[n];

		Map<Integer, List<Integer>> map = new HashMap<>();

		for (int[] each : arr) {
			available[each[0]] = true;
			available[each[1]] = true;

			find[each[0]] = true;

			List<Integer> list = map.getOrDefault(each[1], new ArrayList<>());
			list.add(each[0]);
			map.put(each[1], list);
		}

		for (int i = 0; i < available.length; i++) {
			if (!available[i]) {
				find[i] = true;
			}
		}
		int startIndex = -1;

		Queue<Integer> queue = new LinkedList<>();
		// queue.offer(startIndex);

		for (int i = 0; i < find.length; i++) {
			if (!find[i]) {
				queue.offer(i);
				startIndex = i;
			}
		}

		if (startIndex == -1) {
			return false;
		}

		while (!queue.isEmpty()) {
			int curr = queue.poll();

			List<Integer> list = map.get(curr);
			if (list != null) {
				for (int i = 0; i < list.size(); i++) {
					int eachConnect = list.get(i);
					if (!visited[eachConnect])
						queue.add(eachConnect);

				}
			}
			available[curr] = false;
			visited[curr] = true;
		}

		for (boolean eachVal : available) {
			if (eachVal) {
				return false;
			}
		}
		return true;
	}

}
