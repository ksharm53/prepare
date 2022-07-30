package arrays;

import java.util.Arrays;
import java.util.List;

public class MaximumSubArraySum {

	public static void main(String[] args) {
		List<Long> a = Arrays.asList(1L, 2L, 3L);
		long m = 2;

		System.out.println(solve(a, m));

	}

	private static long solve(List<Long> a, long m) {

		if (a.size() == 0) {
			return 0;
		}

		long maxMod = Long.MIN_VALUE;
		long localMax = 0;
		long totalMax = Long.MIN_VALUE;
		for (int i = 0; i < a.size(); i++) {
			localMax = Math.max(localMax + a.get(i), a.get(i));
			maxMod = Math.max(maxMod, Math.max(a.get(i) % m, localMax % m));
			totalMax = Math.max(totalMax, localMax);
		}
		return maxMod;
	}

}
