package august23;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Queries {

	public static void main(String[] args) {
		int[] a = { 1, 2, 3 };
		int[] b = { 1, 4 };
		int[][] queries = { { 1, 5 }, { 0, 0, 2 }, { 1, 5 } };
		System.out.println(solve(a, b, queries));
	}

	private static int[] solve(int[] a, int[] b, int[][] queries) {

		List<Integer> bList = new ArrayList<>(IntStream.of(b).boxed().toList());
		List<Integer> list = new ArrayList<>();

		for (int i = 0; i < queries.length; i++) {
			int[] eachQuery = queries[i];
			if (eachQuery.length == 3) {
				int index = eachQuery[1];
				int prevValue = bList.get(index);
				bList.remove(index);
				bList.add(index, prevValue + eachQuery[2]);
			} else if (eachQuery.length == 2) {
				int value = eachQuery[1];
				int counter = 0;
				for (int j = 0; j < a.length; j++) {
					int diff = Math.abs(value - a[j]);
					if (bList.contains(diff)) {
						counter++;
					}
				}
				list.add(counter);
			}

		}

		int[] result = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			result[i] = list.get(i);
		}
		return result;
	}

}
