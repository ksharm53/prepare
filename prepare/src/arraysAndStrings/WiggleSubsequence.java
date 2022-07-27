package arraysAndStrings;

public class WiggleSubsequence {

	public static void main(String[] args) {
		int[] nums = { 1, 1, 7, 4, 9, 2, 5 };

		System.out.println(solve(nums));

	}

	private static int solve(int[] nums) {

		boolean flag = false;
		if (nums.length <= 1 || (nums.length == 2 && nums[0] != nums[1])) {
			return nums.length;
		} else if (nums.length == 2 && nums[0] == nums[1]) {
			return 1;
		}

		int k = 0;
		while (k < nums.length - 1 && nums[k] == nums[k + 1]) {
			k++;
		}
		if (k == nums.length - 1) {
			return 1;
		}

		int counter = 2;
		if (nums[k] < nums[k + 1]) {
			flag = false;
		} else {
			flag = true;
		}
		for (int i = k; i < nums.length; i++) {
			int value = nums[i - 1];
			if ((!flag && nums[i] < value) || (flag && nums[i] > value)) {
				counter++;
				flag = !flag;
			} else {
				nums[i - 1] = nums[i];
			}
		}
		return counter;
	}

}
