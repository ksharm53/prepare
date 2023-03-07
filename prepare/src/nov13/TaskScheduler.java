package nov13;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class TaskScheduler {

	public static void main(String[] args) {
		char[] tasks = { 'A', 'A', 'A', 'B', 'B', 'B' };
		int n = 2;
		System.out.println(solve(tasks, n));
	}

	private static int solve(char[] tasks, int n) {
		Map<Character, Integer> map = new HashMap<>();

		for (char c : tasks) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}

		PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(
				new Comparator<Map.Entry<Character, Integer>>() {

					@Override
					public int compare(Entry<Character, Integer> o1, Entry<Character, Integer> o2) {
						return o1.getValue() == o2.getValue() ? o1.getKey() - o2.getKey()
								: o2.getValue() - o1.getValue();
					}
				});

		for (Entry<Character, Integer> eachEntry : map.entrySet()) {
			pq.add(eachEntry);
		}
		int total = 0;

		while (!pq.isEmpty()) {
			int temp = n + 1;
			List<Entry<Character, Integer>> list = new ArrayList<>();
			while (temp > 0 && !pq.isEmpty()) {
				Entry<Character, Integer> val = pq.poll();
				val.setValue(val.getValue() - 1);
				list.add(val);
				total++;
				temp--;
			}

			for (Entry<Character, Integer> entry : list) {
				if (entry.getValue() > 0) {
					pq.add(entry);
				}
			}
			if (pq.isEmpty()) {
				break;
			}
			if (temp > 0) {
				total += temp;
			}
		}
		return total;
	}

}
