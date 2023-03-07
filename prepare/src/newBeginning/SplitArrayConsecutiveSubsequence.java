package newBeginning;

import java.util.HashMap;
import java.util.Map;

public class SplitArrayConsecutiveSubsequence {

	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 3, 4, 4, 5, 5 };
		System.out.println(solve(array));

	}

	private static boolean solve(int[] array) {
		Map<Integer, Integer> map = new HashMap<>();
		Map<Integer, Integer> wantMap = new HashMap<>();

		for (int i : array) {
			map.put(i, map.getOrDefault(i, 0) + 1);
		}

		for (int i = 0; i < array.length; i++) {
			if (map.get(array[i]) <= 0) {
				continue;
			}

			else if (wantMap.getOrDefault(array[i], 0) > 0) {
				map.put(array[i], map.getOrDefault(array[i], 0) - 1);
				wantMap.put(array[i], wantMap.getOrDefault(array[i], 0) - 1);
				wantMap.put(array[i] + 1, wantMap.getOrDefault(array[i] + 1, 0) + 1);
			} else if (map.getOrDefault(array[i], 0) > 0 && map.getOrDefault(array[i] + 1, 0) > 0
					&& map.getOrDefault(array[i] + 2, 0) > 0) {
				map.put(array[i], map.getOrDefault(array[i], 0) - 1);
				map.put(array[i] + 1, map.getOrDefault(array[i] + 1, 0) - 1);
				map.put(array[i] + 2, map.getOrDefault(array[i] + 2, 0) - 1);
				wantMap.put(array[i] + 3, wantMap.getOrDefault(array[i] + 3, 0) + 1);
			} else {
				return false;
			}
		}
		return true;
	}

}
