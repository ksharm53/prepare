package dec;

public class MyPow {

	public static void main(String[] args) {
		double x = 1.0000000000001;
		int n = -2147483648;
		System.out.println(solve(x, (long) n));
	}

	private static double solve(double x, long n) {
		double val = x;
		if (x == -1 && n % 2 == 0) {
			return 1;
		} else if (x == -1 && n % 2 != 0) {
			return -1;
		}

		if (n == 1) {
			return x;
		} else if (n == -1) {
			return 1 / x;
		}

		if (n == 0 || x == 1) {
			return 1;
		} else {
			x = x * x;
			long count = 2;
			long modN = n < 0 ? (n * -1) : n;
			while ((count * 2) < modN) {
				x = x * x;
				count *= 2;
			}

			while (count < modN) {
				x = x * val;
				count++;
			}
			if (n > 0) {
				return x;
			} else {
				return (double) 1 / x;
			}

		}
	}

}
