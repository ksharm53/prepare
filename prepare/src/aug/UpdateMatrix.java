package aug;

import java.util.LinkedList;
import java.util.Queue;

public class UpdateMatrix {

	public static void main(String[] args) {
		int[][] mat = { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };
		System.out.println(solve(mat));

	}

	private static int[][] solve(int[][] mat) {
		int[][] res = new int[mat.length][mat[0].length];
		for (int i = mat.length - 1; i >= 0; i--) {
			for (int j = mat[0].length - 1; j >= 0; j--) {
				if (mat[i][j] == 1) {
					res[i][j] = findNearest(i, j, mat);
				}
			}
		}

		return res;
	}

	private static int findNearest(int row, int col, int[][] mat) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { row, col, 0 });
		while (!queue.isEmpty()) {
			int[] curr = queue.poll();
			int rowCur = curr[0];
			int colCur = curr[1];

			if ((rowCur - 1 >= 0 && mat[rowCur - 1][colCur] == 0)
					|| (rowCur + 1 < mat.length && mat[rowCur + 1][colCur] == 0)
					|| (colCur - 1 >= 0 && mat[rowCur][colCur - 1] == 0)
					|| (colCur + 1 < mat[0].length && mat[rowCur][colCur + 1] == 0)) {
				return curr[2] + 1;
			}

			else {
				if (rowCur - 1 >= 0) {
					queue.add(new int[] { rowCur - 1, colCur, curr[2] + 1 });
				}

				if (rowCur + 1 < mat.length) {
					queue.add(new int[] { rowCur + 1, colCur, curr[2] + 1 });
				}

				if (colCur - 1 >= 0) {
					queue.add(new int[] { rowCur, colCur - 1, curr[2] + 1 });
				}

				if ((colCur + 1 < mat[0].length)) {
					queue.add(new int[] { rowCur, colCur + 1, curr[2] + 1 });
				}
			}
		}
		return 0;
	}

}
