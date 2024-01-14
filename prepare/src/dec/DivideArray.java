package dec;

import java.util.Arrays;

public class DivideArray {

	public static void main(String[] args) {
		int[] nums = { 1, 3, 3, 2, 7, 3 };
		int k = 3;
		System.out.println(solve(nums, k));
	}

	private static int[][] solve(int[] nums, int k) {
		if (nums.length % 3 != 0) {
			return new int[][] {};
		}
		int[][] res = new int[nums.length / 3][3];
		Arrays.sort(nums);
		int i = 0;
		int j = 0;

		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		int[] temp = new int[3];
		int counter = 0;
		int innerCounter = 0;
		while (j < nums.length) {
			temp[counter] = nums[j];
			counter++;
			max = Math.max(max, nums[j]);
			min = Math.min(min, nums[j]);
			if (j - i + 1 == 3) {
				if (max - min > k) {
					return new int[][] {};
				}

				res[innerCounter] = temp;
				innerCounter++;
				temp = new int[3];
				max = Integer.MIN_VALUE;
				min = Integer.MAX_VALUE;

				counter = 0;
				i = j + 1;
			}
			j++;
		}
		return res;
	}

}
