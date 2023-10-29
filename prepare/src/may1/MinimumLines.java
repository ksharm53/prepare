package may1;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Arrays;
import java.util.Comparator;

public class MinimumLines {

	public static void main(String[] args) {
		int[][] stockPrices = { { 1, 1 } };
		System.out.println(solve(stockPrices));

	}

	private static int solve(int[][] stockPrices) {
		int count = 0;

		Arrays.sort(stockPrices, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});

		if (stockPrices.length == 1) {
			return 1;
		}

		BigDecimal lastSlope = new BigDecimal(-1);

		for (int i = 0; i < stockPrices.length - 1; i++) {
			int[] first = stockPrices[i];
			int[] second = stockPrices[i + 1];
			BigDecimal y = new BigDecimal(second[1] - first[1]);
			BigDecimal x = new BigDecimal(second[0] - first[0]);

			BigDecimal slope = y.divide(x, MathContext.DECIMAL128);

			if (i == 0 || !lastSlope.equals(slope)) {
				count++;
				lastSlope = slope;
			}
		}
		return count;
	}

}
