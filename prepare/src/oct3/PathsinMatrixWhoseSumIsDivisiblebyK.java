package oct3;

import java.util.Arrays;

public class PathsinMatrixWhoseSumIsDivisiblebyK {

	public static int[][][] matrix;

	public static void main(String[] args) {
		int[][] grid = { { 5, 2, 4 }, { 3, 0, 5 }, { 0, 7, 2 } };
		int k = 3;

		matrix = new int[grid.length][grid[0].length][k + 1];
		for (int[][] is : matrix) {
			for (int[] is2 : is) {
				Arrays.fill(is2, -1);
			}
		}

		System.out.println(solve(grid, k, 0, 0, 0));

	}

	public static int solve(int[][] grid, int k, int row, int col, int sum) {
		if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) {
			return 0;
		}
		sum += grid[row][col];

		if (row == grid.length - 1 && col == grid[0].length - 1) {
			if (sum % k == 0) {
				return 1;
			} else {
				return 0;
			}
		}

		if (matrix[row][col][sum % k] != -1) {
			return matrix[row][col][sum % k];
		}

		return matrix[row][col][sum % k] = (solve(grid, k, row + 1, col, sum) + solve(grid, k, row, col + 1, sum)) % 1000000007;

	}

}
