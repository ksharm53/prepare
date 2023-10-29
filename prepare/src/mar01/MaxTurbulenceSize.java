package mar01;

import java.util.LinkedList;
import java.util.Queue;

public class MaxTurbulenceSize {

	public static void main(String[] args) {
		int[][] grid = { { 0, 11, 16, 5, 20 }, { 17, 4, 19, 10, 15 }, { 12, 1, 8, 21, 6 }, { 3, 18, 23, 14, 9 },
				{ 24, 13, 2, 7, 22 } };
		System.out.println(solve(grid));

	}

	private static boolean solve(int[][] grid) {

		int row = 0;
		int col = 0;

		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { row, col });
		int counter = 0;

		if (grid[row][col] != counter) {
			return false;
		}

		counter++;

		while (!queue.isEmpty()) {

			for (int i = 0; i < queue.size(); i++) {
				queue.poll();
				if (row - 2 >= 0 && col + 1 < grid[0].length && grid[row - 2][col + 1] == counter) {
					row -= 2;
					col += 1;
					queue.add(new int[] { row - 2, col + 1 });
					counter++;
				}

				else if (row - 1 >= 0 && col + 2 < grid[0].length && grid[row - 1][col + 2] == counter) {
					row -= 1;
					col += 2;

					queue.add(new int[] { row - 1, col + 2 });
					counter++;
				}

				else if (row + 1 < grid.length && col + 2 < grid[0].length && grid[row + 1][col + 2] == counter) {
					row += 1;
					col += 2;

					queue.add(new int[] { row + 1, col + 2 });
					counter++;
				}

				else if (row + 2 < grid.length && col + 1 < grid[0].length && grid[row + 2][col + 1] == counter) {
					row += 2;
					col += 1;
					queue.add(new int[] { row + 2, col + 1 });
					counter++;
				}

				else if (row + 2 < grid.length && col - 1 >= 0 && grid[row + 2][col - 1] == counter) {
					row += 2;
					col -= 1;
					queue.add(new int[] { row + 2, col - 1 });
					counter++;
				}

				else if (row + 1 < grid.length && col - 2 >= 0 && grid[row + 1][col - 2] == counter) {
					row += 1;
					col -= 2;
					queue.add(new int[] { row + 1, col - 2 });
					counter++;
				}

				else if (row - 1 >= 0 && col - 2 >= 0 && grid[row - 1][col - 2] == counter) {
					row -= 1;
					col -= 2;
					queue.add(new int[] { row - 1, col - 2 });
					counter++;
				}

				else if (row - 2 >= 0 && col - 1 >= 0 && grid[row - 2][col - 1] == counter) {
					row -= 2;
					col -= 1;
					queue.add(new int[] { row - 2, col - 1 });
					counter++;
				}
			}
		}

		System.out.println(counter);
		return grid.length * grid[0].length == counter ? true : false;

	}

}
