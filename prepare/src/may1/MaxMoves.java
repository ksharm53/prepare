package may1;

import java.util.LinkedList;
import java.util.Queue;

public class MaxMoves {

	static int max;
	static int[][] matrix;

	public static void main(String[] args) {
		int[][] grid = { { 2, 4, 3, 5 }, { 5, 4, 9, 3 }, { 3, 4, 2, 11 }, { 10, 9, 13, 15 } };
		max = Integer.MIN_VALUE;

		matrix = new int[grid.length][grid[0].length];

		for (int i = 0; i < grid.length; i++) {
			matrix = new int[grid.length][grid[0].length];
			solve(grid, i, 0);
		}

		System.out.println(max);

	}

	private static void solve(int[][] grid, int row, int col) {
		Queue<int[]> queue = new LinkedList<>();
		int maxInner = Integer.MIN_VALUE;
		queue.add(new int[] { row, col, 0 });
		matrix[row][col] = -1;

		while (!queue.isEmpty()) {
			int[] each = queue.poll();
			int rowIn = each[0];
			int colIn = each[1];
			int steps = each[2];

			maxInner = Math.max(maxInner, steps);

			if (rowIn - 1 >= 0 && colIn + 1 < grid[0].length && matrix[rowIn - 1][colIn + 1] != -1
					&& grid[rowIn - 1][colIn + 1] > grid[rowIn][colIn]) {
				queue.add(new int[] { rowIn - 1, colIn + 1, steps + 1 });
				matrix[rowIn - 1][colIn + 1] = -1;
			}

			if (colIn + 1 < grid[0].length && matrix[rowIn][colIn + 1] != -1
					&& grid[rowIn][colIn + 1] > grid[rowIn][colIn]) {
				queue.add(new int[] { rowIn, colIn + 1, steps + 1 });
				matrix[rowIn][colIn + 1] = -1;
			}

			if (rowIn + 1 < grid.length && colIn + 1 < grid[0].length && matrix[rowIn + 1][colIn + 1] != -1
					&& grid[rowIn + 1][colIn + 1] > grid[rowIn][colIn]) {
				queue.add(new int[] { rowIn + 1, colIn + 1, steps + 1 });
				matrix[rowIn + 1][colIn + 1] = -1;
			}

		}

		max = Math.max(max, maxInner);

	}

}
