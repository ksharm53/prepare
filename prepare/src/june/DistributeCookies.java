package june;

public class DistributeCookies {

	static int min;

	public static void main(String[] args) {
		int[] cookies = { 6, 1, 3, 2, 2, 4, 1, 2 };
		int k = 3;
		int[] sumCookies = new int[k];
		int max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;

		if (k == cookies.length) {
			for (int each : cookies) {
				max = Math.max(max, each);
			}
			System.out.println(max);
		} else {
			solve(cookies, k, sumCookies, 0);
			System.out.println(min);
		}

	}

	private static void solve(int[] cookies, int k, int[] sumCookies, int idx) {
		if (idx >= cookies.length) {
			int max = Integer.MIN_VALUE;
			for (int each : sumCookies) {
				max = Math.max(max, each);
			}
			min = Math.min(min, max);
			return;
		}

		for (int i = 0; i < sumCookies.length; i++) {
			sumCookies[i] += cookies[idx];
			solve(cookies, k, sumCookies, idx + 1);
			sumCookies[i] -= cookies[idx];
		}

	}

}
