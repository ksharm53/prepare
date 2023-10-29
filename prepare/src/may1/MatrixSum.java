package may1;

import java.util.Arrays;

public class MatrixSum {

	public static void main(String[] args) {
		int[][] nums = { { 1 } };
		System.out.println(solve(nums));

	}

	private static int solve(int[][] nums) {
		int count = 0;
		for (int[] each : nums) {
			Arrays.sort(each);
		}

		for (int i = nums[0].length - 1; i >= 0; i--) {
			int max = Integer.MIN_VALUE;
			for (int j = 0; j < nums.length; j++) {
				max = Math.max(max, nums[j][i]);
			}
			count += max;
		}
		return count;
	}

}
