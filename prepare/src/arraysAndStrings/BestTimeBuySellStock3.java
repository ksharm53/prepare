package arraysAndStrings;

public class BestTimeBuySellStock3 {

	public static void main(String[] args) {
		int[] prices = { 1, 2 };
		System.out.println(solveBrute(prices));
	}

	private static int solveBrute(int[] prices) {
		int maxProfit = Integer.MIN_VALUE;
		int local = 0;
		boolean flag = false;

		if (prices.length <= 1) {
			return 0;
		}
		for (int i = 0; i < prices.length; i++) {
			local = 0;
			int j = i;
			while (j < prices.length - 1) {
				if (flag) {
					flag = false;
				} else {
					int value = prices[j + 1] - prices[j];
					if (value > 0) {
						flag = true;
						local = local + value;
					}
				}
				j++;
			}
			maxProfit = Math.max(local, maxProfit);
		}

		return maxProfit;
	}

}
