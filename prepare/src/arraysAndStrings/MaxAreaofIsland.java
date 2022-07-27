package arraysAndStrings;

public class MaxAreaofIsland {

	static boolean[][] used;
	static int[][] ourGrid;

	public static void main(String[] args) {

		int[][] grid = { { 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 },
				{ 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0 },
				{ 0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0 } };

		used = new boolean[grid.length][grid[0].length];
		ourGrid = grid;

		System.out.println(solve(grid));

	}

	private static int solve(int[][] grid) {
		if (grid.length == 0) {
			return 0;
		}
		int max = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				max = Math.max(max, recurse(i, j));
			}
		}
		return max;
	}

	private static int recurse(int i, int j) {

		if (i < 0 || i >= ourGrid.length || j < 0 || j >= ourGrid[0].length || used[i][j] || ourGrid[i][j] == 0) {
			return 0;
		}

		used[i][j] = true;
		return (1 + recurse(i + 1, j) + recurse(i - 1, j) + recurse(i, j + 1) + recurse(i, j - 1));

	}

}
