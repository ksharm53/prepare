package azPcise;

public class GetHeaviest {

	public static void main(String[] args) {
		int[] weights = { 2, 9, 10, 3, 7 };
		System.out.println(solve(weights));

	}

	private static int solve(int[] weights) {
		if (weights.length == 0) {
			return 0;
		}
		int maxWeight = Integer.MIN_VALUE;

		for (int i = weights.length - 2; i >= 0; i--) {
			if (weights[i] < weights[i + 1]) {
				weights[i] += weights[i + 1];
			}
			maxWeight = Math.max(maxWeight, weights[i]);
		}
		return maxWeight;
	}

}
