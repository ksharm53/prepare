package jan2023;

import java.util.HashSet;
import java.util.Set;

public class LongestSquareStreak {

	public static void main(String[] args) {
		int[] nums = { 4, 3, 6, 16, 8, 2 };
		System.out.println(longestSquareStreak(nums));
	}

	public static int longestSquareStreak(int[] nums) {

		Set<Long> set = new HashSet<>();
		for (int i : nums) {
			set.add((long) i);
		}

		int max = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length; i++) {
			int count = 1;
			long val = nums[i];
			while (set.contains(val * val)) {
				count++;
				max = Math.max(max, count);
				val = val * val;
			}

		}

		return max > 1 ? max : -1;
	}

}
