package Oct13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RangeProductQueriesofPowers {

	public static void main(String[] args) {
		int n = 919;
		int[][] queries = { { 5, 5 }, { 4, 4 }, { 0, 1 }, { 1, 5 }, { 4, 6 }, { 6, 6 }, { 5, 6 }, { 0, 3 }, { 5, 5 },
				{ 5, 6 }, { 1, 2 }, { 3, 5 }, { 3, 6 }, { 5, 5 }, { 4, 4 }, { 1, 1 }, { 2, 4 }, { 4, 5 }, { 4, 4 },
				{ 5, 6 }, { 0, 4 }, { 3, 3 }, { 0, 4 }, { 0, 5 }, { 4, 4 }, { 5, 5 }, { 4, 6 }, { 4, 5 }, { 0, 4 },
				{ 6, 6 }, { 6, 6 }, { 6, 6 }, { 2, 2 }, { 0, 5 }, { 1, 4 }, { 0, 3 }, { 2, 4 }, { 5, 5 }, { 6, 6 },
				{ 2, 2 }, { 2, 3 }, { 5, 5 }, { 0, 6 }, { 3, 3 }, { 6, 6 }, { 4, 4 }, { 0, 0 }, { 0, 2 }, { 6, 6 },
				{ 6, 6 }, { 3, 6 }, { 0, 4 }, { 6, 6 }, { 2, 2 }, { 4, 6 } };

		solve(n, queries);

	}

	private static int[] solve(int n, int[][] queries) {
		int[] array = new int[queries.length];
		double sqrt = Math.sqrt(n);
		List<Integer> list = new ArrayList<>();
		List<Integer> temp = new ArrayList<>();

		for (int i = 0; i <= sqrt; i++) {
			list.add((int) Math.pow(2, i));
		}

		int tempSum = 0;
		for (int i = list.size() - 1; i >= 0; i--) {
			tempSum += list.get(i);
			if (tempSum <= n) {
				temp.add(list.get(i));
			} else {
				tempSum -= list.get(i);
			}
		}
		Collections.sort(temp);
		for (int i = 0; i < queries.length; i++) {
			int[] cur = queries[i];
			long prod = 1l;
			for (int j = cur[0]; j <= cur[1]; j++) {
				prod = prod * temp.get(j);
			}
			array[i] = (int) prod % 1000000007;
		}
		return array;
	}

}
