package arrays;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;

public class KthSmallestPairDistance {

	public static void main(String[] args) {
		int[] nums = { 1, 3, 1 };
		int k = 1;

		System.out.println(solve(nums, k));

	}

	private static int solve(int[] nums, int k) {
		if (nums.length <= 1) {
			return 0;
		}

		PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

		// Arrays.sort(nums);

		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				pq.add(Math.abs(nums[i] - nums[j]));
				if (pq.size() > k) {
					pq.poll();
				}
			}
		}

		return pq.poll();
	}

}
