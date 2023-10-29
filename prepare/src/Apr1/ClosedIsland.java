package Apr1;

public class ClosedIsland {

	static int[][] matrix;

	public static void main(String[] args) {
		int[][] grid = { { 0, 0, 1, 0, 0 }, { 0, 1, 0, 1, 0 }, { 0, 1, 1, 1, 0 } };

		matrix = new int[grid.length][grid[0].length];

		System.out.println(solve(grid));

	}

	private static int solve(int[][] grid) {
		int count = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 0 && matrix[i][j] != -1) {
					if (recursion(grid, i, j)) {
						count++;
					}
				}
			}
		}

		return count;
	}

	private static boolean recursion(int[][] grid, int row, int col) {
		if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) {
			return false;
		}
		if (grid[row][col] == 1 || matrix[row][col] == -1) {
			return true;
		}

		if (matrix[row][col] == -1) {
			return false;
		}

		matrix[row][col] = -1;

		boolean top = recursion(grid, row - 1, col);
		boolean bottom = recursion(grid, row + 1, col);
		boolean left = recursion(grid, row, col - 1);
		boolean right = recursion(grid, row, col + 1);

		return top && bottom && left && right;

	}

}
