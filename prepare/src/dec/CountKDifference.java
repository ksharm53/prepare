package dec;

import java.util.HashMap;
import java.util.Map;

public class CountKDifference {

	public static void main(String[] args) {
		int[] nums = { 7, 7, 8, 3, 1, 2, 7, 2, 9, 5 };
		int k = 6;
		System.out.println(solve(nums, k));

	}

	private static int solve(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i] - k)) {
				count += map.get(nums[i] - k);
			}
			if (map.containsKey(k + nums[i])) {
				count += map.get(k + nums[i]);
			}
			map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
		}
		return count;
	}

}
