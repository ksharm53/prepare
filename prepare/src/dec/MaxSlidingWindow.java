package dec;

import java.util.ArrayList;
import java.util.List;

public class MaxSlidingWindow {

	public static void main(String[] args) {
		int[] nums = { -7, -8, 7, 5, 7, 1, 6, 0 };
		int k = 4;

		System.out.println(solve(nums, k));

	}

	private static int[] solve(int[] nums, int val) {
		List<Integer> res = new ArrayList<>();
		List<Integer> list = new ArrayList<>();
		int j = 0;
		int i = 0;
		while (j < nums.length) {
			while (!list.isEmpty() && list.get(list.size() - 1) < nums[j]) {
				list.remove(list.size() - 1);
			}
			list.add(nums[j]);

			if (j - i + 1 == val) {
				res.add(list.get(0));
				if (list.get(0) == nums[i]) {
					list.remove(0);
				}
				i++;
			}
			j++;
		}
		int[] resA = new int[res.size()];
		for (int k = 0; k < res.size(); k++) {
			resA[k] = res.get(k);
		}
		System.out.println(res);

		return resA;
	}

}
