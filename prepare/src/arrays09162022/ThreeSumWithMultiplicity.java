package arrays09162022;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ThreeSumWithMultiplicity {

	public static void main(String[] args) {
		int[] arr = { 0, 0, 0 };
		int target = 0;
		System.out.println(solve(arr, target));
		System.out.println(threeSumMulti(arr, target));
	}

	private static int solve(int[] arr, int target) {
		Arrays.sort(arr);
		Map<Integer, Integer> map = new HashMap<>();

		for (int i : arr) {
			map.put(i, map.getOrDefault(i, 0) + 1);
		}

		int counter = 0;

		for (int i = 0; i + 2 < arr.length; i++) {
			int first = i;
			int second = i + 1;
			int last = arr.length - 1;

			while (second < last) {
				int sum = arr[first] + arr[second] + arr[last];
				if (sum == target) {
					if (arr[second] != arr[last]) {
						int counterLeft = 1;
						int counterRight = 1;
						while (second < arr.length && arr[second] == arr[second + 1]) {
							counterLeft++;
							second++;
						}

						while (last >= 0 && arr[last] == arr[last - 1]) {
							counterRight++;
							last--;
						}

						counter += counterLeft * counterRight;

					} else {
						int value = map.get(arr[second]);
						counter += (value * (value - 1)) / 2;
						break;
					}
					second++;
					last--;
				} else if (sum < target) {
					second++;
				} else if (sum > target) {
					last--;
				}
			}

		}
		return counter;
	}

	public static int threeSumMulti(int[] A, int target) {
		int MOD = 1_000_000_007;
		long ans = 0;
		Arrays.sort(A);

		for (int i = 0; i < A.length; ++i) {
			int T = target - A[i];
			int j = i + 1, k = A.length - 1;

			while (j < k) {
				// These steps proceed as in a typical two-sum.
				if (A[j] + A[k] < T)
					j++;
				else if (A[j] + A[k] > T)
					k--;
				else if (A[j] != A[k]) { // We have A[j] + A[k] == T.
					// Let's count "left": the number of A[j] == A[j+1] == A[j+2] == ...
					// And similarly for "right".
					int left = 1, right = 1;
					while (j + 1 < k && A[j] == A[j + 1]) {
						left++;
						j++;
					}
					while (k - 1 > j && A[k] == A[k - 1]) {
						right++;
						k--;
					}

					ans += left * right;
					ans %= MOD;
					j++;
					k--;
				} else {
					// M = k - j + 1
					// We contributed M * (M-1) / 2 pairs.
					ans += (k - j + 1) * (k - j) / 2;
					ans %= MOD;
					break;
				}
			}
		}

		return (int) ans;
	}

}
