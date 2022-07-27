package arraysAndStrings;

public class MinimumCoinUnboundedKnapsack {

	public static void main(String[] args) {
		int[] coins = { 2 };
		int amount = 3;

		System.out.println(solution(coins, amount));

	}

	private static int solution(int[] coins, int amount) {
		int vertical = coins.length + 1;
		int horizontal = amount + 1;

		int[][] matrix = new int[vertical][horizontal];

		for (int i = 0; i < vertical; i++) {
			matrix[i][0] = 0;
		}

		for (int i = 0; i < horizontal; i++) {
			matrix[0][i] = Integer.MAX_VALUE - 1;
		}

		for (int i = 1; i < horizontal; i++) {
			if (i % coins[0] == 0) {
				matrix[1][i] = i / coins[0];
			} else {
				matrix[1][i] = Integer.MAX_VALUE - 1;
			}
		}

		for (int i = 2; i < vertical; i++) {
			for (int j = 1; j < horizontal; j++) {
				if (coins[i - 1] <= j) {
					matrix[i][j] = Math.min(matrix[i][j - coins[i - 1]] + 1, matrix[i - 1][j]);
				} else {
					matrix[i][j] = matrix[i - 1][j];
				}
			}
		}

		return matrix[vertical - 1][horizontal - 1] == Integer.MAX_VALUE - 1 ? -1
				: matrix[vertical - 1][horizontal - 1];
	}

}
