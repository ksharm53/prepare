package oct3;

import java.util.Arrays;

public class SingleNumberIII {

	public static void main(String[] args) {
		int[] nums = { 1, 2, 1, 3, 2, 5 };
		System.out.println(solve(nums));

	}

	private static int[] solve(int[] nums) {
		int[] result = new int[2];
		int counter = 0;
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {
			if ((i == nums.length - 1 && i - 1 >= 0 && nums[i - 1] < nums[i])
					|| (i == 0 && i + 1 < nums.length && nums[i + 1] > nums[i])
					|| (i - 1 >= 0 && i + 1 < nums.length && nums[i - 1] < nums[i] && nums[i + 1] > nums[i])) {
				result[counter] = nums[i];
				counter++;
			}
		}
		return result;
	}

}
