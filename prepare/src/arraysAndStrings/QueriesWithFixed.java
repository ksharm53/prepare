package arraysAndStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class QueriesWithFixed {

	public static void main(String[] args) {
		List<Integer> arr = Arrays.asList(33, 11, 44, 11, 55);
		List<Integer> queries = Arrays.asList(1, 2, 3, 4, 5);
		System.out.println(solve(arr, queries));

		System.out.println(solveAgain(arr, queries));
	}

	private static List<Integer> solve(List<Integer> arr, List<Integer> queries) {
		List<Integer> list = new ArrayList<>();

		for (int i = 0; i < queries.size(); i++) {
			int query = queries.get(i);

			int start = 0;
			int end = 0;
			PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
			int localMax = Integer.MIN_VALUE;
			int eachMin = Integer.MAX_VALUE;

			while (end < arr.size()) {
				pq.add(arr.get(end));
				if (end - start + 1 < query) {
					end++;
				} else if (end - start + 1 == query) {
					localMax = pq.peek();
					eachMin = Math.min(eachMin, localMax);
					pq.remove(arr.get(start));
					start++;
					end++;
				}
			}
			list.add(eachMin);
		}
		return list;
	}

	public static List<Integer> solveAgain(List<Integer> arr, List<Integer> queries) {

		List<Integer> result = new ArrayList<>();

		for (Integer d : queries) {

			PriorityQueue<Item> pq = new PriorityQueue<>();

			Integer min = Integer.MAX_VALUE;
			for (int i = 0; i < arr.size(); i++) {

				pq.add(Item.of(arr.get(i), i));

				while (pq.peek().getIndex() <= i - d) {
					pq.poll();
				}

				if (i >= d - 1 && pq.peek().getValue() < min) {
					min = pq.peek().getValue();
				}
			}

			result.add(min);
		}

		return result;
	}

	static class Item implements Comparable<Item> {
		private Integer value;
		private Integer index;

		public int compareTo(Item item) {
			return this.value.compareTo(item.value) * -1;
		}

		public Item(Integer value, Integer index) {
			this.value = value;
			this.index = index;
		}

		public static Item of(Integer value, Integer index) {
			return new Item(value, index);
		}

		public int getValue() {
			return this.value;
		}

		public int getIndex() {
			return this.index;
		}
	}

}
