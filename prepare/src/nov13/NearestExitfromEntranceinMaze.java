package nov13;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class NearestExitfromEntranceinMaze {

	public static int dist;

	public static void main(String[] args) {
		// char[][] maze = { { '+', '+', '.', '+' }, { '.', '.', '.', '+' }, { '+', '+',
		// '+', '.' } };
		// char[][] maze = { { '+', '+', '+' }, { '.', '.', '.' }, { '+', '+', '+' } };
		char[][] maze = { { '.', '+' } };

		/*
		 * char[][] maze = { { '+', '.', '+', '+', '+', '+', '+' }, { '+', '.', '+',
		 * '.', '.', '.', '+' }, { '+', '.', '+', '.', '+', '.', '+' }, { '+', '.', '.',
		 * '.', '.', '.', '+' }, { '+', '+', '+', '+', '.', '+', '.' } };
		 */
		int[] entrance = { 0, 0 };
		dist = Integer.MAX_VALUE;

		solve(maze, entrance[0], entrance[1]);

		System.out.println(dist == Integer.MAX_VALUE ? -1 : dist);
	}

	private static void solve(char[][] maze, int row, int col) {
		Set<String> visited = new HashSet<>();
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { row, col });
		visited.add(row + "-" + col);
		int moves = 0;
		while (!queue.isEmpty()) {
			int level = queue.size();
			for (int i = 0; i < level; i++) {
				int[] curr = queue.poll();
				int x = curr[0];
				int y = curr[1];
				if (!(x == row && y == col)
						&& (x - 1 < 0 || y - 1 < 0 || x + 1 >= maze.length || y + 1 >= maze[0].length)) {
					dist = Math.min(dist, moves);
					// continue;
				}
				if (x - 1 >= 0 && !visited.contains((x - 1) + "-" + y) && maze[x - 1][y] == '.') {
					queue.add(new int[] { x - 1, y });
					visited.add((x - 1) + "-" + y);
				}

				if (y - 1 >= 0 && !visited.contains(x + "-" + (y - 1)) && maze[x][y - 1] == '.') {
					queue.add(new int[] { x, y - 1 });
					visited.add(x + "-" + (y - 1));
				}

				if (x + 1 < maze.length && !visited.contains((x + 1) + "-" + y) && maze[x + 1][y] == '.') {
					queue.add(new int[] { x + 1, y });
					visited.add((x + 1) + "-" + y);
				}

				if (y + 1 < maze[0].length && !visited.contains(x + "-" + (y + 1)) && maze[x][y + 1] == '.') {
					queue.add(new int[] { x, y + 1 });
					visited.add(x + "-" + (y + 1));
				}

			}
			moves++;
		}
	}

}
