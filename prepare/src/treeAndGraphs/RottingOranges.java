package treeAndGraphs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class RottingOranges {
	static Queue<int[]> queue;

	public static void main(String[] args) {
		int[][] grid = { { 2, 1, 1 }, { 1, 1, 1 }, { 0, 1, 2 } };
		int row = -1;
		int column = -1;
		boolean fresh = false;
		queue = new LinkedList<>();

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 2) {
					row = i;
					column = j;
					queue.add(new int[] { i, j });
				} else if (grid[i][j] == 1) {
					fresh = true;
				}
			}
		}
		if (row == -1 || column == -1) {
			if (fresh == false) {
				System.out.println(0);
			} else {
				System.out.println(-1);
			}

		}
		System.out.println(solve(grid));

	}

	private static int solve(int[][] grid) {

		Set<String> visited = new HashSet<>();
		// queue.add(new int[] { row, column });

		int counter = 0;

		while (!queue.isEmpty()) {
			int level = queue.size();
			counter++;

			for (int i = 0; i < level; i++) {
				int[] temp = queue.poll();
				int x = temp[0];
				int y = temp[1];

				visited.add(x + "-" + y);

				String up = (x - 1) + "-" + y;
				String down = (x + 1) + "-" + y;
				String right = x + "-" + (y + 1);
				String left = x + "-" + (y - 1);

				if (x - 1 >= 0 && grid[x - 1][y] == 1 && !visited.contains(up)) {
					int[] inner = new int[] { x - 1, y };
					queue.add(inner);
					visited.add(up);
				}
				if (x + 1 < grid.length && grid[x + 1][y] == 1 && !visited.contains(down)) {
					int[] inner = new int[] { x + 1, y };
					queue.add(inner);
					visited.add(down);
				}
				if (y + 1 < grid[0].length && grid[x][y + 1] == 1 && !visited.contains(right)) {
					int[] inner = new int[] { x, y + 1 };
					queue.add(inner);
					visited.add(right);
				}
				if (y - 1 >= 0 && grid[x][y - 1] == 1 && !visited.contains(left)) {
					int[] inner = new int[] { x, y - 1 };
					queue.add(inner);
					visited.add(left);
				}
			}

		}

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				String value = i + "-" + j;
				if (grid[i][j] == 1 && !visited.contains(value)) {
					return -1;
				}
			}
		}

		return counter - 1;

	}

}
