package oct3;

import java.util.Arrays;

public class ThreeSumClosest {

	public static void main(String[] args) {
		int[] nums = { -1, 2, 1, -4 };
		int target = 1;
		Arrays.sort(nums);
		System.out.println(solve(nums, target));

	}

	public static int solve(int[] nums, int target) {
		if (nums.length < 3) {
			return -1;
		}
		int minDiff = Integer.MAX_VALUE;
		int result = -1;

		for (int i = 0; i < nums.length - 2; i++) {
			int second = i + 1;
			int last = nums.length - 1;
			while (second < last) {
				int sumTemp = nums[i] + nums[second] + nums[last];
				int diff = Math.abs(sumTemp - target);

				if (sumTemp == target) {
					return sumTemp;
				} else if (sumTemp < target) {
					second++;
				} else {
					last--;
				}

				if (diff < minDiff) {
					minDiff = diff;
					result = sumTemp;
				}

			}
		}

		return result;
	}

}
