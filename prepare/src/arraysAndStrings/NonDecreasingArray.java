package arraysAndStrings;

import java.util.Arrays;

public class NonDecreasingArray {

	public static void main(String[] args) {
		int[] nums = { 4, 2, 3 };

		int[] copy = Arrays.copyOf(nums, nums.length);
		Arrays.sort(copy);

		int countDP = getCountDP(nums, nums.length, copy, copy.length);

		if (countDP == nums.length || countDP + 1 == nums.length) {
			System.out.println(true);
		}
		System.out.println(false);

	}

	private static int getCountDP(int[] nums, int numLength, int[] copy, int copyLength) {

		int[][] matrix = new int[numLength + 1][copyLength + 1];

		for (int i = 0; i <= numLength; i++) {
			matrix[i][0] = 0;
		}

		for (int j = 0; j <= copyLength; j++) {
			matrix[0][j] = 0;
		}

		for (int i = 1; i <= numLength; i++) {
			for (int j = 1; j <= copyLength; j++) {
				if (nums[i - 1] == copy[j - 1]) {
					matrix[i][j] = 1 + matrix[i - 1][j - 1];
				} else {
					matrix[i][j] = Math.max(matrix[i][j - 1], matrix[i - 1][j]);
				}
			}
		}
		return matrix[numLength][copyLength];
	}

	private static int getCount(int[] nums, int numLength, int[] copy, int copyLength) {
		if (numLength == 0 || copyLength == 0) {
			return 0;
		}

		if (nums[numLength - 1] == copy[copyLength - 1]) {
			return 1 + getCount(nums, numLength - 1, copy, copyLength - 1);
		} else {
			return Math.max(getCount(nums, numLength, copy, copyLength - 1),
					getCount(nums, numLength - 1, copy, copyLength));
		}

	}

	private static boolean solve(int[] nums) {
		boolean flag = false;
		for (int i = 0; i < nums.length; i++) {
			int j = i + 1;
			if (j < nums.length && nums[i] > nums[j]) {
				flag = true;
			}
			while (j + 1 < nums.length) {
				if (flag && nums[j] > nums[j + 1]) {
					return false;
				} else if (!flag && nums[j] > nums[j + 1]) {
					flag = true;
				}
				if (nums[j] <= nums[j + 1]) {

				}
				j++;
			}
		}
		return true;
	}

}
