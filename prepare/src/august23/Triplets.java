package august23;

import java.util.Arrays;

public class Triplets {

	public static void main(String[] args) {
		int[] d = { 1, 2, 3, 4, 6 };
		int t = 8;
		System.out.println(solve(d, t));

	}

	private static int solve(int[] d, int t) {
		Arrays.sort(d);

		int sum = 0;
		int counter = 0;
		for (int i = 0; i < d.length - 2; i++) {
			int first = i;
			int second = i + 1;
			int third = d.length - 1;

			while (second < third) {
				sum = d[first] + d[second] + d[third];
				if (sum <= t) {
					counter += (third - second);
					second++;
				} else if (sum > t) {
					third--;
				}
			}

		}
		return counter;
	}

}
