package august23;

import java.util.Collections;
import java.util.PriorityQueue;

public class ThekthFactorofN {

	public static void main(String[] args) {
		int n = 7;
		int k = 2;

		System.out.println(kthFactor(n, k));

	}

	public static int kthFactor(int n, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());

		for (int i = 1; i <= n; i++) {
			if (n % i == 0) {
				pq.add(i);
				if (pq.size() > k) {
					pq.poll();
				}
			}
		}

		if (pq.size() < k) {
			return -1;
		} else
			return pq.poll();
	}

}
