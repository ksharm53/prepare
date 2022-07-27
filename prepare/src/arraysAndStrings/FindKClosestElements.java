package arraysAndStrings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class FindKClosestElements {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5 };
		int k = 4;
		int x = 3;

		System.out.println(solve(arr, k, x));
	}

	static class Pair {
		int key;
		int value;

		Pair(int key, int value) {
			this.key = key;
			this.value = value;
		}

	}

	static public List<Integer> solve(int[] arr, int k, int x) {
		int n = arr.length;
		List<Integer> list = new ArrayList<>();

		// make max priority queue
		PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
			public int compare(Pair a, Pair b) {
				// if both the keys are same then compare on the bases of their values
				if ((b.key - a.key) == 0)
					return b.value - a.value;
				return b.key - a.key;
			}
		});

		for (int i : arr) {
			pq.add(new Pair(Math.abs(i - x), i));

			if (pq.size() > k)
				pq.poll();
		}

		while (pq.size() != 0) {
			Pair p = pq.poll();
			list.add(p.value);
		}

		Collections.sort(list);
		return list;
	}
}
