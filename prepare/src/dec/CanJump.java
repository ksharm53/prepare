package dec;

import java.util.Arrays;

public class CanJump {

	static int[] matrix;

	public static void main(String[] args) {
		int[] nums = { 3, 2, 1, 0, 4 };

		matrix = new int[nums.length];
		Arrays.fill(matrix, -1);
		System.out.println(solve(nums, 0));
	}

	private static boolean solve(int[] nums, int idx) {
		if (idx == (nums.length - 1)) {
			return true;
		}

		if (matrix[idx] != -1) {
			return matrix[idx] == 0 ? false : true;
		}

		boolean flag = false;
		for (int i = 1; i <= nums[idx]; i++) {
			flag = flag || solve(nums, idx + i);
		}

		matrix[idx] = flag ? 1 : 0;
		return flag;
	}

}
