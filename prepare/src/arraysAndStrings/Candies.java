package arraysAndStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Candies {

	public static void main(String[] args) {

		List<Integer> list = new ArrayList<>();
		for (int i = 100000; i > 0; i--) {
			list.add(i);
		}

		System.out.println(solve(list));
	}

	private static long solve(List<Integer> list) {
		int[] listCandies = new int[list.size()];
		Arrays.fill(listCandies, 1);

		for (int i = 1; i < list.size(); i++) {
			if (list.get(i) > list.get(i - 1)) {
				listCandies[i] = listCandies[i - 1] + 1;
				// isChanged = true;
			}
		}

		for (int i = list.size() - 2; i >= 0; i--) {
			if (list.get(i) > list.get(i + 1) && listCandies[i] <= listCandies[i + 1]) {
				listCandies[i] = listCandies[i + 1] + 1;
			}
		}
		long sum = 0;
		for (int c : listCandies) {
			sum += c;
		}
		return sum;

	}

}
