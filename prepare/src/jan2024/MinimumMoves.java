package jan2024;

public class MinimumMoves {

	public static void main(String[] args) {
		int[][] grid = { { 0, 2, 3 }, { 2, 0, 1 }, { 0, 1, 0 } };
		System.out.println(solve(grid));
	}

	private static int solve(int[][] grid) {

		boolean flag = false;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 0) {
					flag = true;
					break;
				}
			}
		}

		if (!flag) {
			return 0;
		}

		int min = Integer.MAX_VALUE;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 0) {
					for (int k = 0; k < grid.length; k++) {
						for (int l = 0; l < grid[0].length; l++) {
							if (grid[k][l] > 1) {
								grid[k][l]--;
								grid[i][j]++;
								int distance = Math.abs(i - k) + Math.abs(j - l);
								min = Math.min(min, distance + solve(grid));
								grid[k][l]++;
								grid[i][j]--;
							}
						}
					}
				}
			}
		}

		return min;
	}

}
