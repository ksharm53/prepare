package interviewBitProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {

	public static List<List<Integer>> list;

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3 };
		list = new ArrayList<>();
		Arrays.sort(nums);
		solve(nums, new ArrayList<>(), 0);
		System.out.println(list);

	}

	private static void solve(int[] nums, List<Integer> eachList, int start) {
		list.add(new ArrayList<>(eachList));
		for (int i = start; i < nums.length; i++) {
			if (eachList.contains(nums[i])) {
				continue;
			}
			eachList.add(nums[i]);
			solve(nums, eachList, start + 1);
			eachList.remove(eachList.size() - 1);
		}
	}

}
