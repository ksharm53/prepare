package arraysAndStrings;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Cookies {

	public static void main(String[] args) {
		int k = 10;
		List<Integer> A = Arrays.asList(1, 1, 1);

		System.out.println(solve(A, k));

	}

	private static int solve(List<Integer> a, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int counter = 0;

		if (a.size() == 0) {
			return -1;
		}
		for (Integer integer : a) {
			pq.add(integer);
		}

		while (pq.peek() < k) {
			counter++;
			int first = pq.poll();
			int second = 0;
			if (pq.size() != 0) {
				second = pq.poll();
			} else {
				return -1;
			}

			pq.add(first + 2 * second);
		}
		return counter;
	}

}
