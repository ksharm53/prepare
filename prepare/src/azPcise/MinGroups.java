package azPcise;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MinGroups {

	public static void main(String[] args) {
		List<Integer> awards = Arrays.asList(3, 1, 4, 3, 9);
		int k = 10;

		System.out.println(solve(awards, k));

	}

	private static int solve(List<Integer> awards, int k) {
		if (awards.size() == 0) {
			return 0;
		}
		Collections.sort(awards);

		int i = 0;
		int j = 0;
		int initialSum = 0;
		int group = 1;

		while (j < awards.size()) {
			initialSum = awards.get(j) - awards.get(i);
			if (initialSum < k) {
				j++;
			} else if (initialSum == k) {
				group++;
				initialSum = 0;
				j++;
				i = j;
			} else if (initialSum > k) {
				initialSum = 0;
				group++;
				i = j;
				j++;
			}
		}
		return group;
	}

}
