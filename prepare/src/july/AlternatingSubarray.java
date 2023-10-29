package july;

public class AlternatingSubarray {

	public static void main(String[] args) {
		int[] nums = { 21, 9, 5 };
		System.out.println(solve(nums));

	}

	private static int solve(int[] nums) {
		int i = 0;
		int j = 0;
		int max = Integer.MIN_VALUE;
		boolean flag = true;
		// sedha false

		while (j < nums.length) {
			if (j - i + 1 > 1 && ((!flag && nums[j] - nums[j - 1] != 1) || (flag && nums[j - 1] - nums[j] != 1))) {
				max = Math.max(max, j - i);
				if (nums[j] - nums[j - 1] == 1) {
					i = j - 1;
					flag = false;
				} else {
					i = j;
					flag = true;
				}

			} else if (j == nums.length - 1) {
				max = Math.max(max, j - i + 1);
			}
			j++;
			flag = !flag;
		}

		return (max == Integer.MIN_VALUE || max == 1) ? -1 : max;
	}

}
