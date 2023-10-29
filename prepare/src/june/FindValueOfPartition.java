package june;

import java.util.Arrays;

public class FindValueOfPartition {

	public static void main(String[] args) {
		int[] nums = { 84, 11, 100, 100, 75 };
		// 11, 75, 84, 100, 100
		System.out.println(solve(nums));

	}

	private static int solve(int[] nums) {
		Arrays.sort(nums);
		int diff = Integer.MAX_VALUE;
		for (int i = 0; i < nums.length - 1; i++) {
			diff = Math.min(diff, Math.abs(nums[i] - nums[i + 1]));
		}

		return diff;
	}

}
