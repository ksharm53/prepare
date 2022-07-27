package arraysAndStrings;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class TopKFrequentElements {

	public static void main(String[] args) {
		int[] nums = { -1, -1 };
		int k = 1;

		System.out.println(solve(nums, k));

	}

	static class Pair {
		int value;
		int frequency;

		public Pair(int value, int frequency) {
			this.value = value;
			this.frequency = frequency;
		}

	}

	private static int[] solve(int[] nums, int k) {
		int[] result = new int[k];

		Map<Integer, Integer> map = new HashMap<>();
		PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {

			@Override
			public int compare(Pair o1, Pair o2) {
				if ((o2.frequency - o1.frequency) == 0)
					return o2.value - o1.value;
				return o1.frequency - o2.frequency;
			}

		});

		for (int i : nums) {
			map.put(i, map.getOrDefault(i, 0) + 1);
		}

		for (Entry<Integer, Integer> integer : map.entrySet()) {
			pq.add(new Pair(integer.getKey(), integer.getValue()));
			if (pq.size() > k) {
				pq.poll();
			}
		}
		int i = 0;
		while (pq.size() > 0) {
			result[i] = pq.poll().value;
			i++;
		}

		return result;
	}

}
