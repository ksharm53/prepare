package nov13;

public class MinimizedMaximumofProductsDistributedtoAnyStore {

	public static void main(String[] args) {
		int n = 1;
		int[] quantities = { 100000 };
		System.out.println(solve(n, quantities));

	}

	private static int solve(int n, int[] quantities) {
		int max = Integer.MIN_VALUE;
		for (int each : quantities) {
			max = Math.max(max, each);
		}

		int min = 1;

		while (min <= max) {
			int mid = min + (max - min) / 2;

			if (validate(mid, quantities, n)) {
				min = mid + 1;

			} else {
				max = mid - 1;
			}
		}
		return min;
	}

	private static boolean validate(int mid, int[] quantities, int n) {
		int temp = n;
		for (int i = 0; i < quantities.length; i++) {
			int each = quantities[i];
			temp -= each / mid;
			if (each % mid > 0) {
				temp -= 1;
			}

			if (temp < 0) {
				return true;
			}
		}
		if (temp >= 0) {
			return false;
		} else {
			return true;
		}
	}

	public static int minimizedMaximum(int n, int[] quantities) {
		int max = 0;
		for (int q : quantities) {
			max = Math.max(max, q);
		}
		int l = 1, r = max;
		while (l <= r) {
			int m = l + (r - l) / 2;
			int cnt = count(m, quantities);
			if (cnt > n) {
				l = m + 1;
			} else if (cnt < n) {
				r = m - 1;
			} else {
				r = m - 1;
			}
		}
		return l;
	}

	private static int count(int div, int[] quantities) {
		int res = 0;
		for (int q : quantities) {
			res += q / div + (q % div == 0 ? 0 : 1);
		}
		return res;
	}

}
