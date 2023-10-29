package july;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CountCompleteSubarrays {

	public static void main(String[] args) {
		int[] nums = { 5, 5, 6, 5 };
		System.out.println(solve(nums));
	}

	private static int solve(int[] nums) {
		Set<Integer> set = new HashSet<>();
		int count = 0;
		for (int each : nums) {
			set.add(each);
		}
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
			for (int j = i; j < nums.length; j++) {
				map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
				if (map.size() == set.size()) {
					count += (nums.length - j);
					map = new HashMap<>();
					break;
				}

			}
		}

		return count;
	}

}
