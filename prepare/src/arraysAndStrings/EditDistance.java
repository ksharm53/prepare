package arraysAndStrings;

public class EditDistance {

	public static void main(String[] args) {
		String A = "Anshuman";
		String B = "Antihuman";

		System.out.println(solve(A, B));
	}

	private static int solve(String a, String b) {

		int matrix[][] = new int[a.length() + 1][b.length() + 1];

		for (int i = 0; i <= a.length(); i++) {
			for (int j = 0; j <= b.length(); j++) {
				if (i == 0 || j == 0) {
					matrix[i][j] = Math.max(i, j);
				}
			}
		}

		for (int i = 1; i <= a.length(); i++) {
			for (int j = 1; j <= b.length(); j++) {
				if (a.charAt(i - 1) == b.charAt(j - 1)) {
					matrix[i][j] = matrix[i - 1][j - 1];
				} else {
					matrix[i][j] = Math.min(matrix[i - 1][j - 1] + 1,
							Math.min(matrix[i][j - 1] + 1, matrix[i - 1][j] + 1));
				}
			}
		}
		return matrix[a.length()][b.length()];

	}

}
