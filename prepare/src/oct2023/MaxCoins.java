package oct2023;

import java.util.Arrays;

public class MaxCoins {

	public static void main(String[] args) {
		int[] piles = { 2, 4, 5 };
		System.out.println(solve(piles));
	}

	private static int solve(int[] piles) {
		Arrays.sort(piles);
		int i = 0;
		int j = piles.length - 2;
		int count = 0;
		while (i < j) {
			count += piles[j];
			i++;
			j -= 2;
		}

		return count;
	}

}
