package aug;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class MaxSum {

	public static void main(String[] args) {
		int[] nums = { 51, 71, 17, 18, 28 };
		System.out.println(solve(nums));

	}

	private static int solve(int[] nums) {
		Map<Integer, List<Integer>> map = new HashMap<>();
		int max = Integer.MIN_VALUE;
		for (int each : nums) {
			int maxDigit = findMaxDigit(each);
			List<Integer> list = map.getOrDefault(maxDigit, new ArrayList<>());
			list.add(each);
			map.put(maxDigit, list);
		}

		for (Entry<Integer, List<Integer>> eachEntry : map.entrySet()) {
			List<Integer> innerList = eachEntry.getValue();
			if (innerList.size() > 1) {
				Collections.sort(innerList, Collections.reverseOrder());
				max = Math.max(max, innerList.get(0) + innerList.get(1));
			}

		}

		return max == Integer.MIN_VALUE ? -1 : max;
	}

	private static int findMaxDigit(int each) {
		int max = Integer.MIN_VALUE;
		while (each > 0) {
			int val = each % 10;
			max = Math.max(max, val);
			each = each / 10;
		}

		return max;

	}

}
