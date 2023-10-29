package Apr1;

public class NumSubmat {

	public static void main(String[] args) {
		int[][] mat = { { 1, 0, 1 }, { 1, 1, 0 }, { 1, 1, 0 } };
		System.out.println(solve(mat));
	}

	private static int solve(int[][] mat) {
		int oneCount = 0;
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				if (mat[i][j] == 1) {
					int innerStreak = 0;
					while (j < mat[0].length && mat[i][j] == 1) {
						oneCount++;
						innerStreak++;
						j++;
					}
					oneCount += (innerStreak * (innerStreak - 1)) / 2;
				}
			}
		}

		for (int i = 0; i < mat[0].length; i++) {
			for (int j = 0; j < mat.length; j++) {
				if (mat[j][i] == 1) {
					int innerStreak = 0;
					while (j < mat.length && mat[j][i] == 1) {
						innerStreak++;
						j++;
					}
					oneCount += (innerStreak * (innerStreak - 1)) / 2;
				}
			}
		}

		return oneCount;
	}

}
