package arraysAndStrings;

public class MaximumCandiesAllocatedKChildren {

	public static void main(String[] args) {
		int[] candies = { 4, 7, 5 };
		long k = 4;

		System.out.println(solve(candies, k));

	}

	private static int solve(int[] candies, long k) {
		long totalCandies = 0;
		int result = 0;
		int start = 1;

		for (int i : candies) {
			totalCandies = totalCandies + i;
			start = Math.min(start, i);
		}

		if (totalCandies < k) {
			return 0;
		}

		while (start <= totalCandies) {
			long mid = start + (totalCandies - start) / 2;

			if (validate(candies, k, mid)) {
				result = (int) mid;
				start = (int) mid + 1;
			} else {
				totalCandies = mid - 1;
			}
		}
		return result;
	}

	private static boolean validate(int[] candies, long k, long mid) {

		for (int i : candies) {
			int value = i / (int) mid;
			k = k - value;
			if (k <= 0) {
				return true;
			}
		}

		return false;
	}

}
