package Oct21;

import java.util.HashMap;
import java.util.Map;

public class MaximumSumofDistinctSubarraysWithLengthK {

	public static void main(String[] args) {
		int[] nums = { 4, 4, 4 };
		int k = 3;

		System.out.println(solve(nums, k));

	}

	private static long solve(int[] nums, int k) {
		int i = 0;
		int j = 0;
		Map<Integer, Integer> map = new HashMap<>();
		long sum = 0;
		long max = 0L;

		while (j < nums.length) {
			map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
			sum += nums[j];

			if (j - i + 1 < k) {
				j++;
			} else if (j - i + 1 == k) {
				if (map.size() == k) {
					max = Math.max(max, sum);
					sum -= nums[i];
					map.put(nums[i], map.get(nums[i]) - 1);
					if (map.get(nums[i]) <= 0) {
						map.remove(nums[i]);
					}
					i++;
					j++;
				} else {
					while (map.get(nums[i]) == 1) {
						sum -= nums[i];
						map.put(nums[i], map.get(nums[i]) - 1);
						if (map.get(nums[i]) <= 0) {
							map.remove(nums[i]);
						}
						i++;
					}

					while (map.get(nums[i]) > 1) {
						sum -= nums[i];
						map.put(nums[i], map.get(nums[i]) - 1);
						if (map.get(nums[i]) <= 0) {
							map.remove(nums[i]);
						}
						i++;
					}
					j++;
				}
			}
		}
		return max;
	}

}
