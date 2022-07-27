package arraysAndStrings;

import java.util.ArrayList;
import java.util.List;

public class CountSmallerNumbersAfterSelf {

	public static void main(String[] args) {
		int[] nums = new int[] { 2, 0, 1 };

		System.out.println(solve(nums));

	}

	private static List<Integer> solve(int[] nums) {
		List<Integer> sortedNums = new ArrayList<>();
		int[] result = new int[nums.length];
		List<Integer> listR = new ArrayList<>();

		for (int i = nums.length - 1; i >= 0; i--) {
			int left = 0;
			int right = sortedNums.size();

			while (left < right) {
				var mid = left + (right - left) / 2;
				if (sortedNums.get(mid) >= nums[i])
					right = mid;
				else
					left = mid + 1;
			}

			result[i] = left;
			sortedNums.add(left, nums[i]);
		}
		for (int i : result) {
			listR.add(i);
		}
		return listR;
	}

}
