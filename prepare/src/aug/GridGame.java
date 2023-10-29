package aug;

import java.util.Arrays;

public class GridGame {

	static int[][] matrix;

	public static void main(String[] args) {
		int[][] grid = { { 20, 3, 20, 17, 2, 12, 15, 17, 4, 15 }, { 20, 10, 13, 14, 15, 5, 2, 3, 14, 3 } };
					//[[0, 0, 0, 0, 0, 0, 0, 0, 0, 0], [20, 10, 13, 14, 15, 5, 2, 3, 14, 0]]
		           // [[128, 108, 105, 85, 68, 66, 54, 39, 22, 18], [99, 79, 69, 56, 42, 27, 22, 20, 17, 3]]
		matrix = new int[2][grid[0].length];

		for (int[] each : matrix) {
			Arrays.fill(each, -1);
		}

		System.out.println(getMatrix(grid, 0, 0));

		reDrawMatrix(grid, 0, 0);
		for (int[] each : matrix) {
			Arrays.fill(each, -1);
		}

		System.out.println(getMatrix(grid, 0, 0));

	}

	private static void reDrawMatrix(int[][] grid, int row, int col) {
		while (row < 2 && col < grid[0].length) {
			int val = matrix[row][col];
			int temp = grid[row][col];
			grid[row][col] = 0;
			if (row + 1 < 2 && matrix[row + 1][col] == val - temp) {
				row++;
			} else {
				col++;
			}

		}

	}

	private static int getMatrix(int[][] grid, int row, int col) {
		if (row >= grid.length || col >= grid[0].length) {
			return 0;
		}

		if (matrix[row][col] != -1) {
			return matrix[row][col];
		}

		int liyaNeeche = grid[row][col] + getMatrix(grid, row + 1, col);
		int naiLiyaNeeche = getMatrix(grid, row + 1, col);
		int liyaRight = grid[row][col] + getMatrix(grid, row, col + 1);
		int naiLiyaRight = getMatrix(grid, row, col + 1);

		return matrix[row][col] = Math.max(liyaRight, Math.max(liyaNeeche, Math.max(naiLiyaRight, naiLiyaNeeche)));
	}

}
