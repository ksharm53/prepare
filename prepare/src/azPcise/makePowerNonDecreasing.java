package azPcise;

public class makePowerNonDecreasing {

	public static void main(String[] args) {
		int[] array = { 3, 2, 1 };
		System.out.println(solve(array));
	}

	private static int solve(int[] array) {
		int total = 0;

		if (array.length == 0) {
			return 0;
		}

		for (int i = 1; i < array.length; i++) {
			if (array[i] < array[i - 1]) {
				int diff = array[i - 1] - array[i];
				total += diff;
				int j = i;
				while (j < array.length) {
					array[j] += diff;
					j++;
				}
			}
		}
		return total;
	}

}
