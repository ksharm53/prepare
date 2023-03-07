package interviewBitProblems;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

	public static List<List<Integer>> list;

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3 };
		list = new ArrayList<>();

		solve(nums, new ArrayList<>());
		System.out.println(list);

	}

	private static void solve(int[] nums, ArrayList<Integer> eachList) {
		if (eachList.size() == nums.length) {
			list.add(new ArrayList<>(eachList));
			return;
		}

		else {
			for (int i = 0; i < nums.length; i++) {
				int value = nums[i];
				if (eachList.contains(value)) {
					continue;
				} else {
					eachList.add(value);
					solve(nums, eachList);
					eachList.remove(eachList.size() - 1);
				}
			}
		}

	}

}
