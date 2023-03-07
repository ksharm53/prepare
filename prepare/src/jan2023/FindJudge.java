package jan2023;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindJudge {

	public static void main(String[] args) {
		int n = 1;
		int[][] trust = {};
		System.out.println(solve(n, trust));

	}

	private static int solve(int n, int[][] trust) {
		int[] arr = new int[n];
		Map<Integer, List<Integer>> map = new HashMap<>();
		for (int[] each : trust) {
			arr[each[0] - 1]++;
			List<Integer> list = map.getOrDefault(each[1], new ArrayList<Integer>());
			list.add(each[0]);
			map.put(each[1], list);
		}

		for (int i = 0; i < arr.length; i++) {
			if (map.containsKey(i + 1) && arr[i] == 0 && map.get(i + 1).size() == n - 1) {
				return i + 1;
			}
		}

		return -1;
	}

}
