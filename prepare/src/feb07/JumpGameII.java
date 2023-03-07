package feb07;

import java.util.Arrays;

public class JumpGameII {
	public static int[] matrix;

	public static void main(String[] args) {
		int[] nums = { 5, 6, 4, 4, 6, 9, 4, 4, 7, 4, 4, 8, 2, 6, 8, 1, 5, 9, 6, 5, 2, 7, 9, 7, 9, 6, 9, 4, 1, 6, 8, 8,
				4, 4, 2, 0, 3, 8, 5 };
		matrix = new int[nums.length + 1];
		Arrays.fill(matrix, -1);

		System.out.println(solve(nums, 0));

	}

	private static int solve(int[] nums, int index) {
		if (index >= nums.length - 1) {
			return 0;
		}
		if (matrix[index] != -1) {
			return matrix[index];
		}
		int range = index + nums[index];
		long min = 10001;
		for (int i = index + 1; i <= range; i++) {
			min = Math.min(min, 1 + solve(nums, i));
		}
		return matrix[index] = (int) min;
	}

}
