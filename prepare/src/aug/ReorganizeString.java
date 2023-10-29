package aug;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class ReorganizeString {

	public static void main(String[] args) {
		String s = "bbbbbbb";
		System.out.println(solve(s));

	}

	private static String solve(String s) {
		Map<Character, Integer> map = new HashMap<>();
		for (char eachChar : s.toCharArray()) {
			map.put(eachChar, map.getOrDefault(eachChar, 0) + 1);
		}

		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o2[1] - o1[1];
			}
		});

		for (Entry<Character, Integer> eachEntry : map.entrySet()) {
			pq.add(new int[] { eachEntry.getKey(), eachEntry.getValue() });
		}

		StringBuilder sb = new StringBuilder();

		while (!pq.isEmpty()) {
			int[] first = pq.poll();
			if (sb.isEmpty() || sb.charAt(sb.length() - 1) != (char) first[0]) {
				sb.append((char) first[0]);
				if (first[1] - 1 > 0) {
					pq.add(new int[] { first[0], first[1] - 1 });
				}
			} else {
				if (pq.isEmpty()) {
					return "";
				} else {
					int[] second = pq.poll();
					sb.append((char) second[0]);

					if (second[1] - 1 > 0) {
						pq.add(new int[] { second[0], second[1] - 1 });
					}
				}

				pq.add(first);
			}
		}

		return sb.toString();
	}

}
