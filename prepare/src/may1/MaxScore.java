package may1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MaxScore {

	public static void main(String[] args) {
		int[] nums1 = { 4, 2, 3, 1, 1 };
		int[] nums2 = { 7, 5, 10, 9, 6 };
		int k = 1;

		// 4,3,2,1
		// 2,3,1,3

		System.out.println(solve(nums1, nums2, k));

	}

	private static long solve(int[] nums1, int[] nums2, int k) {
		int size = nums1.length;
		int[][] arr = new int[size][2];
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < size; i++) {
			arr[i] = new int[] { nums1[i], nums2[i] };
		}

		Arrays.sort(arr, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o2[1] - o1[1];
			}
		});

		long sum = 0;
		long answer = 0;
		int i = 0;

		for (i = 0; i < k; i++) {
			sum += arr[i][0];
			pq.add(arr[i][0]);
		}

		answer = sum * arr[i - 1][1];

		for (int j = i; j < size; j++) {
			int val = pq.poll();
			sum -= val;
			sum += arr[j][0];
			pq.add(arr[j][0]);
			answer = Math.max(answer, sum * arr[j][1]);
		}
		return answer;
	}

}
