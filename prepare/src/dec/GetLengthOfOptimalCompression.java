package dec;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class GetLengthOfOptimalCompression {

	public static void main(String[] args) {
		String s = "bababbaba";
		int k = 1;

		System.out.println(solve(s, k));

	}

	private static int solve(String s, int k) {
		Map<Character, Integer> map = new HashMap<>();
		for (char eachChar : s.toCharArray()) {
			map.put(eachChar, map.getOrDefault(eachChar, 0) + 1);
		}
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}
		});
		int total = 0;
		for (Entry<Character, Integer> eachEntry : map.entrySet()) {
			if (eachEntry.getValue() > 1 && eachEntry.getValue() < 10) {
				total += 2;
			} else if (eachEntry.getValue() >= 10 && eachEntry.getValue() < 100) {
				total += 3;
			} else if (eachEntry.getValue() == 100) {
				total += 4;
			} else if (eachEntry.getValue() == 1) {
				total++;
			}
			int diff = 0;
			if (eachEntry.getValue() >= 100) {
				diff = eachEntry.getValue() - 100;
			} else if (eachEntry.getValue() >= 10 && eachEntry.getValue() < 100) {
				diff = eachEntry.getValue() - 10;
			} else {
				diff = eachEntry.getValue() - 0;
			}
			pq.add(new int[] { eachEntry.getValue(), diff });
		}

		while (k > 0 && !pq.isEmpty()) {
			int[] temp = pq.poll();
			if (temp[0] == 2 || temp[0] == 1 || temp[0] == 100 || temp[0] == 10) {
				total--;
			}
			if (temp[0] - 1 > 0) {
				int diff = 0;
				if (temp[0] - 1 >= 100) {
					diff = temp[0] - 1 - 100;
				} else if (temp[0] - 1 >= 10 && temp[0] - 1 < 100) {
					diff = temp[0] - 1 - 10;
				} else {
					diff = temp[0] - 1 - 0;
				}
				pq.add(new int[] { temp[0] - 1, diff });
			}
			k--;
		}
		return total;
	}

}
