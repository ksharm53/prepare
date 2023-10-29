package Apr1;

import java.util.HashMap;
import java.util.Map;

public class MaximumSum {

	public static void main(String[] args) {
		int[] nums = { 18, 43, 36, 13, 7 };
		System.out.println(solve(nums));
	}

	private static int solve(int[] nums) {
		Map<Long, Integer> map = new HashMap<>();
		int max = -1;

		for (int i = 0; i < nums.length; i++) {
			long sum = 0;
			int temp = nums[i];
			while (temp > 0) {
				sum += temp % 10;
				temp = temp / 10;
			}

			int prev = map.getOrDefault(sum, -1);

			if (prev != -1) {
				max = Math.max(max, nums[i] + prev);
			}

			map.put(sum, Math.max(nums[i], prev));
		}

		return max;
	}

}
