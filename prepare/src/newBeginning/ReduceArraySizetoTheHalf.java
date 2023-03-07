package newBeginning;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ReduceArraySizetoTheHalf {

	public static void main(String[] args) {
		int[] arr = { 9, 77, 63, 22, 92, 9, 14, 54, 8, 38, 18, 19, 38, 68, 58, 19 };
		System.out.println(solve(arr));

	}

	private static int solve(int[] arr) {
		if (arr.length == 0) {
			return 0;
		}
		Map<Integer, Integer> map = new HashMap<>();
		PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
		int counter = 0;

		for (int i : arr) {
			map.put(i, map.getOrDefault(i, 0) + 1);
		}
		int mid = arr.length / 2;

		for (Integer integer : map.values()) {
			pq.add(integer);
		}

		while (mid > 0 && !pq.isEmpty()) {
			counter++;
			mid = mid - pq.poll();

		}
		return counter;

	}

}
