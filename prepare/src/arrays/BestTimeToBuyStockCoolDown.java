package arrays;

public class BestTimeToBuyStockCoolDown {

	public static void main(String[] args) {
		int[] prices = { 1, 2 };
		System.out.println(solve(prices));

	}

	public static int solve(int[] prices) {
		if (prices.length == 0) {
			return 0;
		}
		int max = 0;
		int maxFinal = Integer.MIN_VALUE;

		for (int i = 0; i < prices.length; i++) {
			max = 0;

			for (int j = i; j < prices.length - 1; j++) {
				if (prices[j + 1] <= prices[j]) {
					continue;
				} else {
					max += prices[j + 1] - prices[j];
					j++;
				}

			}
			maxFinal = Math.max(maxFinal, max);
		}
		return maxFinal;
	}

}
