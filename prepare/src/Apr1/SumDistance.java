package Apr1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SumDistance {

	public static void main(String[] args) {
		int[] nums = { 0, 5, 3 };
		System.out.println(distance(nums));
	}

	public static long[] distance(int[] nums) {
		Map<Integer, List<Integer>> map = new HashMap<>();
		long[] arr = new long[nums.length];

		for (int i = 0; i < nums.length; i++) {
			List<Integer> list = map.getOrDefault(nums[i], new ArrayList<>());
			list.add(i);
			map.put(nums[i], list);
		}

		for (Map.Entry<Integer, List<Integer>> eachEntry : map.entrySet()) {
			if (eachEntry.getValue().size() > 1) {
				long prefSum = 0;
				long sum = 0;
				List<Integer> list = eachEntry.getValue();
				for (int each : list) {
					sum += each;
				}

				for (int i = 0; i < list.size(); i++) {
					prefSum += list.get(i);
					long left = ((i - 0) * list.get(i)) - (prefSum - list.get(i));
					long right = (sum - prefSum) - ((list.size() - i - 1) * list.get(i));

					arr[list.get(i)] = left + right;
				}

			}
		}

		return arr;
	}

}
