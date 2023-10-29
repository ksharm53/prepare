package july;

import java.util.ArrayList;
import java.util.List;

public class Permute {

	static List<List<Integer>> list;

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3 };
		list = new ArrayList<>();
		solve(nums, new ArrayList<>());
		System.out.println(list);
	}

	private static void solve(int[] nums, List<Integer> innerList) {
		if (innerList.size() == nums.length) {
			list.add(new ArrayList<>(innerList));

			if (innerList.size() > 0) {
				innerList.remove(innerList.size() - 1);
			}
			return;
		}

		for (int i = 0; i < nums.length; i++) {
			if (innerList.contains(nums[i])) {
				continue;
			}
			innerList.add(nums[i]);

			solve(nums, innerList);

		}
		if (innerList.size() > 0) {
			innerList.remove(innerList.size() - 1);
		}
	}

}
