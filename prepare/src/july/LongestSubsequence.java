package july;

import java.util.HashMap;
import java.util.Map;

public class LongestSubsequence {

	public static void main(String[] args) {
		int[] arr = { 1, 5, 7, 8, 5, 3, 4, 2, 1 };

		int difference = -2;

		System.out.println(solve(arr, difference));

	}

	private static int solve(int[] arr, int difference) {

		Map<Integer, Integer> map = new HashMap<>();
		int max = Integer.MIN_VALUE;
		for (int each : arr) {
			if (map.containsKey(each - difference)) {
				map.put(each, map.get(each - difference) + 1);
			} else {
				map.put(each, 1);
			}

			max = Math.max(max, map.get(each));
		}

		return max;
	}

}
