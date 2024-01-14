package oct2023;

import java.util.Arrays;

public class NumberGame {

	public static void main(String[] args) {
		int[] nums = { 5, 4, 2, 3 };
		System.out.println(solve(nums));
	}

	private static int[] solve(int[] nums) {
		Arrays.sort(nums);
		int[] arr = new int[nums.length];

		for (int i = 0; i < nums.length - 1; i += 2) {
			arr[i] = nums[i + 1];
			arr[i + 1] = nums[i];
		}

		return arr;
	}

}
