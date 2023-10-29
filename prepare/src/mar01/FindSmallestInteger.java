package mar01;

import java.util.HashMap;
import java.util.Map;

public class FindSmallestInteger {

	public static void main(String[] args) {
		int[] nums = { 0, -3 };

		int value = 4;

		System.out.println(solve(nums, value));

	}

	private static int solve(int[] nums, int value) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int val = nums[i] % value;
			if (val < 0) {
				val += value;
			}
			map.put(val, map.getOrDefault(val, 0) + 1);
		}

		int counter = 0;
		while (map.size() > 0) {
			if (map.containsKey(counter) || map.containsKey(counter % value)) {
				if (map.containsKey(counter)) {
					map.put(counter, map.get(counter) - 1);
					if (map.get(counter) == 0) {
						map.remove(counter);
					}
				} else if (map.containsKey(counter % value)) {
					map.put(counter % value, map.get(counter % value) - 1);
					if (map.get(counter % value) == 0) {
						map.remove(counter % value);
					}
				}

			} else {
				return counter;
			}
			counter++;
		}
		return counter;
	}

}
