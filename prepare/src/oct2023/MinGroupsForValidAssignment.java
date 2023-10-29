package oct2023;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinGroupsForValidAssignment {

	public static void main(String[] args) {
		int[] nums = { 1, 3, 1, 1, 1, 1, 2, 1, 3, 1, 3 };
		System.out.println(solve(nums));
	}

	private static int solve(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
		}

		List<Integer> listVals = new ArrayList<>(map.values());
		Collections.sort(listVals, Collections.reverseOrder());
		int counter = 0;

		for (int i = 0; i < listVals.size() - 1; i++) {
			counter += fixSize(listVals.get(listVals.size() - 1), listVals.get(i), 0);
		}
		return map.size() + counter;
	}

	private static int fixSize(int min, int max, int ret) {
		if (max - min <= 1) {
			return ret;
		}

		int next = 0;
		int nextLeft = 0;
		if (max % 2 == 0) {
			next = max / 2;
			nextLeft = next;
		} else {
			next = (max / 2) + 1;
			nextLeft = (max / 2);
		}
		return fixSize(min, next, ret + 1) + fixSize(min, nextLeft, ret + 1);

	}
}
