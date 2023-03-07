package Oct21;

import java.util.HashSet;
import java.util.Set;

public class ShortestPathinaGridwithObstaclesElimination {

	public static void main(String[] args) {
		int[][] grid = { { 0, 0, 0 }, { 1, 1, 0 }, { 0, 0, 0 }, { 0, 1, 1 }, { 0, 0, 0 } };
		int k = 1;

		System.out.println(solve(grid, k, 0, 0, new HashSet<String>()));

	}

	private static int solve(int[][] grid, int k, int row, int col, Set<String> visited) {
		if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) {
			return 0;
		}

		String entry = row + "-" + col;
		if (visited.contains(entry)) {
			return 0;
		}
		visited.add(entry);
		if (row == grid.length - 1 && col == grid[0].length || (grid[row][col] == 1 && k < 0)) {
			return 0;
		}

		else {
			return Math
					.min(Math.min(Math.min(1 + solve(grid, k - 1, row + 1, col, visited), 1 + solve(grid, k - 1, row - 1, col, visited)),
							1 + solve(grid, k - 1, row, col + 1, visited)), 1 + solve(grid, k - 1, row, col - 1, visited));
		}

	}

}
