package oct2023;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ExamIBM {

	public static void main(String[] args) {
		long n = 6;
		List<List<Integer>> queries = Arrays.asList(Arrays.asList(1, 2, 4), Arrays.asList(2, 2, 8),
				Arrays.asList(1, 1, 4));

		List<Integer> results = getQueryResults(n, queries);
		System.out.println("Results: " + results);

	}

	public static List<Integer> getQueryResults(long n, List<List<Integer>> queries) {
		List<Integer> results = new ArrayList<>();
		List<Integer> goodArray = findGoodArray(n);
		Collections.sort(goodArray);

		for (List<Integer> query : queries) {
			int l = query.get(0);
			int r = query.get(1);
			int m = query.get(2);

			long product = calculateProduct(goodArray, l, r, m);

			results.add((int) product);
		}

		return results;
	}

	private static List<Integer> findGoodArray(long n) {
		List<Integer> goodArray = new ArrayList<>();

		int maxPower = 0;
		while ((1L << (maxPower + 1)) - 1 <= n) {
			maxPower++;
		}

		for (int power = maxPower; power >= 0; power--) {
			long currentPower = 1L << power;
			if (currentPower <= n) {
				goodArray.add((int) currentPower);
				n -= currentPower;
			}
		}

		return goodArray;
	}

	private static long calculateProduct(List<Integer> array, int l, int r, int m) {
		long product = 1;

		for (int i = l; i <= r; i++) {
			product *= array.get(i - 1);
			product %= m;
		}

		return (product % m);
	}

}
