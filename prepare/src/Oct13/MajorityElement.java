package Oct13;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class MajorityElement {

	public static void main(String[] args) {
		int[] nums = { 2, 2, 1, 1, 1, 2, 2 };
		System.out.println(majorityElement(nums));
	}

	public static int majorityElement(int[] nums) {

		Map<Integer, Integer> map = new HashMap<>();

		for (int each : nums) {
			map.put(each, map.getOrDefault(each, 0) + 1);
		}

		for (Entry<Integer, Integer> i : map.entrySet()) {
			if (i.getValue() > nums.length / 2) {
				return i.getKey();
			}
		}
		return -1;
	}

}
