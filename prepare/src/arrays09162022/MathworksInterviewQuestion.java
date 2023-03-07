package arrays09162022;

import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class MathworksInterviewQuestion {

	public static void main(String[] args) {
		int[] numbers = { 2, 1, 2 };
		int[] q = { 1, 2, 3 };
		System.out.println(solve(numbers, q));

	}

	private static int[] solve(int[] numbers, int[] q) {
		Map<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder());
		int[] freq = new int[numbers.length];
		int[] result = new int[q.length];
		for (int i : numbers) {
			map.put(i, map.getOrDefault(i, 0) + 1);
		}

		for (int i = 0; i < numbers.length; i++) {
			Iterator<Entry<Integer, Integer>> iterator = map.entrySet().iterator();
			Entry<Integer, Integer> next = null;
			if (iterator.hasNext()) {
				next = iterator.next();
			}
			if (next != null) {
				freq[i] = next.getValue();
				map.put(next.getKey(), map.getOrDefault(next.getKey(), 0) - 1);
				if (map.get(next.getKey()) == 0) {
					map.remove(next.getKey());
				}
			}
		}

		for (int eachQ : q) {
			result[eachQ - 1] = freq[eachQ - 1];
		}
		return result;

	}

}
