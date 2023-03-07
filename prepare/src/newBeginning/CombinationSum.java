package newBeginning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

	public static void main(String[] args) {
		int[] candidates = { 2, 3, 6, 7 };
		int target = 7;
		Arrays.sort(candidates);

		List<List<Integer>> list = new ArrayList<>();
		List<Integer> eachList = new ArrayList<>();

		solve(candidates, target, list, eachList, 0);

		System.out.println(list);

	}

	private static void solve(int[] candidates, int target, List<List<Integer>> list, List<Integer> eachList,
			int start) {

		if (target < 0) {
			return;
		} else if (target == 0) {
			list.add(new ArrayList<Integer>(eachList));
			return;
		} else {
			for (int i = start; i < candidates.length; i++) {
				int value = candidates[i];
				eachList.add(value);
				solve(candidates, target - value, list, eachList, i);
				eachList.remove(eachList.size() - 1);
			}
		}
	}

}
