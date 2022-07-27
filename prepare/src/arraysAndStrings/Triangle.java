package arraysAndStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triangle {

	static int[][] matrix = new int[1001][1001];

	public static void main(String[] args) {

		matrix = new int[1001][1001];

		for (int[] each : matrix) {
			Arrays.fill(each, -1);
		}

		List<List<Integer>> triangle = new ArrayList<>();
		List<Integer> firstRow = new ArrayList<>();
		firstRow.add(2);

		List<Integer> secondRow = new ArrayList<>();
		secondRow.add(3);
		secondRow.add(4);

		List<Integer> thirdRow = new ArrayList<>();
		thirdRow.add(6);
		thirdRow.add(5);
		thirdRow.add(7);

		List<Integer> fourthRow = new ArrayList<>();
		fourthRow.add(4);
		fourthRow.add(1);
		fourthRow.add(8);
		fourthRow.add(3);

		triangle.add(firstRow);
		triangle.add(secondRow);
		triangle.add(thirdRow);
		triangle.add(fourthRow);

		// System.out.println(solve(triangle));

		System.out.println(solveDP(triangle, 0, 0));

	}

	private static int solveDP(List<List<Integer>> triangle, int i, int j) {

		if (matrix[i][j] != -1) {
			return matrix[i][j];
		}
		
		int sum = 0;

		sum = sum + triangle.get(i).get(j);

		if (i < triangle.size() - 1) {
			int left = solveDP(triangle, i + 1, j);
			int right = solveDP(triangle, i + 1, j + 1);

			sum = sum + Math.min(left, right);
		}

		return matrix[i][j]=sum;

	}

	private static int solve(List<List<Integer>> triangle) {
		int minPath = 0;
		int position = 0;

		if (triangle.size() == 0) {
			return 0;
		}

		if (triangle.size() == 1) {
			return triangle.get(0).get(0);
		}

		int i = 0;
		while (i < triangle.size()) {
			if (i == 0) {
				minPath = minPath + triangle.get(i).get(0);
				position = 0;
				i++;
			} else {
				List<Integer> tempList = triangle.get(i);
				minPath = minPath + Math.min(tempList.get(position), tempList.get(position + 1));
				i++;
			}
		}
		return minPath;
	}

}
