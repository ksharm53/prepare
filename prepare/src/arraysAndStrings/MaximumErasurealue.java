package arraysAndStrings;

import java.util.ArrayList;
import java.util.List;

public class MaximumErasurealue {

	public static void main(String[] args) {
		int[] nums = { 5, 2, 1, 2, 5, 2, 1, 2, 5 };

		// System.out.println(solve(nums));

		System.out.println(solveSlidingWindow(nums));

	}

	private static int solveSlidingWindow(int[] nums) {

		if (nums.length == 0) {
			return 0;
		}
		int currentSum = 0;
		int result = 0;
		List<Integer> list = new ArrayList<>();

		for (int j = 0; j < nums.length; j++) {
			if (j == 0) {
				list.add(nums[j]);
				currentSum = currentSum + nums[j];
				continue;
			}

			if (!list.contains(nums[j])) {
				list.add(nums[j]);
				currentSum = currentSum + nums[j];
			} else {
				result = Math.max(result, currentSum);

				if (list.indexOf(nums[j]) == list.size() - 1) {
					list = new ArrayList<>();
					currentSum = 0;
					list.add(nums[j]);
					currentSum = currentSum + nums[j];
				}

				else {
					while (list.get(0) != nums[j]) {
						currentSum = currentSum - list.get(0);
						list.remove(0);
					}
					currentSum = currentSum - list.get(0);
					list.remove(0);
					
					list.add(nums[j]);
					currentSum = currentSum + nums[j];
				}

			}

		}
		result = Math.max(result, currentSum);

		return result;
	}

	private static int solve(int[] nums) {
		List<Integer> list = new ArrayList<>();
		int result = 0;
		if (nums.length == 0) {
			return 0;
		}

		for (int i = 0; i < nums.length; i++) {
			list = new ArrayList<>();
			list.add(nums[i]);
			for (int j = i + 1; j < nums.length; j++) {
				if (list.contains(nums[j])) {
					break;
				} else {
					list.add(nums[j]);
				}
			}

			int sum = list.stream().reduce(0, (a, b) -> a + b);
			result = Math.max(result, sum);
		}
		return result;
	}

}
