package misc;

import java.math.BigInteger;
import java.util.Arrays;

public class ExtraLongFactorials {
	static BigInteger[] matrix;

	public static void main(String[] args) {
		int n = 25;
		matrix = new BigInteger[n + 1];
		Arrays.fill(matrix, BigInteger.valueOf(-1));

		System.out.println(solve(n));

	}

	public static BigInteger solve(int n) {
		if (n < 2) {
			return matrix[n] = BigInteger.valueOf(n);
		}

		if (matrix[n] != BigInteger.valueOf(-1)) {
			return matrix[n];
		}

		BigInteger last = solve(n - 1);
		return matrix[n] = last.multiply(BigInteger.valueOf(n));
	}

}
