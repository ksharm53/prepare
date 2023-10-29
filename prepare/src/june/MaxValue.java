package june;

public class MaxValue {

	public static void main(String[] args) {
		int n = 8257285;
		int index = 4828516;
		int maxSum = 850015631;

		System.out.println(solve(n, index, maxSum));

	}

	private static int solve(int n, int index, int maxSum) {
		int start = 1;
		int end = maxSum;

		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (validate(mid, index, n, maxSum)) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}

		return end;

	}

	private static boolean validate(int mid, int index, int n, int maxSum) {
		int leftSpace = index;
		int rightSpace = (n - index - 1);

		long sum = 0;

		long leftSum = 0;
		long rightSum = 0;

		// do left
		if (leftSpace >= mid - 1) {
			leftSum += (mid * (mid + 1)) / 2;
			leftSpace -= mid - 1;
			leftSum += leftSpace;
		} else {
			int shift = mid - 1 - leftSpace;
			int startPoint = 1 + shift;
			long nBy2 = (leftSpace + 1);
			long twoA = 2 * startPoint;
			long nminusOne = leftSpace;

			leftSum += (nBy2 * (twoA + nminusOne)) / 2;
		}

		if (leftSum > 0) {
			sum += leftSum;
		}

		// do right

		if (rightSpace >= mid - 1) {
			rightSum += (mid * (mid + 1) / 2);
			rightSpace -= mid - 1;
			rightSum += rightSpace;
		} else {
			int shift = mid - 1 - rightSpace;
			int startPoint = 1 + shift;
			long nBy2 = (rightSpace + 1);
			long twoA = 2 * startPoint;
			long nminusOne = rightSpace;

			rightSum += (nBy2 * (twoA + nminusOne)) / 2;
		}

		if (rightSum > 0) {
			sum += rightSum;
		}

		if (leftSum > 0 && rightSum > 0) {
			sum -= mid;
		}

		return sum <= maxSum;
	}

}
