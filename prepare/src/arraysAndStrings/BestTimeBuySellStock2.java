package arraysAndStrings;

public class BestTimeBuySellStock2 {

	public static void main(String[] args) {
		int[] prices = { 1, 2, 3, 4, 5 };
		System.out.println(solveBrute(prices));
	}

	private static int solveBrute(int[] prices) {
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
