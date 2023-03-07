package Oct21;

public class MaxConsecutiveOnesIII {

	public static void main(String[] args) {
		int[] nums = { 0, 0, 0, 1 };
		int k = 4;
		System.out.println(solve(nums, k));
	}

	private static int solve(int[] nums, int k) {
		int i = 0;
		int j = 0;
		int zeroCount = 0;
		int maxSize = Integer.MIN_VALUE;

		while (j < nums.length) {
			if (nums[j] == 0) {
				zeroCount++;
			}

			if (zeroCount == k) {
				maxSize = Math.max(maxSize, j - i + 1);
				while (zeroCount == k) {
					if (nums[i] == 0) {
						zeroCount--;
					}
					i++;
				}
			}
			j++;
		}
		return maxSize;
	}

}
