package newBeginning;

public class MaxScoreSightseeingPair {

	public static void main(String[] args) {
		int[] values = { 1, 2 };
		System.out.println(solve(values));
		System.out.println(solveOptimized(values));

	}

	private static int solveOptimized(int[] values) {
		if (values.length == 0) {
			return 0;
		}
		int maxVal = Integer.MIN_VALUE;
		int[] array = new int[values.length];
		int maxPrefix = Integer.MIN_VALUE;

		for (int i = 0; i < values.length; i++) {
			maxPrefix = Math.max(maxPrefix, values[i] + i);
			array[i] = maxPrefix;
		}

		for (int i = 0; i < array.length - 1; i++) {
			maxVal = Math.max(maxVal, array[i] + values[i + 1] - (i + 1));
		}

		return maxVal;
	}

	private static int solve(int[] values) {
		if (values.length == 0) {
			return 0;
		}
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < values.length; i++) {
			for (int j = i + 1; j < values.length; j++) {
				int value = values[i] + values[j] + i - j;
				max = Math.max(max, value);
			}
		}
		return max;
	}

}
