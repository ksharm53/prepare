package july;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class MaximumSafenessFactor {

	static int[][] manhanttenDistance;
	static int max;

	public static void main(String[] args) {
		List<List<Integer>> grid = new ArrayList<>();
		grid.add(List.of(0, 0, 0, 1));
		grid.add(List.of(0, 0, 0, 0));
		grid.add(List.of(0, 0, 0, 0));
		grid.add(List.of(1, 0, 0, 0));

		int[][] gridMat = { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1 },
				{ 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1 },
				{ 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
				{ 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0 } };

		/*
		 * for (int i = 0; i < grid.size(); i++) { for (int j = 0; j <
		 * grid.get(0).size(); j++) { gridMat[i][j] = grid.get(i).get(j); } }
		 */

		manhanttenDistance = new int[gridMat.length][gridMat[0].length];
		max = Integer.MIN_VALUE;

		for (int[] is : manhanttenDistance) {
			Arrays.fill(is, Integer.MAX_VALUE);
		}

		solve(gridMat);
		System.out.println(max);
	}

	private static void solve(int[][] grid) {

		findmanhattenDistance(grid);
		System.out.println(printAllPaths(grid));

	}

	static class info {
		int dist;
		int i;
		int j;

		public info(int dist, int i, int j) {
			this.dist = dist;
			this.i = i;
			this.j = j;
		}
	}

	public static int printAllPaths(int[][] maze) {
		PriorityQueue<info> pq = new PriorityQueue<>(new Comparator<info>() {

			@Override
			public int compare(info o1, info o2) {
				return o2.dist - o1.dist;
			}
		});
		List<Integer> dir = List.of(1, 0, -1, 0, 1);
		int[][] matrix = new int[maze.length][maze[0].length];
		pq.add(new info(manhanttenDistance[0][0], 0, 0));
		matrix[0][0] = -1;

		while (!pq.isEmpty()) {
			info curr = pq.poll();

			if (curr.i == maze.length - 1 && curr.j == maze[0].length) {
				return curr.dist;
			}

			for (int i = 0; i < 4; i++) {
				int newRow = curr.i + dir.get(i);
				int newCol = curr.j + dir.get(i);
				if (newCol < 0 || newRow < 0 || newRow >= maze.length || newCol >= maze.length
						|| matrix[newRow][newCol] == -1) {
					continue;
				}

				pq.add(new info(manhanttenDistance[newRow][newCol], newRow, newCol));
				matrix[newRow][newCol] = -1;

			}
		}
		return 0;
	}

	private static void findmanhattenDistance(int[][] grid) {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == 1) {
					goRecurse(i, j, grid);
				}
			}
		}

	}

	private static void goRecurse(int row, int col, int[][] grid) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { row, col, 0 });
		int[][] set = new int[manhanttenDistance.length][manhanttenDistance[0].length];
		set[row][col] = -1;

		while (!queue.isEmpty()) {
			int[] each = queue.poll();
			manhanttenDistance[each[0]][each[1]] = Math.min(manhanttenDistance[each[0]][each[1]], each[2]);

			if (each[0] - 1 >= 0 && set[each[0] - 1][each[1]] != -1 && grid[each[0] - 1][each[1]] != 1) {
				queue.add(new int[] { each[0] - 1, each[1], each[2] + 1 });
				set[each[0] - 1][each[1]] = -1;
			}

			if (each[1] - 1 >= 0 && set[each[0]][each[1] - 1] != -1 && grid[each[0]][each[1] - 1] != 1) {
				queue.add(new int[] { each[0], each[1] - 1, each[2] + 1 });
				set[each[0]][each[1] - 1] = -1;
			}

			if (each[0] + 1 < grid.length && set[each[0] + 1][each[1]] != -1 && grid[each[0] + 1][each[1]] != 1) {
				queue.add(new int[] { each[0] + 1, each[1], each[2] + 1 });
				set[each[0] + 1][each[1]] = -1;
			}

			if (each[1] + 1 < grid[0].length && set[each[0]][each[1] + 1] != -1 && grid[each[0]][each[1] + 1] != 1) {
				queue.add(new int[] { each[0], each[1] + 1, each[2] + 1 });
				set[each[0]][each[1] + 1] = -1;
			}
		}
	}

}
