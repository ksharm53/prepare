package arraysAndStrings;

import java.util.Arrays;

public class KthLargestElementArray {

	public static void main(String[] args) {
		int[] nums = { 1 };
		int k = 1;

		System.out.println(solve(nums, k));

	}

	private static int solve(int[] nums, int k) {

		int res = 0;
		if (nums.length < k) {
			return res;
		}
		Arrays.sort(nums);

		for (int i = nums.length - 1; i >= 0; i--) {
			k--;
			if (k <= 0) {
				return nums[i];
			}
		}

		return res;
	}

}
