package Oct13;

import java.util.HashMap;
import java.util.Map;

public class DivideAndConquer {

	public static void main(String[] args) {
		int[] ENERGY_LEVEL = { 100, 98, 96, 95 };
		Map<Integer, int[]> finalMap = splitAndFind(ENERGY_LEVEL, 0, ENERGY_LEVEL.length - 1);
		System.out.println("Test " + finalMap);
	}

	public static Map<Integer, int[]> splitAndFind(int[] prices, int lo, int hi) {
		Map<Integer, int[]> map = new HashMap<>();

		if (lo >= hi) {
			map.put(0, new int[] { lo, hi });
			return map;
		}
		int first = 0;
		int last = 0;
		int max = 0;

		int mid = (lo + hi) / 2;
		System.out.println(mid);

		Map<Integer, int[]> lProfit = splitAndFind(prices, lo, mid);

		Map<Integer, int[]> rProfit = splitAndFind(prices, mid + 1, hi);

		Map<Integer, int[]> cProfit = compareAndFind(prices, lo, mid, hi);

		int lp = lProfit.keySet().stream().findFirst().get();

		int rp = rProfit.keySet().stream().findFirst().get();

		if (lp > rp) {
			max = lp;
			first = lProfit.get(lp)[0];
			last = lProfit.get(lp)[1];
		} else {
			max = rp;
			first = rProfit.get(rp)[0];
			last = rProfit.get(rp)[1];
		}

		int val = cProfit.keySet().stream().findFirst().get();

		if (val > max) {
			first = cProfit.get(val)[0];
			last = cProfit.get(val)[1];
			max = val;
		}

		map.put(max, new int[] { first, last });

		return map;
	}

	public static Map<Integer, int[]> compareAndFind(int[] profit, int lo, int mid, int hi) {
		int minStock = profit[lo];
		int low = 0;
		int high = 0;
		Map<Integer, int[]> map = new HashMap<>();

		for (int i = lo + 1; i <= mid; i++) {
			if (profit[i] < minStock) {
				minStock = profit[i];
				low = i;
			}
		}

		int maxStock = 0;
		for (int i = mid + 1; i <= hi; i++) {
			if (profit[i] > maxStock) {
				maxStock = profit[i];
				high = i;
			}
		}
		map.put(maxStock - minStock, new int[] { low, high });
		return map;
	}

}
