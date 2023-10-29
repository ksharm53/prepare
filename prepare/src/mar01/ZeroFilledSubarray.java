package mar01;

import java.util.ArrayList;
import java.util.List;

public class ZeroFilledSubarray {

	public static void main(String[] args) {
		int[] nums = { 0, 0, 0, 0, 0, 0 };
		System.out.println(solve(nums));
	}

	private static int solve(int[] nums) {
		List<Integer> list = new ArrayList<>();
		int cal = 0;

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				int counter = 0;
				while (i < nums.length && nums[i] == 0) {
					counter++;
					i++;
				}
				list.add(counter);
			}
		}

		for (Integer eachList : list) {
			cal += (eachList * (eachList + 1)) / 2;
		}

		return cal;

	}

}
