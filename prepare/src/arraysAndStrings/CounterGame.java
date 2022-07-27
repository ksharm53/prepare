package arraysAndStrings;

public class CounterGame {
	static int counter;

	public static void main(String[] args) {
		long n = 132;
		counter = 0;
		solve(n);
		if (counter % 2 == 0) {
			System.out.println("Richard");
		} else {
			System.out.println("Louise");
		}

	}

	private static int solve(long n) {
		if (n <= 1) {
			return counter;
		}
		counter = counter + 1;
		int exp = Math.getExponent(n);
		if (n == (long) Math.pow(2, exp)) {
			n = n / 2;
		} else {
			n = n - (long) Math.pow(2, exp);
		}
		return solve(n);
	}

}
