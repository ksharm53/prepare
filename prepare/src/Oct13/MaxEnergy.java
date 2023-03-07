package Oct13;

import java.util.ArrayList;
import java.util.List;

public class MaxEnergy {

	public static void main(String[] args) {
		int[] array = { 100, 113, 110, 85, 105, 102, 86, 63, 81, 101, 94, 106, 101, 79, 94, 90, 97 };
		System.out.println(solveIntution(array));

	}

	private static List<Integer> solveIntution(int[] prices) {
		if (prices.length <= 1) {
			return new ArrayList<>();
		}
		int first = 0;
		int last = 0;

		int maxProfitValue = Integer.MIN_VALUE;
		int[] leastSoFar = { Integer.MAX_VALUE, -1 };
		List<int[]> leastArray = new ArrayList<>();

		for (int i = 0; i < prices.length; i++) {
			if (leastSoFar[0] > prices[i]) {
				leastSoFar[0] = prices[i];
				leastSoFar[1] = i;
			}
			leastArray.add(new int[] { leastSoFar[0], leastSoFar[1] });

		}

		for (int i = 0; i < prices.length; i++) {
			if (prices[i] == leastArray.get(i)[0]) {
				if (i - 1 < 0) {
					if (maxProfitValue < prices[i] - Integer.MAX_VALUE) {
						maxProfitValue = prices[i] - Integer.MAX_VALUE;
						first = 0;
						last = i;
					}

				} else {
					if (maxProfitValue < prices[i] - leastArray.get(i - 1)[0]) {
						maxProfitValue = prices[i] - leastArray.get(i - 1)[0];
						first = leastArray.get(i - 1)[1];
						last = i;
					}

				}

			} else {
				if (maxProfitValue < prices[i] - leastArray.get(i)[0]) {
					maxProfitValue = prices[i] - leastArray.get(i)[0];
					first = leastArray.get(i)[1];
					last = i;
				}

			}

		}

		List<Integer> list = new ArrayList<>();
		list.add(first);
		list.add(last);
		return list;
	}

}
