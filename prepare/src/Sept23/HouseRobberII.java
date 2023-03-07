package Sept23;

import java.util.Arrays;

public class HouseRobberII {

	public static int[][] matrix;

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 1 };
		matrix = new int[nums.length][nums.length];

		for (int[] i : matrix) {
			Arrays.fill(i, -1);
		}

		System.out.println(Math.max(solve(nums, 0, nums.length - 2), solve(nums, 1, nums.length - 1)));

	}

	private static int solve(int[] nums, int start, int end) {
		if (end < start) {
			return 0;
		}
		if (end == start) {
			return nums[start];
		}

		if (matrix[start][end] != -1) {
			return matrix[start][end];
		}

		int doSomething = nums[end] + solve(nums, start, end - 2);
		int doNothing = solve(nums, start, end - 1);

		return matrix[start][end] = Math.max(doNothing, doSomething);
	}

}
