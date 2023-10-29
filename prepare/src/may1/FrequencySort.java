package may1;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class FrequencySort {

	public static void main(String[] args) {
		String s = "Aabb";
		System.out.println(solve(s));

	}

	static class Pair {
		char key;
		int freq;

		public Pair(char key, int freq) {
			super();
			this.key = key;
			this.freq = freq;
		}

	}

	private static String solve(String s) {
		Map<Character, Integer> map = new HashMap<>();
		PriorityQueue<Pair> queue = new PriorityQueue<>(new Comparator<Pair>() {

			@Override
			public int compare(Pair o1, Pair o2) {
				return o1.freq == o2.freq ? o1.key - o2.key : o2.freq - o1.freq;
			}

		});

		StringBuilder sb = new StringBuilder();
		for (char each : s.toCharArray()) {
			map.put(each, map.getOrDefault(each, 0) + 1);
		}

		for (Entry<Character, Integer> each : map.entrySet()) {
			queue.add(new Pair(each.getKey(), each.getValue()));
		}

		while (!queue.isEmpty()) {
			Pair each = queue.poll();
			for (int i = 1; i <= each.freq; i++) {
				sb.append(each.key);
			}
		}

		return sb.toString();
	}

}
