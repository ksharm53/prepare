package jan2023;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaxSubarraySumCircular {

	public static void main(String[] args) {
		int[] nums = { -3, -2, -3 };
		// System.out.println(solve(nums));
		solve(nums);
	}

	private static void solve(int[] nums) {
		Map<Integer, List<Integer>> map = new HashMap<>();
		int idx = -1;
		for (int i = 0; i < nums.length; i++) {
			List<Integer> list = map.getOrDefault(nums[i], new ArrayList<>());
			list.add(i);
			map.put(nums[i], list);
			if (list.size() > 1) {
				idx = list.get(0);
			}
		}
		System.out.println(idx);

		int max = Integer.MIN_VALUE;

		int val = nums[idx];
		int j = (idx + 1) % nums.length;
		int localMin = val;
		max = Math.max(max, localMin);
		while (true) {
			localMin = Math.max(localMin + nums[j], nums[j]);
			max = Math.max(max, localMin);
			j = (j + 1) % nums.length;
			if (nums[j] == val) {
				break;
			}

		}
		System.out.println(max);
	}

}
