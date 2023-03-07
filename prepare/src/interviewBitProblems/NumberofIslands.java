package interviewBitProblems;

import java.util.HashSet;
import java.util.Set;

public class NumberofIslands {

	public static Set<String> set;
	public static char[][] grid;

	public static void main(String[] args) {

		grid = new char[][] { { '1', '1', '0', '0', '0' }, { '1', '1', '0', '0', '0' }, { '0', '0', '1', '0', '0' },
				{ '0', '0', '0', '1', '1' } };

		set = new HashSet<>();

		System.out.println(solve(grid));

	}

	private static int solve(char[][] grid) {
		if (grid.length == 0) {
			return 0;
		}

		int counter = 0;

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (validate(i, j)) {
					counter++;
				}
			}
		}
		return counter;
	}

	private static boolean validate(int row, int column) {
		String eachEntry = String.valueOf(row) + ',' + String.valueOf(column);
		if (set.contains(eachEntry)) {
			return false;
		} else {
			set.add(eachEntry);
		}

		boolean rowValidation = row < 0 || row > grid.length - 1;
		boolean columnValidation = column < 0 || column > grid[0].length - 1;

		if (rowValidation || columnValidation) {
			return false;
		}

		if (grid[row][column] == '0') {
			return false;
		}

		validate(row + 1, column);
		validate(row, column + 1);
		validate(row - 1, column);
		validate(row, column - 1);

		return true;
	}

}
