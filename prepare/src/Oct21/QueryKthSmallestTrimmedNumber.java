package Oct21;

import java.util.Comparator;
import java.util.PriorityQueue;

public class QueryKthSmallestTrimmedNumber {

	public static class Pair {
		String trim;
		int index;

		public Pair(String trim, int index) {
			super();
			this.trim = trim;
			this.index = index;
		}

		public String getTrim() {
			return trim;
		}

		public void setTrim(String trim) {
			this.trim = trim;
		}

		public int getIndex() {
			return index;
		}

		public void setIndex(int index) {
			this.index = index;
		}

	}

	public static void main(String[] args) {
		String[] nums = { "64333639502", "65953866768", "17845691654", "87148775908", "58954177897", "70439926174",
				"48059986638", "47548857440", "18418180516", "06364956881", "01866627626", "36824890579", "14672385151",
				"71207752868" };
		int[][] queries = { { 9, 4 }, { 6, 1 }, { 3, 8 }, { 12, 9 }, { 11, 4 }, { 4, 9 }, { 2, 7 }, { 10, 3 },
				{ 13, 1 }, { 13, 1 }, { 6, 1 }, { 5, 10 } };
		System.out.println(smallestTrimmedNumbers(nums, queries));

	}

	public static int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
		int[] answer = new int[queries.length];
		for (int j = 0; j < queries.length; j++) {
			int[] each = queries[j];
			PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
				@Override
				public int compare(Pair o1, Pair o2) {
					return o2.getTrim().equals(o1.getTrim()) ? o2.getIndex() - o1.getIndex()
							: o2.getTrim().compareTo(o1.getTrim());
				}
			});
			for (int i = 0; i < nums.length; i++) {
				String curr = nums[i];
				String trim = curr.substring(curr.length() - each[1], curr.length());
				pq.add(new Pair(trim, i));
				if (pq.size() > each[0]) {
					pq.poll();
				}
			}
			answer[j] = pq.peek().getIndex();
		}
		return answer;
	}

}
