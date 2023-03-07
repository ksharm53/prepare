package arraysAndStrings;

import java.util.Arrays;

public class MaximumScorefromPerformingMultiplicationOperations {

	static int[][] matrix;

	public static void main(String[] args) {
		int[] nums = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		int[] multipliers = { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
				1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };

		matrix = new int[nums.length + 1][multipliers.length + 1];

		for (int[] i : matrix) {
			Arrays.fill(i, Integer.MIN_VALUE);
		}

		System.out.println(solve(nums, multipliers, 0, nums.length - 1, 0, 0));

	}

	private static int solve(int[] nums, int[] multipliers, int start, int end, int counter, int op) {

		if (op == multipliers.length) {
			return 0;
		}

		if (matrix[start][op] != Integer.MIN_VALUE) {
			return matrix[start][op];
		}

		int part1 = (nums[start] * multipliers[counter])
				+ solve(nums, multipliers, start + 1, end, counter + 1, op + 1);
		int part2 = (nums[end] * multipliers[counter]) + solve(nums, multipliers, start, end - 1, counter + 1, op + 1);

		return matrix[start][op] = Math.max(part1, part2);

	}

}
