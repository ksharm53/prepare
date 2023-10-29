package july;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DestroyTargets {

	public static void main(String[] args) {
		int[] nums = { 1, 5, 3, 2, 2 };
		int space = 10000;

		System.out.println(solve(nums, space));

	}

	private static int solve(int[] nums, int space) {
		Map<Integer, Integer> freqMap = new HashMap<>();
		Map<Integer, Integer> minMap = new HashMap<>();

		for (int each : nums) {
			freqMap.put(each % space, freqMap.getOrDefault(each % space, 0) + 1);
			if (minMap.containsKey(each % space)) {
				minMap.put(each % space, Math.min(minMap.get(each % space), each));
			} else {
				minMap.put(each % space, each);
			}
		}

		int max = Integer.MIN_VALUE;

		for (int each : freqMap.keySet()) {
			max = Math.max(max, freqMap.get(each));
		}

		List<Integer> list = new ArrayList<>();
		for (int each : freqMap.keySet()) {
			if (freqMap.get(each) == max) {
				list.add(each);
			}
		}

		int res = Integer.MAX_VALUE;
		for (int each : list) {
			res = Math.min(res, minMap.get(each));
		}

		return res;

	}

}
