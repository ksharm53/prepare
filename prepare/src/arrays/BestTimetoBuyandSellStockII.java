package arrays;

public class BestTimetoBuyandSellStockII {

	public static void main(String[] args) {
		int[] prices = { 7, 1, 5, 3, 6, 4 };
		System.out.println(solve(prices, 0, prices.length - 1));
	}

	private static int solve(int[] prices, int start, int length) {

		int maxProfit = 0;

		if (prices.length <= 1) {
			return 0;
		}

		for (int i = 0; i < prices.length - 1; i++) {
			int value = prices[i + 1] - prices[i];
			if (value <= 0) {
				continue;
			} else {
				maxProfit = maxProfit + value;
			}
		}

		return maxProfit;

	}

}
