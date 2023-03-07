package arraysAndStrings;

public class MinimumSizeSubarraySum {

	public static void main(String[] args) {
		int target = 11;
		int[] nums = { 1, 1, 1, 1, 1, 1, 1, 1 };

		System.out.println(solve(target, nums));

	}

	private static int solve(int target, int[] nums) {
		if (nums.length == 0 || target == 0) {
			return 0;
		}

		int i = 0;
		int j = 0;
		int sum = 0;
		int minSize = Integer.MAX_VALUE;

		while (j < nums.length) {
			sum += nums[j];
			if (sum < target) {
				j++;
			} else if (sum >= target) {
				minSize = Math.min(j - i + 1, minSize);
				while (sum >= target) {
					sum -= nums[i];
					i++;
					if (sum >= target) {
						minSize = Math.min(j - i + 1, minSize);
					}
				}
				j++;
			}
		}
		return minSize == Integer.MAX_VALUE ? 0 : minSize;
	}

}
