package jan2023;

public class Construct2DArray {

	public static void main(String[] args) {
		int[] original = { 1, 2, 3, 4 };
		int m = 2;
		int n = 2;
		System.out.println(construct2DArray(original, m, n));

	}

	public static int[][] construct2DArray(int[] original, int m, int n) {
		int[][] res = new int[m][n];
		int counter = 0;
		for (int i = 0; i < m; i++) {
			int start = counter * n;
			int end = (counter + 1) * n - 1;
			int k = 0;
			for (int j = start; j <= end; j++) {
				res[i][k] = original[j];
				k++;
			}
			counter++;
		}
		return res;
	}

}
