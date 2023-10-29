package july;

public class PredictTheWinner {

	public static void main(String[] args) {
		int[] nums = { 1, 5, 2 };
		long sum = 0;

		for (int i : nums) {
			sum += i;
		}
		;

		int val = solve(nums, 0, nums.length - 1);

		if (val >= sum - val) {
			System.out.println(true);
		} else {
			System.out.println(false);
		}

	}

	private static int solve(int[] nums, int start, int end) {
		if (start > end) {
			return 0;
		}

		int left = nums[start] + Math.min(solve(nums, start + 2, end), solve(nums, start + 1, end - 1));
		int right = nums[end] + Math.min(solve(nums, start, end - 2), solve(nums, start + 1, end - 1));

		return Math.max(left, right);

	}

}
