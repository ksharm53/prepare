package arraysAndStrings;

public class MatchstickstoSquare {

	public static void main(String[] args) {
		int[] matchsticks = { 6, 6, 6, 6, 4, 2, 2 };

		System.out.println(solve(matchsticks));

	}

	private static boolean solve(int[] matchsticks) {

		if (null == matchsticks || matchsticks.length == 0) {
			return false;
		}

		int sum = 0;
		int max = Integer.MIN_VALUE;
		for (int i : matchsticks) {
			sum = sum + i;
			max = Math.max(max, i);
		}

		if (sum % 4 != 0 || sum / 4 < max) {
			return false;
		}

		int count = countSubsetSumBottomUp(matchsticks, sum / 4);

		int countAgain = countSubsetSum(matchsticks, sum / 4, matchsticks.length);

		System.out.println(count + "--" + countAgain);

		return count >= 4 ? true : false;
	}

	private static int countSubsetSumBottomUp(int[] matchsticks, int sum) {
		int[][] matrix = new int[matchsticks.length + 1][sum + 1];

		for (int i = 0; i < matrix[0].length; i++) {
			matrix[0][i] = 0;
		}

		for (int i = 0; i < matrix.length; i++) {
			matrix[i][0] = 1;
		}

		for (int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix[0].length; j++) {
				if (matchsticks[i - 1] <= j) {
					matrix[i][j] = matrix[i - 1][j - matchsticks[i - 1]] + matrix[i - 1][j];
				} else {
					matrix[i][j] = matrix[i - 1][j];
				}
			}
		}
		return matrix[matchsticks.length][sum];

	}

	private static int countSubsetSum(int[] matchsticks, int sum, int length) {

		if (sum == 0) {
			return 1;
		} else if (length == 0) {
			return 0;
		}

		if (matchsticks[length - 1] <= sum) {
			return countSubsetSum(matchsticks, sum - matchsticks[length - 1], length - 1)
					+ countSubsetSum(matchsticks, sum, length - 1);
		} else {
			return countSubsetSum(matchsticks, sum, length - 1);
		}
	}

}
