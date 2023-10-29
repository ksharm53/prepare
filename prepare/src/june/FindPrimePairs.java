package june;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindPrimePairs {

	public static void main(String[] args) {
		int n = 999931;
		System.out.println(solve(n));

	}

	private static List<List<Integer>> solve(int n) {
		List<List<Integer>> res = new ArrayList<>();
		boolean isPrimeVal[] = isPrime(n);

		for (int i = 2; i <= n / 2; i++) {
			if (isPrimeVal[i] && isPrimeVal[n - i]) {
				res.add(List.of(i, n - i));
			}
		}
		return res;
	}

	static boolean[] isPrime(int n) {
		boolean[] res = new boolean[n + 1];
		Arrays.fill(res, true);
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (res[i] == true) {
				for (int j = i * i; j <= n; j += i)
					res[j] = false;
			}
		}

		return res;
	}

}
