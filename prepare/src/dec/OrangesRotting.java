package dec;

import java.util.LinkedList;
import java.util.Queue;

public class OrangesRotting {

	public static void main(String[] args) {
		int[][] grid = { { 1 } };
		System.out.println(solve(grid));
	}

	private static int solve(int[][] grid) {
		Queue<int[]> queue = new LinkedList<>();
		int[][] visited = new int[grid.length][grid[0].length];
		int countFresh = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == 2) {
					queue.add(new int[] { i, j });
					visited[i][j] = -1;
				}
				if (grid[i][j] == 1) {
					countFresh++;
				}
			}
		}

		int time = 0;

		while (!queue.isEmpty()) {
			time++;
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				int[] coors = queue.poll();
				if (coors[0] - 1 >= 0 && grid[coors[0] - 1][coors[1]] == 1 && visited[coors[0] - 1][coors[1]] != -1) {
					queue.add(new int[] { coors[0] - 1, coors[1] });
					visited[coors[0] - 1][coors[1]] = -1;
					countFresh--;
				}
				if (coors[0] + 1 < grid.length && grid[coors[0] + 1][coors[1]] == 1
						&& visited[coors[0] + 1][coors[1]] != -1) {
					queue.add(new int[] { coors[0] + 1, coors[1] });
					visited[coors[0] + 1][coors[1]] = -1;
					countFresh--;
				}
				if (coors[1] - 1 >= 0 && grid[coors[0]][coors[1] - 1] == 1 && visited[coors[0]][coors[1] - 1] != -1) {
					queue.add(new int[] { coors[0], coors[1] - 1 });
					visited[coors[0]][coors[1] - 1] = -1;
					countFresh--;
				}
				if (coors[1] + 1 < grid[0].length && grid[coors[0]][coors[1] + 1] == 1
						&& visited[coors[0]][coors[1] + 1] != -1) {
					queue.add(new int[] { coors[0], coors[1] + 1 });
					visited[coors[0]][coors[1] + 1] = -1;
					countFresh--;
				}
			}
		}

		if (countFresh == 0 && time - 1 < 0) {
			return 0;
		}

		return countFresh == 0 ? time - 1 : -1;
	}

}
