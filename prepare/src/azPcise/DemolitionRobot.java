package azPcise;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class DemolitionRobot {
	static int steps = 0;;

	public static void main(String[] args) {
		int[][] matrix = { { 1, 1, 0 }, { 1, 0, 0 }, { 1, 9, 0 } };
		System.out.println(solve(matrix));
	}

	private static int solve(int[][] grid) {
		if (grid == null || grid.length == 0)
			return -1;
		Set<String> visited = new HashSet<>();
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] { 0, 0 });
		visited.add("0,0");
		int distance = 0;
		int[][] moves = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int[] point = q.remove();
				if (grid[point[0]][point[1]] == 9)
					return distance;
				for (int[] move : moves) {
					int x = point[0] + move[0];
					int y = point[1] + move[1];
					if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] != 0
							&& !visited.contains(x + "," + y)) {
						q.add(new int[] { x, y });
						visited.add(x + "," + y);
					}
				}
			}
			distance++;
		}
		return -1;
	}

}
