package airport;

import java.util.Arrays;

public class MinimumNumberofArrowstoBurstBalloons {

	public static void main(String[] args) {
		int[][] arr = { { -2147483646, -2147483645 }, { 2147483646, 2147483647 } };
		System.out.println(solve(arr));

	}

	private static int solve(int[][] arr) {
		int count = 0;
		if (arr.length == 1) {
			return 1;
		}
		Arrays.sort(arr, (a, b) -> Integer.compare(a[1], b[1]));

		int i = 0;
		while (i < arr.length) {
			int j = i;
			while (i + 1 < arr.length && arr[j][1] >= arr[i + 1][0]) {
				i++;
			}
			count++;
			i++;
		}

		return count;
	}

}
