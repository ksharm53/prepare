package june;

public class LongestAlternatingSubarray {

	public static void main(String[] args) {
		int[] nums = { 2, 3, 4, 5 };
		int threshold = 4;

		System.out.println(solve(nums, threshold));

	}

	private static int solve(int[] nums, int threshold) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] % 2 == 0 && nums[i] <= threshold) {
				int temp = i;
				int next = 1;
				while (temp + 1 < nums.length && nums[temp + 1] <= threshold && nums[temp + 1] % 2 == next) {
					temp++;
					next = (next == 1 ? 0 : 1);
				}
				max = Math.max(max, temp - i + 1);

			}
		}
		return max == Integer.MIN_VALUE ? 0 : max;
	}

}
