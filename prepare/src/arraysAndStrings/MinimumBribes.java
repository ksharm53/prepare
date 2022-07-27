package arraysAndStrings;

import java.util.Arrays;
import java.util.List;

public class MinimumBribes {

	public static void main(String[] args) {
		List<Integer> q = Arrays.asList(1, 2, 5, 3, 7, 8, 6, 4);
		int value = solve(q);
		if (value == Integer.MAX_VALUE) {
			System.out.println("Too chaotic");
		} else {
			System.out.println(value);
		}

	}

	private static int solve(List<Integer> q) {
		int counter = 0;
		for (int i = 0; i < q.size(); i++) {
			int value = q.get(i) - 1 - i;
			if (value > 2) {
				return Integer.MAX_VALUE;
			}
			for (int j = Math.max(0, q.get(i) - 2); j < i; j++) {
				if (q.get(j) > q.get(i)) {
					counter++;
				}
			}
		}
		return counter;
	}

}
