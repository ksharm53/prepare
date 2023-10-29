package aug;

import java.util.PriorityQueue;

public class FindKthLargest {

	public static void main(String[] args) {
		int[] nums = { 3, 2, 3, 1, 2, 4, 5, 5, 6 };
		int k = 4;

		System.out.println(solve(nums, k));

	}

	private static int solve(int[] nums, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for (int each : nums) {
			pq.add(each);
			if (pq.size() > k) {
				pq.poll();
			}
		}

		return pq.peek();
	}

}
