package oct2023;

public class OnesMinusZeros {

	public static void main(String[] args) {
		int[][] grid = { { 1, 1, 1 }, { 1, 1, 1 } };
		System.out.println(solve(grid));

	}

	private static int[][] solve(int[][] grid) {

		int[][] rowCounter = new int[Math.max(grid.length, grid[0].length)][2];

		for (int i = 0; i < grid.length; i++) {
			int count = 0;
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					count++;
				} else {
					count--;
				}
			}
			rowCounter[i][0] = count;
		}

		for (int i = 0; i < grid[0].length; i++) {
			int count = 0;
			for (int j = 0; j < grid.length; j++) {
				if (grid[j][i] == 1) {
					count++;
				} else {
					count--;
				}
			}
			rowCounter[i][1] = count;
		}
		int[][] response = new int[grid.length][grid[0].length];

		for (int i = 0; i < response.length; i++) {
			for (int j = 0; j < response[0].length; j++) {
				response[i][j] = rowCounter[i][0] + rowCounter[j][1];
			}
		}

		return response;
	}

}
