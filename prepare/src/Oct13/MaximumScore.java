package Oct13;

import java.util.Collections;
import java.util.PriorityQueue;

public class MaximumScore {

	public static void main(String[] args) {
		int[] arr = { 4, 6, -10, -1, 10, -20 };
		int k = 4;
		System.out.println(solve(arr, k));
	}

	private static int solve(int[] arr, int k) {
		int sum = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
		for (Integer integer : arr) {
			pq.add(integer);
		}

		while (k > 0) {
			sum += pq.poll();
			k--;
		}
		return sum;
	}

}
