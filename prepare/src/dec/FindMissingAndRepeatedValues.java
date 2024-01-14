package dec;

import java.util.Arrays;

public class FindMissingAndRepeatedValues {

	public static void main(String[] args) {
		int[][] grid = { { 9, 1, 7 }, { 8, 9, 2 }, { 3, 4, 6 } };
		System.out.println(solve(grid));
	}

	private static int[] solve(int[][] grid) {
		int[] res = new int[2];
		int[] temp = new int[grid.length * grid.length];
		Arrays.fill(temp, -1);

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (temp[grid[i][j] - 1] != -1) {
					res[0] = grid[i][j];
				}
				temp[grid[i][j] - 1] = grid[i][j] - 1;
			}
		}
		for (int i = 0; i < temp.length; i++) {
			if (temp[i] == -1) {
				res[1] = i + 1;
			}
		}
		return res;
	}

}
