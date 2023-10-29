package june;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ShortestPathAllKeys {

	static int min;
	static List<Character> keys;

	static class Pair {
		int countKey;
		int row;
		int col;

		public Pair(int countKey, int row, int col) {
			super();
			this.countKey = countKey;
			this.row = row;
			this.col = col;
		}

	}

	public static void main(String[] args) {
		String[] grid = { "@..aA", "..B#.", "....b" };
		Pair pair = findKeyCount(grid);
		int countKeys = pair.countKey;
		int row = pair.row;
		int col = pair.col;
		keys = new ArrayList<>();
		min = Integer.MAX_VALUE;

		solve(grid, countKeys, row, col);

		System.out.println(min == Integer.MAX_VALUE ? -1 : min);

	}

	private static void solve(String[] grid, int countKeys, int row, int col) {

		int[][] visited = new int[grid.length + 1][grid[0].length()];

		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { row, col, countKeys, 0 });
		visited[row][col] = -1;

		while (!queue.isEmpty()) {
			int[] poll = queue.poll();
			if (poll[2] == 0) {
				min = Math.min(min, poll[3]);
			}

			if (poll[0] - 1 >= 0 && visited[poll[0] - 1][poll[1]] != -1 && grid[poll[0] - 1].charAt(poll[1]) != '#') {

				char up = grid[poll[0] - 1].charAt(poll[1]);
				if (Character.isLowerCase(up)) {
					keys.add(up);
					queue.add(new int[] { poll[0] - 1, poll[1], poll[2] - 1, poll[3] + 1 });
				} else if (up == '.' || Character.isUpperCase(up) && keys.contains(Character.toLowerCase(up))) {
					queue.add(new int[] { poll[0] - 1, poll[1], poll[2], poll[3] + 1 });
				}

				visited[poll[0] - 1][poll[1]] = -1;
			}

			if (poll[0] + 1 < grid.length && visited[poll[0] + 1][poll[1]] != -1
					&& grid[poll[0] + 1].charAt(poll[1]) != '#') {

				char down = grid[poll[0] + 1].charAt(poll[1]);
				if (Character.isLowerCase(down)) {
					keys.add(down);
					queue.add(new int[] { poll[0] + 1, poll[1], poll[2] - 1, poll[3] + 1 });
				} else if (down == '.' || Character.isUpperCase(down) && keys.contains(Character.toLowerCase(down))) {
					queue.add(new int[] { poll[0] + 1, poll[1], poll[2], poll[3] + 1 });
				}

				visited[poll[0] + 1][poll[1]] = -1;
			}

			if (poll[1] + 1 < grid[poll[0]].length() && visited[poll[0]][poll[1] + 1] != -1
					&& grid[poll[0]].charAt(poll[1] + 1) != '#') {

				char right = grid[poll[0]].charAt(poll[1] + 1);
				if (Character.isLowerCase(right)) {
					keys.add(right);
					queue.add(new int[] { poll[0], poll[1] + 1, poll[2] - 1, poll[3] + 1 });
				} else if (right == '.'
						|| Character.isUpperCase(right) && keys.contains(Character.toLowerCase(right))) {
					queue.add(new int[] { poll[0], poll[1] + 1, poll[2], poll[3] + 1 });
				}

				visited[poll[0]][poll[1] + 1] = -1;
			}

			if (poll[1] - 1 >= 0 && visited[poll[0]][poll[1] - 1] != -1 && grid[poll[0]].charAt(poll[1] - 1) != '#') {

				char left = grid[poll[0]].charAt(poll[1] - 1);
				if (Character.isLowerCase(left)) {
					keys.add(left);
					queue.add(new int[] { poll[0], poll[1] - 1, poll[2] - 1, poll[3] + 1 });
				} else if (left == '.' || Character.isUpperCase(left) && keys.contains(Character.toLowerCase(left))) {
					queue.add(new int[] { poll[0], poll[1] - 1, poll[2], poll[3] + 1 });
				}

				visited[poll[0]][poll[1] - 1] = -1;
			}
		}

	}

	private static Pair findKeyCount(String[] grid) {
		int count = 0;
		int row = 0;
		int col = 0;
		for (int i = 0; i < grid.length; i++) {
			String each = grid[i];
			for (int j = 0; j < each.length(); j++) {
				char eachChar = each.charAt(j);
				if (Character.isLowerCase(eachChar)) {
					count++;
				}
				if (eachChar == '@') {
					row = i;
					col = j;
				}
			}
		}
		return new Pair(count, row, col);
	}

}
