package newBeginning;

public class MaxContiguousSumArray {

	public static void main(String[] args) {
		int[] A = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		System.out.println(solve(A));
	}

	private static int solve(int[] a) {
		if (a.length == 0) {
			return 0;
		}
		int maxPrevious = 0;
		int finalMax = Integer.MIN_VALUE;
		for (int i = 0; i < a.length; i++) {
			int current = a[i];
			maxPrevious = Math.max(current, current + maxPrevious);
			finalMax = Math.max(finalMax, maxPrevious);
		}
		return finalMax;
	}

}
