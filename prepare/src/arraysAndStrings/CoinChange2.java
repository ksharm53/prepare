package arraysAndStrings;

public class CoinChange2 {

	public static void main(String[] args) {
		int amount = 23;
		int[] coins = { 5, 8, 10, 6 };

		// System.out.println(solutionTopDown(amount, coins, coins.length));

		System.out.println(solutionRecursive(amount, coins, coins.length));

	}

	private static int solutionRecursive(int amount, int[] coins, int length) {

		if (amount == 0) {
			return 1;
		}

		if (length == 0) {
			return 0;
		}

		if (coins[length - 1] <= amount) {
			return solutionRecursive(amount - coins[length - 1], coins, length)
					+ solutionRecursive(amount, coins, length - 1);
		} else {
			return solutionRecursive(amount, coins, length - 1);
		}

	}

	private static int solutionTopDown(int amount, int[] coins, int length) {

		int vertical = length + 1;
		int horizontal = amount + 1;

		int matrix[][] = new int[vertical][horizontal];

		for (int i = 0; i < vertical; i++) {
			matrix[i][0] = 1;
		}

		for (int i = 0; i < horizontal; i++) {
			matrix[0][i] = 0;
		}

		for (int i = 1; i < vertical; i++) {
			for (int j = 1; j < horizontal; j++) {
				if (coins[i - 1] <= j) {
					matrix[i][j] = matrix[i][j - coins[i - 1]] + matrix[i - 1][j];
				} else {
					matrix[i][j] = matrix[i - 1][j];
				}
			}
		}

		return matrix[vertical - 1][horizontal - 1];

	}

}
