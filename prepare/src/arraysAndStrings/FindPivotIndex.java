package arraysAndStrings;

public class FindPivotIndex {

	public static void main(String[] args) {
		int[] nums = { 2, 1, -1 };

		System.out.println(solve(nums));

	}

	private static int solve(int[] nums) {
		if (nums.length == 0) {
			return -1;
		}

		int leftcount = 0;
		int rightCount = 0;
		for (int i : nums) {
			rightCount = rightCount + i;
		}
		rightCount = rightCount - nums[0];
		for (int i = 0; i < nums.length; i++) {
			if (leftcount == rightCount) {
				return i;
			} else {
				leftcount = leftcount + nums[i];
				if (i + 1 < nums.length) {
					rightCount = rightCount - nums[i + 1];
				}
			}
		}
		return -1;
	}

}
