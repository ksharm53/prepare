package july;

import java.util.LinkedList;
import java.util.Queue;

public class KnightProbability {

	static int[][] arr;

	public static void main(String[] args) {
		int n = 1, k = 0, row = 0, column = 0;
		arr = new int[n][n];

		System.out.println(solve(n, k, row, column));

	}

	private static double solve(int n, int k, int row, int column) {

		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { row, column });
		arr[row][column] = 2; // 2 means taken
		double prob = 1.0000;
		int level = 0;
		int counter = 0;

		while (!queue.isEmpty() && level < k) {
			level++;
			counter = 0;

			for (int i = 0; i < queue.size(); i++) {
				int[] curr = queue.poll();

				if (curr[0] - 2 >= 0 && curr[1] - 1 >= 0) {
					counter++;
					if (arr[curr[0] - 2][curr[1] - 1] != 2) {
						queue.add(new int[] { curr[0] - 2, curr[1] - 1 });
						arr[curr[0] - 2][curr[1] - 1] = 2;
					}
				}

				if (curr[0] - 2 >= 0 && curr[1] + 1 < n) {
					counter++;
					if (arr[curr[0] - 2][curr[1] + 1] != 2) {
						queue.add(new int[] { curr[0] - 2, curr[1] + 1 });
						arr[curr[0] - 2][curr[1] + 1] = 2;
					}
				}

				if (curr[0] - 1 >= 0 && curr[1] + 2 < n) {
					counter++;
					if (arr[curr[0] - 1][curr[1] + 2] != 2) {
						queue.add(new int[] { curr[0] - 1, curr[1] + 2 });
						arr[curr[0] - 1][curr[1] + 2] = 2;
					}
				}

				if (curr[0] + 1 < n && curr[1] + 2 < n) {
					counter++;
					if (arr[curr[0] + 1][curr[1] + 2] != 2) {
						queue.add(new int[] { curr[0] + 1, curr[1] + 2 });
						arr[curr[0] + 1][curr[1] + 2] = 2;
					}
				}

				if (curr[0] + 2 < n && curr[1] + 1 < n) {
					counter++;
					if (arr[curr[0] + 2][curr[1] + 1] != 2) {
						queue.add(new int[] { curr[0] + 2, curr[1] + 1 });
						arr[curr[0] + 2][curr[1] + 1] = 2;
					}
				}

				if (curr[0] + 2 < n && curr[1] - 1 >= 0) {
					counter++;
					if (arr[curr[0] + 2][curr[1] - 1] != 2) {
						queue.add(new int[] { curr[0] + 2, curr[1] - 1 });
						arr[curr[0] + 2][curr[1] - 1] = 2;
					}
				}

				if (curr[0] + 1 < n && curr[1] - 2 >= 0) {
					counter++;
					if (arr[curr[0] + 1][curr[1] - 2] != 2) {
						queue.add(new int[] { curr[0] + 1, curr[1] - 2 });
						arr[curr[0] + 1][curr[1] - 2] = 2;
					}
				}

				if (curr[0] - 1 >= 0 && curr[1] - 2 >= 0) {
					counter++;
					if (arr[curr[0] - 1][curr[1] - 2] != 2) {
						queue.add(new int[] { curr[0] - 1, curr[1] - 2 });
						arr[curr[0] - 1][curr[1] - 2] = 2;
					}
				}

			}

		}
		prob *= ((double) counter / Math.pow(8, k));
		return prob;
	}

}
