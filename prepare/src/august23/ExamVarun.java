package august23;

public class ExamVarun {

	public static void main(String[] args) {
		int[][] matrix = { { 0, 0, 0, 0 }, { 1, 1, 1, 1 }, { 0, 1, 1, 1 }, { 1, 0, 1, 1 } };
		int[] value = largest(matrix);
		System.out.println(value);
	}

	public static int[] largest(int[][] matrix) {

		int N = matrix.length;
		int M = matrix[0].length;
		if (N == 0 || M == 0)
			return new int[] {};
		int[][] leftUp = leftUp(matrix, N, M);
		int[][] rightDown = rightDown(matrix, N, M);
		return merge(leftUp, rightDown, N, M);
	}

	private static int[] merge(int[][] leftUp, int[][] rightDown, int N, int M) {
		int result = 0;
		int[] resultArray = new int[2];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				leftUp[i][j] = Math.min(leftUp[i][j], rightDown[i][j]);
				if (leftUp[i][j] > result) {
					resultArray = new int[] { i, j };
				}

			}
		}
		return resultArray;
	}

	private static int[][] leftUp(int[][] matrix, int N, int M) {
		int[][] left = new int[N][M];
		int[][] up = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (matrix[i][j] == 1) {
					left[i][j] = getNumber(left, i - 1, j - 1, N, M) + 1;
					up[i][j] = getNumber(up, i - 1, j + 1, N, M) + 1;
				}
			}
		}
		merge(left, up, N, M);
		return left;
	}

	private static int[][] rightDown(int[][] matrix, int N, int M) {
		int[][] right = new int[N][M];
		int[][] down = new int[N][M];
		for (int i = N - 1; i >= 0; i--) {
			for (int j = M - 1; j >= 0; j--) {
				if (matrix[i][j] == 1) {
					right[i][j] = getNumber(right, i + 1, j + 1, N, M) + 1;
					down[i][j] = getNumber(down, i + 1, j - 1, N, M) + 1;
				}
			}
		}
		merge(right, down, N, M);
		return right;
	}

	private static int getNumber(int[][] input, int x, int y, int N, int M) {
		if (x < 0 || x >= N || y < 0 || y >= M)
			return 0;
		return input[x][y];
	}
}
