package may1;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrder {

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
		System.out.println(solve(matrix));
	}

	private static List<Integer> solve(int[][] matrix) {
		int row = 0;
		int col = 0;

		int rowUpperLimit = 0;
		int rowLowerLimit = matrix.length - 1;
		int colLeftLimit = 0;
		int colRightLimit = matrix[0].length - 1;

		List<Integer> list = new ArrayList<>();

		StringBuilder dir = new StringBuilder("right");

		while (rowUpperLimit <= rowLowerLimit && colLeftLimit <= colRightLimit) {
			if (dir.toString().equals("right")) {
				while (col <= colRightLimit) {
					list.add(matrix[row][col]);
					col++;
				}
				col--;
				row++;
				rowUpperLimit++;
				dir = new StringBuilder();
				dir.append("down");
			}

			else if (dir.toString().equals("down")) {
				while (row <= rowLowerLimit) {
					list.add(matrix[row][col]);
					row++;
				}
				row--;
				col--;
				colRightLimit--;
				dir = new StringBuilder();
				dir.append("left");
			}

			else if (dir.toString().equals("left")) {
				while (col >= colLeftLimit) {
					list.add(matrix[row][col]);
					col--;
				}
				col++;
				row--;
				rowLowerLimit--;
				dir = new StringBuilder();
				dir.append("up");
			}

			else if (dir.toString().equals("up")) {
				while (row >= rowUpperLimit) {
					list.add(matrix[row][col]);
					row--;
				}
				row++;
				col++;
				colLeftLimit++;
				dir = new StringBuilder();
				dir.append("right");
			}
		}

		return list;
	}

}
