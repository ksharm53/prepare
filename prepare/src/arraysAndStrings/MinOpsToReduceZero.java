package arraysAndStrings;

public class MinOpsToReduceZero {

	public static void main(String[] args) {
		int[] nums = { 1, 1 };
		int x = 3;

		System.out.println(solve(nums, x));

	}

	private static int solve(int[] nums, int x) {

		int result = Integer.MAX_VALUE;
		if (nums.length == 0 || x == 0) {
			return -1;
		}

		int sum = 0;

		for (int i : nums) {
			sum = sum + i;
		}

		int target = sum - x;
		if (target < 0) {
			return -1;
		}
		int currentSum = 0;

		int i = 0;
		int j = 0;

		while (j < nums.length) {
			currentSum = currentSum + nums[j];

			while (currentSum > target) {
				currentSum = currentSum - nums[i];
				i++;
			}
			if (currentSum == target) {
				result = Math.min(result, nums.length - (j - i + 1));
			}
			j++;
		}
		return result;

	}
}
