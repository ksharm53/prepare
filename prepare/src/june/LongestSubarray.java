package june;

public class LongestSubarray {

	public static void main(String[] args) {
		int[] nums = { 0, 0, 1, 1 };
		System.out.println(solve(nums));
	}

	private static int solve(int[] nums) {
		int i = 0;
		int j = 0;
		int deleteCounter = 0;
		int max = Integer.MIN_VALUE;
		while (j < nums.length) {
			if (nums[j] == 0) {
				deleteCounter++;
			}

			if (deleteCounter > 1 || j == nums.length - 1) {
				if (j == nums.length - 1 && deleteCounter <= 1) {
					max = Math.max(max, j - i);
				} else {
					max = Math.max(max, j - i - 1);
				}

				while (i < nums.length && deleteCounter > 1) {
					if (nums[i] == 0) {
						deleteCounter--;
					}
					i++;
				}
			}
			j++;
		}

		return max;
	}

}
