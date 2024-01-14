package dec;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class FindShortestSubArray {
	static Map<Integer, Integer> map;

	public static void main(String[] args) {
		int[] nums = { 1, 2, 2, 3, 1 };
		map = new HashMap<>();
		System.out.println(findShortestSubArray(nums));
	}

	public static int findShortestSubArray(int[] nums) {
		int max = Integer.MIN_VALUE;
		int length = Integer.MAX_VALUE;
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
			max = Math.max(max, map.get(nums[i]));
		}

		List<Integer> list = new ArrayList<>();
		for (int each : nums) {
			list.add(each);
		}
		for (Entry<Integer, Integer> eachEntry : map.entrySet()) {
			if (eachEntry.getValue() == max) {
				int left = list.indexOf(eachEntry.getKey());
				int right = list.lastIndexOf(eachEntry.getKey());
				length = Math.min(length, right - left + 1);
			}
		}
		return length;
	}

}
