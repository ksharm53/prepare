package aug;

import java.util.HashMap;
import java.util.Map;

public class MinimumSeconds {

	public static void main(String[] args) {
		int[] nums = { 2, 1, 3, 3, 2 };
		Map<Integer, Integer> map = new HashMap<>();
		for (int i : nums) {
			map.put(i, map.getOrDefault(i, 0) + 1);
		}

		solve(nums, map, 0, 0);

	}

	private static void solve(int[] nums, Map<Integer, Integer> freq, int idx, int time) {
		if (freq.size() == 1) {
			return;
		}

		for (int i = 0; i < nums.length; i++) {

		}

	}

}
