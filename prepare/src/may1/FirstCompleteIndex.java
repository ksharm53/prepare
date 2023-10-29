package may1;

import java.util.HashMap;
import java.util.Map;

public class FirstCompleteIndex {

	public static void main(String[] args) {
		int[] arr = { 1, 3, 4, 2 };
		int[][] mat = { { 1, 4 }, { 2, 3 } };
		System.out.println(solve(arr, mat));
	}

	static class Pair {
		int row;
		int col;

		Pair(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}

	private static int solve(int[] arr, int[][] mat) {
		Map<Integer, Pair> map = new HashMap<>();
		Map<String, Integer> rowcolCount = new HashMap<>();
		boolean flag = true;

		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				map.put(mat[i][j], new Pair(i, j));
				if (flag) {
					rowcolCount.put("c" + j, mat.length);
				}
			}
			flag = false;
			rowcolCount.put("r" + i, mat[i].length);
		}

		for (int i = 0; i < arr.length; i++) {
			Pair rowCol = map.get(arr[i]);
			rowcolCount.put("r" + rowCol.row, rowcolCount.get("r" + rowCol.row) - 1);
			rowcolCount.put("c" + rowCol.col, rowcolCount.get("c" + rowCol.col) - 1);
			if (rowcolCount.get("r" + rowCol.row) == 0 || rowcolCount.get("c" + rowCol.col) == 0) {
				return i;
			}
		}
		return -1;
	}

}
