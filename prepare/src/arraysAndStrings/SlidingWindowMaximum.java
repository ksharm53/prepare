package arraysAndStrings;

import java.util.ArrayList;
import java.util.List;

public class SlidingWindowMaximum {

	public static void main(String[] args) {
		int[] nums = { 1, 3, -1, -3, 5, 3, 6, 7 };
		int k = 3;

		System.out.println(solve(nums, k));

	}

	private static int[] solve(int[] nums, int k) {
		int size = nums.length;
		List<Integer> ans = new ArrayList<>();
		List<Integer> result = new ArrayList<>();

		int i = 0;
		int j = 0;

		while (j < size) {

			if (ans.isEmpty()) {
				ans.add(nums[j]);
			} else {
				while (ans.size() > 0 && ans.get(ans.size() - 1) < nums[j]) {
					ans.remove(ans.size() - 1);
				}
				ans.add(nums[j]);
			}

			if (j - i + 1 < k) {
				j++;
			}

			else if (j - i + 1 == k) {
				result.add(ans.get(0));
				if (ans.get(0) == nums[i]) {
					ans.remove(0);
				}
				i++;
				j++;

			}
		}
		System.out.println(result);
		int[] ansArray = new int[result.size()];

		for (int ad = 0; ad < result.size(); ad++) {
			ansArray[ad] = result.get(ad);
		}
		return ansArray;
	}

}
