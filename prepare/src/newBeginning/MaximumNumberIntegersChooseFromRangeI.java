package newBeginning;

import java.util.Arrays;

public class MaximumNumberIntegersChooseFromRangeI {

	public static void main(String[] args) {
		int[] banned = { 11 };
		int n = 7;
		int maxSum = 50;
		System.out.println(solve(banned, n, maxSum));

	}

	private static int solve(int[] banned, int n, int maxSum) {
		Arrays.sort(banned);
		int sum = 0;
		int count = 0;
		for (int i = 1; i <= n; i++) {
			if ((sum + i <= maxSum) && !binarySearch(banned, i)) {
				sum += i;
				count++;
			}

		}
		return count;
	}

	private static boolean binarySearch(int[] banned, int i) {
		int start = 0;
		int end = banned.length - 1;

		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (banned[mid] == i) {
				return true;
			} else if (banned[mid] < i) {
				start = mid + 1;
			} else if (banned[mid] > i) {
				end = mid - 1;
			}
		}
		return false;
	}

}
