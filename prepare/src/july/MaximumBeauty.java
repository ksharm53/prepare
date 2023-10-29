package july;

import java.util.HashMap;
import java.util.Map;

public class MaximumBeauty {

	public static void main(String[] args) {
		int[] nums = { 52, 34 };
		int k = 21;

		System.out.println(solve(nums, k));

	}

	private static int solve(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i] + k) || map.containsKey(nums[i] - k)) {
				if (map.containsKey(nums[i] + k) && map.containsKey(nums[i] - k)) {
					map.put(nums[i], Math.max(map.get(nums[i] + k), map.get(nums[i] + k)) + 1);
					map.put(nums[i] - k, map.get(nums[i] - k) + 1);
					map.put(nums[i] + k, map.get(nums[i] + k) + 1);
				} else if (map.containsKey(nums[i] + k) && !map.containsKey(nums[i] - k)) {
					map.put(nums[i], map.get(nums[i] + k) + 1);
					map.put(nums[i] + k, map.get(nums[i] + k) + 1);
				} else if (!map.containsKey(nums[i] + k) && map.containsKey(nums[i] - k)) {
					map.put(nums[i], map.get(nums[i] - k) + 1);
					map.put(nums[i] - k, map.get(nums[i] - k) + 1);
				}
			} else {
				map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
			}
		}

		int max = Integer.MIN_VALUE;

		for (int each : map.keySet()) {
			max = Math.max(max, map.get(each));
		}
		return max;
	}

}
