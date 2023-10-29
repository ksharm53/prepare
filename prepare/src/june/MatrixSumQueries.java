package june;

import java.util.HashMap;
import java.util.Map;

public class MatrixSumQueries {

	public static void main(String[] args) {
		int n = 3;
		int[][] queries = { { 0, 0, 4 }, { 0, 1, 2 }, { 1, 0, 1 }, { 0, 2, 3 }, { 1, 2, 1 } };

		System.out.println(solve(n, queries));

	}

	private static long solve(int n, int[][] queries) {
		Map<Integer, int[]> rowMap = new HashMap<>();
		for (int i = 0; i < n; i++) {
			int[] list = rowMap.getOrDefault(i, new int[n]);
			rowMap.put(i, list);
		}

		long sum = 0;

		for (int[] each : queries) {
			if (each[0] == 0) {
				int[] list = rowMap.get(each[1]);
				for (int i = 0; i < list.length; i++) {
					list[i] = each[2];
				}
				rowMap.put(each[1], list);

			} else {
				for (int eachKey : rowMap.keySet()) {
					int[] list = rowMap.get(eachKey);
					list[each[1]] = each[2];
				}
			}
		}

		for (int eachKey : rowMap.keySet()) {
			int[] list = rowMap.get(eachKey);
			for (int is : list) {
				sum += is;
			}
		}

		return sum;
	}

}
