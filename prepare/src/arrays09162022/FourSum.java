package arrays09162022;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FourSum {

	public static void main(String[] args) {

		int[] nums = { 1000000000, 1000000000, 1000000000, 1000000000 };
		int target = -294967296;

		System.out.println(solve(nums, target));
	}

	private static List<List<Integer>> solve(int[] nums, int target) {
		Set<List<Integer>> list = new HashSet<>();
		Arrays.sort(nums);

		for (int i = 0; i + 3 < nums.length; i++) {
			for (int j = i + 1; j + 2 < nums.length; j++) {
				int k = j + 1;
				int l = nums.length - 1;
				while (k < l) {
					long sum = (long) nums[i] + (long) nums[j] + (long) nums[k] + (long) nums[l];
					if (sum < target) {
						k++;
					} else if (sum > target) {
						l--;
					} else {
						list.add(new ArrayList<>(List.of(nums[i], nums[j], nums[k], nums[l])));
						k++;
						l--;
					}
				}

			}
		}
		return new ArrayList<>(list);
	}

}
