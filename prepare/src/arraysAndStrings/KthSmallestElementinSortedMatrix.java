package arraysAndStrings;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallestElementinSortedMatrix {

	public static void main(String[] args) {
		int[][] matrix = { { -5 } };
		int k = 1;

		System.out.println(solve(matrix, k));

	}

	private static int solve(int[][] matrix, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				pq.add(matrix[i][j]);
				if (pq.size() > k) {
					pq.poll();
				}
			}
		}
		return pq.poll();
	}

}
