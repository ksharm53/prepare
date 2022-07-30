package misc;

public class SubtractProductandSum {

	public static void main(String[] args) {
		int n = 4421;

		System.out.println(solve(n));
	}

	private static int solve(int n) {
		long product = 1;
		long sum = 0;
		while (n > 0) {
			int remainder = n % 10;
			product = product * remainder;
			sum = sum + remainder;
			n = n / 10;
		}
		long result = product - sum;
		return (int) result;
	}

}
