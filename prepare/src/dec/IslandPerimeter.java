package dec;

public class IslandPerimeter {

	public static void main(String[] args) {
		int[][] grid = { { 1, 0 } };
		System.out.println(solve(grid));
	}

	private static int solve(int[][] grid) {
		int count = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == 1) {
					// upar
					if ((i - 1 >= 0 && grid[i - 1][j] == 0) || i - 1 < 0) {
						count++;
					}
					// right
					if ((j + 1 < grid[i].length && grid[i][j + 1] == 0) || j + 1 >= grid[i].length) {
						count++;
					}
					// neeche
					if ((i + 1 < grid.length && grid[i + 1][j] == 0) || i + 1 >= grid.length) {
						count++;
					}
					// left
					if ((j - 1 >= 0 && grid[i][j - 1] == 0) || j - 1 < 0) {
						count++;
					}
				}
			}
		}
		return count;
	}

}
