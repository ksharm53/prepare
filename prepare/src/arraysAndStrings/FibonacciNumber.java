package arraysAndStrings;

public class FibonacciNumber {

	public static void main(String[] args) {
		int n = 30;

		System.out.println(solve(n));

	}

	private static int solve(int n) {
		if (n == 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		}

		return solve(n - 1) + solve(n - 2);
	}

}
