package may1;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class TopKFrequent {

	public static void main(String[] args) {
		int[] nums = { 1, 1, 1, 2, 2, 3 };
		int k = 2;

		System.out.println(solve(nums, k));

	}

	private static int[] solve(int[] nums, int k) {
		int[] res = new int[k];
		PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] == o2[1] ? o1[0] - o2[0] : o1[1] - o2[1];
			}

		});

		Map<Integer, Integer> map = new HashMap<>();
		for (int each : nums) {
			map.put(each, map.getOrDefault(each, 0) + 1);
		}

		for (Entry<Integer, Integer> val : map.entrySet()) {
			queue.add(new int[] { val.getKey(), val.getValue() });
			if (queue.size() > k) {
				queue.poll();
			}
		}
		int counter = k - 1;
		while (!queue.isEmpty()) {
			res[counter] = queue.poll()[0];
			counter--;
		}

		return res;
	}

}
