package interviewBitProblems;

import java.util.Arrays;

public class MinimumPathSum {

	public static int[][] matrix;

	public static void main(String[] args) {
		int[][] grid = { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } };

		matrix = new int[grid.length][grid[0].length];

		for (int[] is : matrix) {
			Arrays.fill(is, -1);
		}

		System.out.println(solve(grid, 0, 0));

	}

	private static int solve(int[][] grid, int row, int column) {

		if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
			return 0;
		}

		boolean rowValidate = row < 0 || row >= grid.length;
		boolean columnValidate = column < 0 || column >= grid[0].length;

		if (rowValidate || columnValidate) {
			return Integer.MAX_VALUE;
		}

		if (matrix[row][column] != -1) {
			return matrix[row][column];
		}

		if (row == grid.length - 1 && column == grid[0].length - 1) {
			return matrix[row][column] = grid[row][column];
		}

		return matrix[row][column] = grid[row][column]
				+ Math.min(solve(grid, row + 1, column), solve(grid, row, column + 1));

	}

}
