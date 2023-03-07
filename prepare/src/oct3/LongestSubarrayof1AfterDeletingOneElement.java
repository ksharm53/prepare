package oct3;

public class LongestSubarrayof1AfterDeletingOneElement {

	public static void main(String[] args) {
		int[] nums = { 1, 1, 0, 0, 1, 1, 1, 0, 1 };
		System.out.println(solve(nums));
	}

	private static int solve(int[] nums) {
		int i = 0;
		int j = 0;
		int zeroCount = 0;
		int counter = Integer.MIN_VALUE;
		while (j < nums.length) {
			if (nums[j] == 0) {
				zeroCount++;
			}
			while (i < nums.length && zeroCount > 1) {
				if (nums[i] == 0) {
					zeroCount--;
				}
				i++;
			}
			counter = Math.max(counter, j - i);
			j++;
		}

		return counter;
	}

}
