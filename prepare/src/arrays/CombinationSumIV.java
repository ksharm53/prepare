package arrays;

import java.util.Arrays;

public class CombinationSumIV {

	static int matrix[][];

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3 };
		int target = 32;
		matrix = new int[nums.length + 1][target + 1];

		for (int[] each : matrix) {
			Arrays.fill(each, -1);
		}

		System.out.println(solve(nums, target, nums.length));

	}

	private static int solve(int[] nums, int target, int length) {
		if (matrix[length][target] != -1) {
			return matrix[length][target];
		}

		if (length == 0) {
			return matrix[length][target] = 0;
		}
		if (target == 0) {
			return matrix[length][target] = 1;
		}

		if (nums[length - 1] <= target) {
			return matrix[length][target] = solve(nums, target - nums[length - 1], nums.length)
					+ solve(nums, target, length - 1);
		} else {
			return matrix[length][target] = solve(nums, target, length - 1);
		}
	}

}
