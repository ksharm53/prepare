package arraysAndStrings;

import java.util.Arrays;

public class LongestConsecutiveSequence {

	public static void main(String[] args) {
		int[] nums = { 1, 2, 0, 1 };

		System.out.println(solve(nums));

	}

	private static int solve(int[] nums) {

		int maxLength = Integer.MIN_VALUE;

		if (nums.length <= 1) {
			return nums.length;
		}

		Arrays.sort(nums);

		for (int idx = 1; idx < nums.length; idx++) {
			int maxLocal = 1;
			while (idx < nums.length && idx >= 0 && (nums[idx] - nums[idx - 1] == 1 || nums[idx] == nums[idx - 1])) {
				if (nums[idx] == nums[idx - 1]) {
					idx++;
					continue;
				}
				maxLocal++;
				idx++;
			}
			maxLength = Math.max(maxLength, maxLocal);

		}
		return maxLength;
	}

}
