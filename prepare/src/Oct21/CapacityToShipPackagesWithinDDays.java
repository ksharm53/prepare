package Oct21;

public class CapacityToShipPackagesWithinDDays {

	public static void main(String[] args) {
		int[] weights = { 1, 2, 3, 1, 1 };
		int days = 4;
		System.out.println(solve(weights, days));

	}

	private static int solve(int[] weights, int days) {
		int min = Integer.MIN_VALUE;
		int max = 0;

		for (int i : weights) {
			min = Math.max(min, i);
			max += i;
		}

		while (min <= max) {
			int mid = min + (max - min) / 2;

			if (validate(mid, weights, days)) {
				max = mid - 1;
			} else {
				min = mid + 1;
			}
		}
		return min;
	}

	private static boolean validate(int mid, int[] weights, int days) {
		int daysNeeded = 1;
		int capacity = mid;
		for (int i = 0; i < weights.length; i++) {
			int eachWeight = weights[i];
			capacity -= eachWeight;
			if (capacity < 0) {
				daysNeeded++;
				if (daysNeeded > days) {
					return false;
				}
				capacity = mid;
				i--;
			}
		}
		return true;
	}

}
