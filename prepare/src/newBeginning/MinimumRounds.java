package newBeginning;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class MinimumRounds {

	public static void main(String[] args) {
		int[] tasks = { 4, 5, 5, 5 };
		Arrays.sort(tasks);

		System.out.println(solve(tasks));
	}

	private static int solve(int[] tasks) {
		Map<Integer, Integer> map = new HashMap<>();
		int counter = 0;
		for (int each : tasks) {
			map.put(each, map.getOrDefault(each, 0) + 1);
		}

		for (Entry<Integer, Integer> each : map.entrySet()) {
			if (each.getValue() == 1) {
				return -1;
			}
			int val = each.getValue();
			int[] matrix = new int[val + 1];
			Arrays.fill(matrix, -1);
			counter += findRecurse(val, matrix);
		}
		return counter;
	}

	private static int findRecurse(int val, int[] matrix) {
		if (val <= 0) {
			return 0;
		}

		if (matrix[val] != -1) {
			return matrix[val];
		}

		int two = 1 + findRecurse(val - 3, matrix);
		int three = 1 + findRecurse(val - 2, matrix);

		return matrix[val] = Math.min(two, three);

	}

}
