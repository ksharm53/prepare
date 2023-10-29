package june;

public class MinSubArrayLen {

	public static void main(String[] args) {
		int target = 4;
		int[] nums = { 1, 4, 4 };

		System.out.println(solve(nums, target));

	}

	private static int solve(int[] nums, int target) {
		int i = 0;
		int j = 0;
		int sum = 0;
		int min = Integer.MAX_VALUE;
		while (j < nums.length) {
			sum += nums[j];
			if (sum >= target) {
				while (i < nums.length && sum >= target) {
					min = Math.min(min, j - i + 1);
					sum -= nums[i];
					i++;
				}
			}
			j++;
		}
		return min == Integer.MAX_VALUE ? 0 : min;
	}

}
