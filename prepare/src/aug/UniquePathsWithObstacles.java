package aug;

import java.util.Arrays;

public class UniquePathsWithObstacles {

	static int[][] matrix;

	public static void main(String[] args) {
		int[][] obstacleGrid = { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 },
				{ 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 1, 0 },
				{ 0, 0, 0 }, { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 }, { 0, 0, 0 },
				{ 0, 1, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 },
				{ 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 1, 0 },
				{ 0, 0, 0 }, { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 }, { 0, 0, 0 },
				{ 0, 1, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 },
				{ 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };
		matrix = new int[obstacleGrid.length + 1][obstacleGrid[0].length + 1];

		for (int[] each : matrix) {
			Arrays.fill(each, -1);
		}

		System.out.println(solve(obstacleGrid, 0, 0));

	}

	private static int solve(int[][] obstacleGrid, int row, int col) {
		if (row == obstacleGrid.length || col == obstacleGrid[0].length || row < 0 || col < 0
				|| obstacleGrid[row][col] == 1) {
			return 0;
		}

		if (row == obstacleGrid.length - 1 && col == obstacleGrid[0].length - 1) {
			return 1;
		}

		if (matrix[row][col] != -1) {
			return matrix[row][col];
		}

		int first = solve(obstacleGrid, row + 1, col);
		int sec = solve(obstacleGrid, row, col + 1);

		return matrix[row][col] = first + sec;
	}

}
