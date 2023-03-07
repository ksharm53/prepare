package TikTok;

import java.util.ArrayList;
import java.util.List;

public class PrefixScore {

	public static void main(String[] args) {
		int n = 3;
		int[] arr = { 1, 2, 3 };
		System.out.println(solve(n, arr));
	}

	private static List<Integer> solve(int n, int[] arr) {

		List<Integer> result = new ArrayList<>();
		int max = 0;
		int mod = 1000000007;
		int sum = 0;
		int outerSum = 0;

		for (int i = 0; i < n; ++i) {
			sum += arr[i];
			sum = sum % mod;
			outerSum += sum;
			outerSum = outerSum % mod;
			max = Math.max(max, arr[i]);
			long val = (outerSum + 1L * max * (i + 1)) % mod;
			result.add((int) val);
		}
		return result;

	}

}
