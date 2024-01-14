package oct2023;

public class NumberOfMatches {

	public static void main(String[] args) {
		int n = 32;
		System.out.println(solve(n));

	}

	private static int solve(int n) {
		int count = 0;
		while (n > 1) {
			if (n % 2 == 0) {
				count += n / 2;
				n /= 2;
			} else {
				count += n / 2;
				n = (n / 2) + 1;
			}
		}

		return count;
	}

}
