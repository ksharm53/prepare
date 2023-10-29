package july;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class RelocateMarbles {

	public static void main(String[] args) {
		int[] nums = { 3, 4 };
		int[] moveFrom = { 4, 3, 1, 2, 2, 3, 2, 4, 1 };
		int[] moveTo = { 3, 1, 2, 2, 3, 2, 4, 1, 1 };

		System.out.println(solve(nums, moveFrom, moveTo));

	}

	private static List<Integer> solve(int[] nums, int[] moveFrom, int[] moveTo) {
		Map<Integer, Integer> map = new TreeMap<>();
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
		}

		for (int i = 0; i < moveFrom.length; i++) {
			int count = map.getOrDefault(moveFrom[i], 0);
			map.remove(moveFrom[i]);
			map.put(moveTo[i], map.getOrDefault(moveTo[i], 0) + count);
		}

		List<Integer> arr = new ArrayList<>();
		arr.addAll(map.keySet());

		return arr;
	}

}
