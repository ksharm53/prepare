package azPcise;

import java.util.Arrays;
import java.util.List;

public class MaxValue {

	public static void main(String[] args) {
		List<List<Integer>> list = Arrays.asList(Arrays.asList(1, 2, 10), Arrays.asList(2, 4, 5),
				Arrays.asList(3, 5, 12));

		int n = 5;

		System.out.println(solve(list, n));

	}

	private static int solve(List<List<Integer>> list, int n) {
		int[] array = new int[n + 1];
		int max = Integer.MIN_VALUE;

		for (List<Integer> eachList : list) {
			int start = eachList.get(0);
			int end = eachList.get(1);
			int value = eachList.get(2);

			for (int j = start; j <= end; j++) {
				array[j] += value;
			}
		}
		for (int i : array) {
			max = Math.max(max, i);
		}
		return max;
	}

}
