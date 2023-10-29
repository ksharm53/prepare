package Sept23;

import java.util.Arrays;

public class CoinChange {

	public static int[][] matrix;

	public static void main(String[] args) {
		int[] coins = { 5, 8, 10, 6};
		int amount = 24;

		matrix = new int[coins.length + 1][amount + 1];
		for (int[] i : matrix) {
			Arrays.fill(i, -1);
		}

		int result = solve(coins, coins.length - 1, amount);
		if (result == Integer.MAX_VALUE - 1) {
			System.out.println(-1);
		} else {
			System.out.println(result);
		}
	}

	public static int solve(int[] coins, int length, int amount) {
		if (length < 0 || amount <= 0) {
			return amount == 0 ? 0 : Integer.MAX_VALUE - 1;
		}

		if (matrix[length][amount] != -1) {
			return matrix[length][amount];
		}

		if (coins[length] <= amount) {
			return matrix[length][amount] = Math.min(1 + solve(coins, length, amount - coins[length]),
					solve(coins, length - 1, amount));
		} else {
			return matrix[length][amount] = solve(coins, length - 1, amount);
		}
	}

}
