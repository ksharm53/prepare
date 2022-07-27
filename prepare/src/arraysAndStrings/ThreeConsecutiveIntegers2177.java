package arraysAndStrings;

public class ThreeConsecutiveIntegers2177 {

	public static void main(String[] args) {
		long num = 4;

		long[] result = solve(num);
		System.out.println("Test" + result);

	}

	private static long[] solve(long num) {
		if (num == 0) {
			return new long[] { -1, 0, 1 };
		}

		if (num % 3 == 0) {
			long mid = num / 3;
			return new long[] { mid - 1, mid, mid + 1 };
		} else {
			return new long[] {};
		}
	}

}
