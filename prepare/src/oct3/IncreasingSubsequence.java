package oct3;

public class IncreasingSubsequence {

	public static void main(String[] args) {
		int[] nums = { 2, 1, 5, 0, 4, 6 };

		System.out.println(solve(nums));

	}

	private static boolean solve(int[] nums) {
		int min1 = Integer.MAX_VALUE;
		int min2 = Integer.MAX_VALUE;

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] < min1) {
				min1 = nums[i];
			}
			if (nums[i] > min1) {
				min2 = Math.min(min2, nums[i]);
			}
			if (nums[i] > min2) {
				return true;
			}
		}
		return false;

	}

}
