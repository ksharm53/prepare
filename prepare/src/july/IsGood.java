package july;

import java.util.Arrays;

public class IsGood {

	public static void main(String[] args) {
		int[] nums = { 1, 1, 1 };
		System.out.println(solve(nums));
	}

	private static boolean solve(int[] nums) {

		int max = Integer.MIN_VALUE;

		for (int each : nums) {
			max = Math.max(max, each);
		}

		Arrays.sort(nums);
		int i;

		for (i = 1; i <= max; i++) {
			if (nums[i - 1] != i) {
				return false;
			}
		}
		if (i - 1 >= nums.length || nums[i - 1] != max || i - 1 != nums.length - 1) {
			return false;
		}

		return true;
	}

}
