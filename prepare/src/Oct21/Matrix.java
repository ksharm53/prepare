package Oct21;

public class Matrix {

	public static void main(String[] args) {
		int[][] arr = { { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 } };

		solve(arr, 1 - 1, 2 - 1, 2 - 1, 2 - 1, 5);
		solve(arr, 2 - 1, 1 - 1, 4 - 1, 3 - 1, 6);

		int sum = arr[0][0];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (i == 0 && j == 0) {
					continue;
				}
				sum += arr[i][j];
				arr[i][j] = sum;
			}
		}

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.println(i + "-" + j + "-" + arr[i][j]);
			}
		}

	}

	private static void solve(int[][] arr, int r1, int c1, int r2, int c2, int k) {
		arr[r1][c1] += k;
		if (!(r2 >= arr.length || r2 < 0 || c2 + 1 >= arr[0].length || c2 < 0)) {
			arr[r2][c2 + 1] -= k;
		}
	}

}
