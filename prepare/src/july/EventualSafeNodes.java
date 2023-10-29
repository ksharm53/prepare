package july;

import java.util.HashSet;
import java.util.Set;

public class EventualSafeNodes {

	public static void main(String[] args) {
		int[][] graph = { { 1, 2, 3, 4 }, { 1, 2 }, { 3, 4 }, { 0, 4 }, {} };
		int[] arr = new int[graph.length];
		Set<Integer> set = new HashSet<Integer>();

		for (int i = 0; i < graph.length; i++) {
			if (!set.contains(i)) {
				set.add(i);
				solve(graph, i, set, arr);
			}

		}

		System.out.println(arr);

	}

	// 0 kuch nai, 1 false; 2 true
	private static boolean solve(int[][] graph, int idx, Set<Integer> set, int[] arr) {
		if (graph[idx].length == 0) {
			arr[idx] = 2;
			return true;
		}
		boolean res = false;
		for (int each : graph[idx]) {
			if (each == idx) {
				arr[each] = 1;
				return false;
			}
			if (!set.contains(each)) {
				set.add(each);
				res = solve(graph, each, set, arr);
				if (!res) {
					arr[each] = 1;
					return false;
				}
			} else {
				if (arr[each] == 0) {
					continue;
				} else if (arr[each] == 1) {
					return false;
				} else {
					res = res && true;
				}
			}
		}

		if (res) {
			arr[idx] = 2;
		}
		return res;
	}

}
