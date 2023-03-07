package Sept23;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Citadel {

	public static void main(String[] args) {
		int n = 10;
		// int n = 5;
		//List<Integer> list = List.of(1, 5, 10, 3);
		 List<Integer> list = List.of(2, 4, 1, 3);
		// 2, -3, 2
		System.out.println(solve(n, list));
		System.out.println(solveAgain(n, list));

	}

	private static int solveAgain(int n, List<Integer> list) {
		int[] value = new int[n + 1];
		int maxValue = Integer.MIN_VALUE;
		int index = -1;

		for (int i = 0; i < list.size() - 1; i++) {
			int min = Math.min(list.get(i), list.get(i + 1));
			int max = Math.max(list.get(i), list.get(i + 1));

			value[min - 1]++;
			value[max - 1]--;
		}

		for (int i = 1; i < value.length; i++) {
			value[i] = value[i - 1] + value[i];
			if (value[i] > maxValue) {
				maxValue = value[i];
				index = i;
			}
		}
		return index;

	}

	private static int solve(int n, List<Integer> list) {
		Map<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder());

		int max = Integer.MIN_VALUE;
		int minIndex = Integer.MAX_VALUE;
		for (int i = 0; i < list.size() - 1; i++) {
			int first = list.get(i);
			int last = list.get(i + 1);
			boolean flag = first <= last ? true : false;
			while (first <= last) {
				map.put(first, map.getOrDefault(first, 0) + 1);
				if (flag) {
					first++;
				} else {
					last--;
				}
			}

		}

		for (Entry<Integer, Integer> eachEntry : map.entrySet()) {
			if (eachEntry.getValue() >= max) {
				max = eachEntry.getValue();
				minIndex = eachEntry.getKey();
			}
		}
		return minIndex;

	}

}
