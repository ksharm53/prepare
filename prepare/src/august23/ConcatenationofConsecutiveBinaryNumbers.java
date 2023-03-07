package august23;

public class ConcatenationofConsecutiveBinaryNumbers {

	public static void main(String[] args) {
		int n = 42;
		System.out.println(solve(n));

	}

	private static int solve(int n) {
		int mod = 1000000007;
		long sum = 0;
		long counter = 0;
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= n; i++) {
			sb.append(Integer.toBinaryString(i));
		}

		for (int i = sb.length() - 1; i >= 0; i--) {
			char each = sb.charAt(i);
			sum += Character.getNumericValue(each) * Math.pow(2, counter);
			sum = sum % mod;
			counter++;
		}
		return (int) (sum % mod);
	}

}
