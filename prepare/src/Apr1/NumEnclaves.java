package Apr1;

import java.util.LinkedList;
import java.util.Queue;

public class NumEnclaves {

	public static int[][] matrix;

	public static void main(String[] args) {
		int[][] grid = { { 0, 0, 0, 1, 1, 1, 0, 1, 0, 0 }, { 1, 1, 0, 0, 0, 1, 0, 1, 1, 1 },
				{ 0, 0, 0, 1, 1, 1, 0, 1, 0, 0 }, { 0, 1, 1, 0, 0, 0, 1, 0, 1, 0 }, { 0, 1, 1, 1, 1, 1, 0, 0, 1, 0 },
				{ 0, 0, 1, 0, 1, 1, 1, 1, 0, 1 }, { 0, 1, 1, 0, 0, 0, 1, 1, 1, 1 }, { 0, 0, 1, 0, 0, 1, 0, 1, 0, 1 },
				{ 1, 0, 1, 0, 1, 1, 0, 0, 0, 0 }, { 0, 0, 0, 0, 1, 1, 0, 0, 0, 1 } };

		matrix = new int[grid.length][grid[0].length];

		System.out.println(solve(grid));
	}

	private static int solve(int[][] grid) {
		int sum = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid.length; j++) {
				if (grid[i][j] == 1 && matrix[i][j] != -1) {
					System.out.println("Row: " + i + " Col: " + j);
					sum += bfs(grid, i, j);
				}
			}
		}
		return sum;
	}

	private static int bfs(int[][] grid, int row, int col) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { row, col });
		matrix[row][col] = -1;

		boolean flag = false;

		int count = 1;

		while (!queue.isEmpty()) {
			int[] temp = queue.poll();
			int tempRow = temp[0];
			int tempCol = temp[1];
			if (tempRow - 1 < 0 || tempRow + 1 >= grid.length || tempCol - 1 < 0 || tempCol + 1 >= grid[0].length) {
				flag = true;
			}

			if (tempRow - 1 >= 0 && grid[tempRow - 1][tempCol] == 1 && matrix[tempRow - 1][tempCol] != -1) {
				count++;
				queue.add(new int[] { tempRow - 1, tempCol });
				matrix[tempRow - 1][tempCol] = -1;
			}

			if (tempRow + 1 < grid.length && grid[tempRow + 1][tempCol] == 1 && matrix[tempRow + 1][tempCol] != -1) {
				count++;
				queue.add(new int[] { tempRow + 1, tempCol });
				matrix[tempRow + 1][tempCol] = -1;
			}

			if (tempCol - 1 >= 0 && grid[tempRow][tempCol - 1] == 1 && matrix[tempRow][tempCol - 1] != -1) {
				count++;
				queue.add(new int[] { tempRow, tempCol - 1 });
				matrix[tempRow][tempCol - 1] = -1;
			}

			if (tempCol + 1 < grid[0].length && grid[tempRow][tempCol + 1] == 1 && matrix[tempRow][tempCol + 1] != -1) {
				count++;
				queue.add(new int[] { tempRow, tempCol + 1 });
				matrix[tempRow][tempCol + 1] = -1;
			}

		}
		return flag ? 0 : count;
	}

}
