package mar01;

import java.util.Arrays;

public class MinimumTime {

	public static void main(String[] args) {
		int[] time = { 1, 2, 3, 4, 5, 6, 7 };
		int totalTrips = 55;
		System.out.println(solve(time, totalTrips));

	}

	private static long solve(int[] time, int totalTrips) {
		long min = 1;
		long max = 100000000000000L;
		while (min <= max) {
			long mid = min + (max - min) / 2;
			if (validate(time, mid, totalTrips)) {
				max = mid - 1;
			} else {
				min = mid + 1;
			}
		}
		return min;
	}

	private static boolean validate(int[] time, long mid, int trips) {
		long total = 0;
		for (int each : time) {
			total += mid / each;
		}
		return total >= trips;
	}

}
