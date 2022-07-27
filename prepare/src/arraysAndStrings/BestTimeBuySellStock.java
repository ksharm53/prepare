package arraysAndStrings;

public class BestTimeBuySellStock {

	public static void main(String[] args) {
		int[] prices = {7,1,5,3,6,4};
		System.out.println(solveBrute(prices));
		System.out.println(solveIntution(prices));
	}

	private static int solveBrute(int[] prices) {
		int maxProfit = 0;

		if (prices.length <= 1) {
			return 0;
		}

		for (int i = 0; i < prices.length; i++) {
			for (int j = i + 1; j < prices.length; j++) {
				int value = prices[j] - prices[i];
				if (value <= 0) {
					continue;
				} else {
					maxProfit = Math.max(maxProfit, value);
				}
			}
		}

		return maxProfit;
	}

	private static int solveIntution(int[] prices) {
		int maxProfit = 0;
		int leastSoFar = Integer.MAX_VALUE;

		if (prices.length <= 1) {
			return 0;
		}

		for (int i = 0; i < prices.length; i++) {
			if (prices[i] < leastSoFar) {
				leastSoFar = prices[i];
			}
			maxProfit = Math.max(maxProfit, prices[i] - leastSoFar);
		}
		return maxProfit;

	}

}
