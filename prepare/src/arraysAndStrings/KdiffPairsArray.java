package arraysAndStrings;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class KdiffPairsArray {

	public static void main(String[] args) {
		int[] nums = { 1, 2, 4, 4, 3, 3, 0, 9, 2, 3 };
		int k = 3;

		System.out.println(solve(nums, k));

	}

	private static int solve(int[] nums, int k) {
		if (nums.length <= 1) {
			return 0;
		}
		int counter = 0;
		Set<Integer> set = new HashSet<>();

		Arrays.sort(nums);

		outerloop: for (int i = 0; i < nums.length; i++) {
			if (set.contains(nums[i])) {
				continue;
			} else {
				set.add(nums[i]);
			}
			for (int j = i + 1; j < nums.length; j++) {
				int value = Math.abs(nums[i] - nums[j]);
				if (value == k) {
					counter++;
					continue outerloop;
				} else if (value < k) {
					continue;
				} else if (value > k) {
					continue outerloop;
				}
			}
		}
		return counter;
	}

}
