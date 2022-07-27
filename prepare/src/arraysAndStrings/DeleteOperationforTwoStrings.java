package arraysAndStrings;

public class DeleteOperationforTwoStrings {

	public static void main(String[] args) {
		String word1 = "park";
		String word2 = "spake";

		System.out.println(solve(word1, word2, word1.length(), word2.length()));

	}

	private static int solve(String word1, String word2, int length1, int length2) {

		int max= Integer.MIN_VALUE;
		
		if (length1 == 0) {
			return word2.length();
		}

		else if (length2 == 0) {
			return word1.length();
		}

		int[][] matrix = new int[length1 + 1][length2 + 1];

		for (int i = 0; i <= length1; i++) {
			matrix[i][0] = 0;
		}

		for (int i = 0; i <= length2; i++) {
			matrix[0][i] = 0;
		}

		for (int i = 1; i <= length1; i++) {
			for (int j = 1; j <= length2; j++) {
				if (word1.charAt(i-1) == word2.charAt(j-1)) {
					matrix[i][j] = 1 + matrix[i - 1][j - 1];
					max= Math.max(max, matrix[i][j]);
				} else {
					matrix[i][j] = Math.max(matrix[i][j - 1], matrix[i - 1][j]);
					max= Math.max(max, matrix[i][j]);
				}
			}
		}
		return Math.abs(word1.length()-max) + Math.abs( word2.length()-max);
	}

}
