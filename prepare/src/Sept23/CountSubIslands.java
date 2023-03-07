package Sept23;

import java.util.HashSet;
import java.util.Set;

public class CountSubIslands {

	public static Set<String> visitedGrid1;
	public static Set<String> visitedGrid2;

	public static void main(String[] args) {
		CountSubIslands cs = new CountSubIslands();
		int[][] grid1 = { { 1, 1, 1, 0, 0 }, { 0, 1, 1, 1, 1 }, { 0, 0, 0, 0, 0 }, { 1, 0, 0, 0, 0 },
				{ 1, 1, 0, 1, 1 } };
		int[][] grid2 = { { 1, 1, 1, 0, 0 }, { 0, 0, 1, 1, 1 }, { 0, 1, 0, 0, 0 }, { 1, 0, 1, 1, 0 },
				{ 0, 1, 0, 1, 0 } };

		visitedGrid1 = new HashSet<>();
		visitedGrid2 = new HashSet<>();

		System.out.println(cs.countSubIslands(grid1, grid2));

	}

	public int countSubIslands(int[][] grid1, int[][] grid2) {
		int row = grid1.length;
		int column = grid1[0].length;
		int result = 0;

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				validate1(grid1, i, j);
			}
		}

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				Set<String> currentSet = new HashSet<>();
				if (validate2(grid2, i, j, currentSet)) {
					if (visitedGrid1.containsAll(currentSet)) {
						result++;
					}
				}
			}
		}

		return result;
	}

	public static boolean validate1(int[][] grid, int row, int column) {

		if (row < 0 || row >= grid.length || column < 0 || column >= grid[0].length) {
			return false;
		}

		String val = row + "-" + column;

		if (grid[row][column] == 0 || visitedGrid1.contains(val)) {
			return false;
		}

		visitedGrid1.add(val);

		validate1(grid, row + 1, column);
		validate1(grid, row, column + 1);
		validate1(grid, row - 1, column);
		validate1(grid, row, column - 1);
		return true;

	}

	public static boolean validate2(int[][] grid, int row, int column, Set<String> current) {

		if (row < 0 || row >= grid.length || column < 0 || column >= grid[0].length) {
			return false;
		}

		String val = row + "-" + column;

		if (grid[row][column] == 0 || visitedGrid2.contains(val)) {
			return false;
		}

		visitedGrid2.add(val);
		current.add(val);

		validate2(grid, row + 1, column, current);
		validate2(grid, row, column + 1, current);
		validate2(grid, row - 1, column, current);
		validate2(grid, row, column - 1, current);
		return true;

	}

}
