package oct2023;

import java.util.ArrayList;
import java.util.List;

public class CountSubarrays {

	public static void main(String[] args) {

		int[] nums = { 37, 20, 38, 66, 34, 38, 9, 41, 1, 14, 25, 63, 8, 12, 66, 66, 60, 12, 35, 27, 16, 38, 12, 66, 38,
				36, 59, 54, 66, 54, 66, 48, 59, 66, 34, 11, 50, 66, 42, 51, 53, 66, 31, 24, 66, 44, 66, 1, 66, 66, 29,
				54 };
		int k = 5;
		System.out.println(solve(nums, k));
	}

	private static long solve(int[] nums, int k) {
		long count = 0;
		int max = findMax(nums);

		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == max) {
				list.add(i);
			}
		}

		for (int i = 0; i < list.size(); i++) {
			if (i + k - 1 >= list.size()) {
				break;
			}

			int firstIdx = list.get(i);
			int lastIdx = list.get(i + k - 1);
			long left = 1;
			long right = 1;
			left = firstIdx + 1;
			if (i + k == list.size()) {
				right = nums.length - lastIdx;
			} else {
				right = list.get(i + k) - lastIdx;
			}

			System.out.println("Left: " + left + " Right: " + right);

			count += (left * right);
		}

		return count;
	}

	private static int findMax(int[] nums) {
		int max = Integer.MIN_VALUE;
		for (int i : nums) {
			max = Math.max(max, i);
		}
		return max;
	}

}
