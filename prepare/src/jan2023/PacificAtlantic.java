package jan2023;

import java.util.ArrayList;
import java.util.List;

public class PacificAtlantic {

	public static List<List<Integer>> list;

	public static void main(String[] args) {
		int[][] heights = { { 1, 2, 2, 3, 5 }, { 3, 2, 3, 4, 4 }, { 2, 4, 5, 3, 1 }, { 6, 7, 1, 4, 5 },
				{ 5, 1, 1, 2, 4 } };
		list = new ArrayList<>();

		for (int i = 0; i < heights.length; i++) {
			for (int j = 0; j < heights[i].length; j++) {
				if (northWest(heights, i, j, new boolean[200][200])
						&& northEast(heights, i, j, new boolean[200][200])) {
					list.add(List.of(i, j));
				}
			}
		}

		System.out.println(list);

	}

	private static boolean northWest(int[][] heights, int row, int col, boolean[][] set) {
		boolean up = false;
		boolean down = false;
		boolean right = false;
		boolean left = false;
		if (row < 0 || col < 0 || row >= heights.length || col >= heights[0].length) {
			return false;
		}

		if (row == 0 || col == 0) {
			return true;
		}

		set[row][col] = true;

		if (row - 1 >= 0 && heights[row - 1][col] <= heights[row][col] && !set[row - 1][col]) {
			up = northWest(heights, row - 1, col, set);
		}
		if (row + 1 < heights.length && heights[row + 1][col] <= heights[row][col] && !set[row + 1][col]) {
			down = northWest(heights, row + 1, col, set);
		}
		if (col + 1 < heights[0].length && heights[row][col + 1] <= heights[row][col] && !set[row][col + 1]) {
			right = northWest(heights, row, col + 1, set);
		}
		if (col - 1 >= 0 && heights[row][col - 1] <= heights[row][col] && !set[row][col - 1]) {
			left = northWest(heights, row, col - 1, set);
		}
		return (up || down || right || left);
	}

	private static boolean northEast(int[][] heights, int row, int col, boolean[][] set) {
		boolean up = false;
		boolean down = false;
		boolean right = false;
		boolean left = false;

		if (row < 0 || col < 0 || row >= heights.length || col >= heights[0].length) {
			return false;
		}

		if (row == heights.length - 1 || col == heights[0].length - 1) {
			return true;
		}

		set[row][col] = true;

		if (row - 1 >= 0 && heights[row - 1][col] <= heights[row][col] && !set[row - 1][col]) {
			up = northEast(heights, row - 1, col, set);
		}
		if (row + 1 < heights.length && heights[row + 1][col] <= heights[row][col] && !set[row + 1][col]) {
			down = northEast(heights, row + 1, col, set);
		}
		if (col + 1 < heights[0].length && heights[row][col + 1] <= heights[row][col] && !set[row][col + 1]) {
			right = northEast(heights, row, col + 1, set);
		}
		if (col - 1 >= 0 && heights[row][col - 1] <= heights[row][col] && !set[row][col - 1]) {
			left = northEast(heights, row, col - 1, set);
		}
		return (up || down || right || left);
	}

}
