package feb07;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class AsFarFromLandAsPossible {
	public static int rowVal;
	public static int colVal;
	public static int[][] arr;

	public static void main(String[] args) {

		int[][] grid = { { 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1 },
				{ 1, 1, 1, 1, 1 } };

		System.out.println(solve(grid));
	}

	private static int solve(int[][] grid) {
		int count = 0;
		int[][] covered = new int[grid.length][grid[0].length];

		for (int[] is : covered) {
			Arrays.fill(is, -1);
		}

		Queue<int[]> queue = new LinkedList<>();
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					covered[i][j] = -2;
					queue.add(new int[] { i, j });
				}
			}
		}

		while (!queue.isEmpty()) {
			int level = queue.size();
			boolean flag = false;
			for (int i = 0; i < level; i++) {
				int[] each = queue.poll();
				int row = each[0];
				int col = each[1];

				covered[row][col] = -2;

				if (row - 1 >= 0 && covered[row - 1][col] != -2) {
					flag = true;
					queue.add(new int[] { row - 1, col });
				}
				if (row + 1 < grid.length && covered[row + 1][col] != -2) {
					flag = true;
					queue.add(new int[] { row + 1, col });
				}
				if (col - 1 >= 0 && covered[row][col - 1] != -2) {
					flag = true;
					queue.add(new int[] { row, col - 1 });
				}
				if (col + 1 < grid[0].length && covered[row][col + 1] != -2) {
					flag = true;
					queue.add(new int[] { row, col + 1 });
				}
			}
			if (flag)
				count++;

		}

		return count == 0 ? -1 : count - 1;
	}

}
