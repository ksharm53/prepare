package oct2023;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MinIncrementOperations {

	public static void main(String[] args) {
		int[] nums = { 1, 1, 2 };
		int k = 1;

		System.out.println(solve(nums, k));

	}

	private static int solve(int[] nums, int k) {
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if (o2[0] == o1[0]) {

					if (o1[1] < o2[1]) {
						int left = o1[1];
						int right = o2[1];

						return ((left - 1) - (nums.length - right - 1));

					} else {
						int left = o2[1];
						int right = o1[1];

						return ((left - 1) - (nums.length - right - 1));
					}

				} else {
					return o2[0] - o1[0];
				}
			}
		});

		int val = 0;
		int[] indx = new int[nums.length];
		Arrays.fill(indx, -1);

		for (int i = 0; i < nums.length; i++) {
			pq.add(new int[] { nums[i], i });
		}

		while (!pq.isEmpty()) {
			int[] each = pq.poll();
			if (indx[each[1]] == -1) {
				if (k >= each[0]) {
					val += k - each[0];
				}

				if (each[1] - 1 >= 0) {
					indx[each[1] - 1] = 0;
				}
				if (each[1] - 2 >= 0) {
					indx[each[1] - 2] = 0;
				}

				indx[each[1]] = 0;

				if (each[1] + 1 < indx.length) {
					indx[each[1] + 1] = 0;
				}
				if (each[1] + 2 < indx.length) {
					indx[each[1] + 2] = 0;
				}
			}
		}
		return val;
	}

}
