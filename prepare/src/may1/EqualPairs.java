package may1;

import java.util.HashMap;
import java.util.Map;

public class EqualPairs {

	static Map<String, String> map;

	public static void main(String[] args) {
		int[][] grid = { { 11, 1 }, { 1, 11 } };

		map = new HashMap<>();

		System.out.println(solve(grid));

	}

	private static int solve(int[][] grid) {
		fillRows(grid);
		fillCols(grid);

		int count = 0;

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (map.get("r" + i).equalsIgnoreCase(map.get("c" + j))) {
					count++;
				}
			}
		}

		return count;
	}

	private static void fillCols(int[][] grid) {
		for (int i = 0; i < grid[0].length; i++) {
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < grid.length; j++) {
				sb.append(grid[j][i]);
				if (j != grid.length - 1) {
					sb.append("-");
				}
			}

			map.put("c" + i, sb.toString());
		}

	}

	private static void fillRows(int[][] grid) {
		for (int i = 0; i < grid.length; i++) {
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < grid[i].length; j++) {
				sb.append(grid[i][j]);
				if (j != grid[i].length - 1) {
					sb.append("-");
				}
			}

			map.put("r" + i, sb.toString());
		}
	}

}
