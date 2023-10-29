package june;

import java.util.HashSet;
import java.util.Set;

public class DifferenceOfDistinctValues {

	public static void main(String[] args) {
		int[][] grid = { { 1, 2, 3 }, { 3, 1, 5 }, { 3, 2, 1 } };
		System.out.println(solve(grid));
	}

	private static int[][] solve(int[][] grid) {
		int[][] answer = new int[grid.length][grid[0].length];
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				Set<Integer> setleft = new HashSet<>();
				Set<Integer> setRight = new HashSet<>();

				int leftRow = i - 1;
				int leftCol = j - 1;
				while (leftRow >= 0 && leftCol >= 0) {
					setleft.add(grid[leftRow][leftCol]);
					leftRow--;
					leftCol--;
				}

				int righttRow = i + 1;
				int rightCol = j + 1;
				while (righttRow < grid.length && rightCol < grid[0].length) {
					setRight.add(grid[righttRow][rightCol]);
					righttRow++;
					rightCol++;
				}

				answer[i][j] = Math.abs(setleft.size() - setRight.size());
			}
		}

		return answer;
	}

}
