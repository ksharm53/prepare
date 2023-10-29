package may1;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestBridge {

	static Queue<int[]> globalQueue;

	public static void main(String[] args) {
		int[][] grid = { { 0, 1, 0 }, { 0, 0, 0 }, { 0, 0, 1 } };

		globalQueue = new LinkedList<>();

		System.out.println(solve(grid));

	}

	private static int solve(int[][] grid) {
		outer: for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					doBfs(i, j, grid);
					break outer;
				}
			}
		}

		return findClosestLevel(grid);

	}

	private static int findClosestLevel(int[][] grid) {
		int level = 0;
		while (!globalQueue.isEmpty()) {
			int size = globalQueue.size();

			for (int i = 0; i < size; i++) {
				int[] each = globalQueue.poll();
				int eachRow = each[0];
				int eachCol = each[1];
				if (eachRow - 1 >= 0 && grid[eachRow - 1][eachCol] != 2) {
					if (grid[eachRow - 1][eachCol] == 1) {
						return level;
					}
					globalQueue.add(new int[] { eachRow - 1, eachCol });
					grid[eachRow - 1][eachCol] = 2;
				}

				if (eachCol - 1 >= 0 && grid[eachRow][eachCol - 1] != 2) {
					if (grid[eachRow][eachCol - 1] == 1) {
						return level;
					}
					globalQueue.add(new int[] { eachRow, eachCol - 1 });
					grid[eachRow][eachCol - 1] = 2;
				}

				if (eachRow + 1 < grid.length && grid[eachRow + 1][eachCol] != 2) {
					if (grid[eachRow + 1][eachCol] == 1) {
						return level;
					}
					globalQueue.add(new int[] { eachRow + 1, eachCol });
					grid[eachRow + 1][eachCol] = 2;
				}

				if (eachCol + 1 < grid[0].length && grid[eachRow][eachCol + 1] != 2) {
					if (grid[eachRow][eachCol + 1] == 1) {
						return level;
					}
					globalQueue.add(new int[] { eachRow, eachCol + 1 });
					grid[eachRow][eachCol + 1] = 2;
				}

			}
			level++;
		}
		return -1;
	}

	private static void doBfs(int row, int col, int[][] grid) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { row, col });
		globalQueue.add(new int[] { row, col });
		grid[row][col] = 2;

		while (!queue.isEmpty()) {
			int[] each = queue.poll();
			int eachRow = each[0];
			int eachCol = each[1];
			if (eachRow - 1 >= 0 && grid[eachRow - 1][eachCol] == 1) {
				queue.add(new int[] { eachRow - 1, eachCol });
				globalQueue.add(new int[] { eachRow - 1, eachCol });
				grid[eachRow - 1][eachCol] = 2;
			}
			if (eachCol - 1 >= 0 && grid[eachRow][eachCol - 1] == 1) {
				queue.add(new int[] { eachRow, eachCol - 1 });
				globalQueue.add(new int[] { eachRow, eachCol - 1 });
				grid[eachRow][eachCol - 1] = 2;
			}

			if (eachRow + 1 < grid.length && grid[eachRow + 1][eachCol] == 1) {
				queue.add(new int[] { eachRow + 1, eachCol });
				globalQueue.add(new int[] { eachRow + 1, eachCol });
				grid[eachRow + 1][eachCol] = 2;
			}
			if (eachCol + 1 < grid[0].length && grid[eachRow][eachCol + 1] == 1) {
				queue.add(new int[] { eachRow, eachCol + 1 });
				globalQueue.add(new int[] { eachRow, eachCol + 1 });
				grid[eachRow][eachCol + 1] = 2;
			}
		}
	}

}
