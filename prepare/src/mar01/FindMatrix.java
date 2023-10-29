package mar01;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindMatrix {

	public static void main(String[] args) {
		int[] nums = { 8, 8, 8, 8, 2, 4, 4, 2, 4 };
		System.out.println(solve(nums));
	}

	private static List<List<Integer>> solve(int[] nums) {

		List<List<Integer>> res = new ArrayList<>();

		while (true) {
			Set<Integer> set = new HashSet<>();

			for (int i = 0; i < nums.length; i++) {
				if (nums[i] != -1 && !set.contains(nums[i])) {
					set.add(nums[i]);
					nums[i] = -1;
				}
			}

			int size = set.size();

			if (size == 0) {
				break;
			}
			List<Integer> list = new ArrayList<>(set);
			res.add(list);
		}

		return res;
	}

}
