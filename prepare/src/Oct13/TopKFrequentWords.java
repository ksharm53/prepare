package Oct13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class TopKFrequentWords {

	public static void main(String[] args) {
		String[] words = { "i", "love", "leetcode", "i", "love", "coding" };
		int k = 2;

		System.out.println(solve(words, k));

	}

	private static List<String> solve(String[] words, int k) {
		PriorityQueue<String[]> pq = new PriorityQueue<>(new Comparator<String[]>() {

			@Override
			public int compare(String[] o1, String[] o2) {
				return o2[1].equals(o1[1]) ? o2[0].compareTo(o1[0]) : Integer.valueOf(o1[1]) - Integer.valueOf(o2[1]);
			}
		});

		Map<String, Integer> map = new HashMap<>();

		for (String each : words) {
			map.put(each, map.getOrDefault(each, 0) + 1);
		}

		for (Entry<String, Integer> entry : map.entrySet()) {
			pq.add(new String[] { entry.getKey(), String.valueOf(entry.getValue()) });
			if (pq.size() > k) {
				pq.poll();
			}
		}
		List<String> list = new ArrayList<>();
		while (!pq.isEmpty()) {
			list.add(pq.poll()[0]);
		}
		Collections.reverse(list);

		return list;
	}

}
