package august23;

import java.util.HashMap;
import java.util.Map;

public class ContinuousSubarraySum {

	public static void main(String[] args) {
		int[] nums = { 23, 2, 4, 6, 6 };
		int k = 7;

		System.out.println(checkSubarraySum(nums, k));

	}

	public static boolean checkSubarraySum(int[] nums, int k) {

		Map<Integer, Integer> map = new HashMap<>();
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			sum %= k;

			if (sum == 0 && i > 0) {
				return true;
			}

			if (map.containsKey(sum) && i - map.get(sum) > 1) {
				return true;
			}
			if (!map.containsKey(sum)) {
				map.put(sum, i);
			}

		}
		return false;
	}
}
