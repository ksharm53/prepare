package Oct21;

import java.util.HashSet;
import java.util.Set;

public class KnightProbabilityinChessboard {
	public static Set<String> set;
	private static int[][] dir = new int[][] { { -2, -1 }, { -1, -2 }, { 1, -2 }, { 2, -1 }, { 2, 1 }, { 1, 2 },
			{ -1, 2 }, { -2, 1 } };
	public static boolean flag;

	public static void main(String[] args) {
		int n = 3;
		int k = 2;
		int row = 0;
		int column = 0;
		int[][] arr = new int[n][n];
		set = new HashSet<>();
		flag = false;

		solve(arr, k, row, column);
		System.out.println(set);
		double val = Math.pow(.125, set.size());
		System.out.println(val);

	}

	private static void solve(int[][] arr, int k, int row, int column) {
		if (row < 0 || row > arr.length - 1 || column < 0 || column > arr[0].length - 1) {
			return;
		}

		if (k < 0) {
			return;
		}
		if (flag) {
			set.add(row + "-" + column);
		}
		flag = true;

		solve(arr, k - 1, row - 2, column - 1);
		solve(arr, k - 1, row - 2, column + 1);
		solve(arr, k - 1, row + 2, column - 1);
		solve(arr, k - 1, row + 2, column + 1);
		solve(arr, k - 1, row - 1, column - 2);
		solve(arr, k - 1, row + 1, column - 2);
		solve(arr, k - 1, row - 1, column + 2);
		solve(arr, k - 1, row + 1, column + 2);

	}

}
