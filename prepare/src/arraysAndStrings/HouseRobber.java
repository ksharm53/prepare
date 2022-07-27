package arraysAndStrings;

import java.util.Arrays;

public class HouseRobber {
	static int[] matrix;

	public static void main(String[] args) {
		int[] nums = { 2, 1, 1, 2 };
		matrix = new int[nums.length + 1];

		Arrays.fill(matrix, -1);
		System.out.println(solve(nums, 0));

	}

	private static int solve(int[] nums, int start) {
		if (start >= nums.length || start < 0) {
			return 0;
		}

		if (matrix[start] != -1) {
			return matrix[start];
		}

		int odd = nums[start] + solve(nums, start + 2);
		int even = solve(nums, start + 1);

		return matrix[start] = Math.max(odd, even);
	}

}
