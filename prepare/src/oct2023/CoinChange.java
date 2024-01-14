package oct2023;

import java.util.Arrays;

public class CoinChange {

	public static void main(String[] args) {

		int[] denominations = new int[] { 1, 5, 10 };
		int amount = 20;
		int count = solveCoinChange(denominations, amount, 0);

		System.out.print("SolveCoinChange(" + Arrays.toString(denominations) + ", " + amount + ") = " + count);

	}

	private static int solveCoinChange(int[] denominations, int amount, int idx) {

		if (amount == 0) {
			return 1;
		}
		if (idx == denominations.length) {
			return 0;
		}
		if (denominations[idx] <= amount) {
			int liya = solveCoinChange(denominations, amount - denominations[idx], idx);
			int naiLiya = solveCoinChange(denominations, amount, idx + 1);
			return liya + naiLiya;

		} else {
			return solveCoinChange(denominations, amount, idx + 1);
		}
	}

}
