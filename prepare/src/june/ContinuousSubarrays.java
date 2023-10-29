package june;

import java.util.ArrayList;
import java.util.List;

public class ContinuousSubarrays {

	public static void main(String[] args) {
		int[] nums = { 65, 66, 67, 66, 66, 65, 64, 65, 65, 64 };
		System.out.println(solve(nums));

	}

	private static long solve(int[] nums) {
		int i = 0;
		int j = 0;
		int min = Integer.MAX_VALUE;
		List<Integer> maxList = new ArrayList<>();
		long res = 0;

		while (j < nums.length) {
			min = Math.min(min, nums[j]);
			maxList.add(nums[j]);
			if (Math.abs(min - nums[j]) > 2) {
				int range = j - i;
				res += (range * (range - 1)) / 2;

				if (maxList.get(0) == min) {
					maxList.remove(0);
					while (!maxList.isEmpty() && maxList.get(0) < min) {
						maxList.remove(0);
					}
					if (maxList.isEmpty()) {
						min = Integer.MAX_VALUE;
					} else {
						min = maxList.get(0);
					}
				} else {
					maxList.remove(0);
				}

				i++;
			}
			j++;
		}

		return res;
	}

}
