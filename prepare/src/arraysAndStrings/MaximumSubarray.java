package arraysAndStrings;

public class MaximumSubarray {

	public static void main(String[] args) {
		int[] nums = { -2, 1, 3, -4, 5};
		System.out.println(solve(nums));
	}

	private static int solve(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		int previousLocal = 0;
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < nums.length; i++) {
			int value = previousLocal + nums[i];
			previousLocal = Math.max(nums[i], value);
			max = Math.max(max, previousLocal);
		}
		return max;
	}

}
