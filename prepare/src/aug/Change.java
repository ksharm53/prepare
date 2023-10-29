package aug;

import java.util.Arrays;

public class Change {

	static int matrix[][];

	public static void main(String[] args) {
		int amount = 5;
		int[] coins = { 1, 2, 5 };

		matrix = new int[coins.length + 1][amount + 1];
		for (int[] each : matrix) {
			Arrays.fill(each, -1);
		}

		System.out.println(solve(amount, coins, 0));

	}

	private static int solve(int amount, int[] coins, int idx) {
		if (amount == 0) {
			return 1;
		}
		if (idx == coins.length) {
			return 0;
		}

		if (matrix[idx][amount] != -1) {
			return matrix[idx][amount];
		}

		if (amount - coins[idx] >= 0) {
			int liya = solve(amount - coins[idx], coins, idx + 1);
			int naiLiya = solve(amount, coins, idx + 1);
			return matrix[idx][amount] = liya + naiLiya;
		} else {
			return matrix[idx][amount] = solve(amount, coins, idx + 1);
		}
	}

}
