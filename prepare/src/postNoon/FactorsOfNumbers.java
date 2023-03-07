package postNoon;

import java.util.Comparator;
import java.util.PriorityQueue;

public class FactorsOfNumbers {

	public static void main(String[] args) {
		int n = 20;
		int p = 3;
		System.out.println(solve(n, p));

	}

	private static int solve(int n, int p) {
		PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

		for (int i = 1; i <= n; i++) {
			if (n % i == 0) {
				pq.add(i);
				if (pq.size() > p) {
					pq.poll();
				}
			}
		}
		return pq.peek();
	}

}
