package arraysAndStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class hourglassSum {

	public static void main(String[] args) {
		List<List<Integer>> arr = new ArrayList<>();
		List<Integer> row1 = Arrays.asList(-9, -9, -9, 1, 1, 1);
		List<Integer> row2 = Arrays.asList(0, -9, 0, 4, 3, 2);
		List<Integer> row3 = Arrays.asList(-9, -9, -9, 1, 2, 3);
		List<Integer> row4 = Arrays.asList(0, 0, 8, 6, 6, 0);
		List<Integer> row5 = Arrays.asList(0, 0, 0, -2, 0, 0);
		List<Integer> row6 = Arrays.asList(0, 0, 1, 2, 4, 1);

		arr.add(row1);
		arr.add(row2);
		arr.add(row3);
		arr.add(row4);
		arr.add(row5);
		arr.add(row6);

		System.out.println(solve(arr));
	}

	private static int solve(List<List<Integer>> arr) {
		int[][] matrix1 = new int[6][4];
		int[][] matrix2 = new int[6][4];
		int[][] solution = new int[4][4];
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < arr.size(); i++) {
			for (int j = 0; j < arr.get(0).size() - 2; j++) {
				int tempj = j;
				int counter = 3;
				int sum = 0;
				while (counter > 0) {
					sum = sum + arr.get(i).get(j);
					j++;
					counter--;
				}
				j = j - 3;
				matrix1[i][tempj] = sum;

			}

			for (int k = 1; k < arr.get(0).size() - 1; k++) {
				if (i != 0) {
					matrix2[i][k - 1] = arr.get(i).get(k);
				}
			}
		}

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				solution[i][j] = matrix1[i][j] + matrix2[i + 1][j] + matrix1[i + 2][j];
			}
		}

		for (int i = 0; i < solution.length; i++) {
			for (int j = 0; j < solution[0].length; j++) {
				max = Math.max(max, solution[i][j]);
			}
		}
		return max;
	}

}
