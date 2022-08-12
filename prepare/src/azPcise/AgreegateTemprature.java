package azPcise;

public class AgreegateTemprature {

	public static void main(String[] args) {
		int[] value = { 6, -2, 5 };
		System.out.println(solve(value));
	}

	private static int solve(int[] value) {
		int total = 0;
		int sum = 0;
		int maxValue = Integer.MIN_VALUE;
		for (int i : value) {
			total += i;
		}

		for (int i = 0; i < value.length; i++) {
			sum = sum + value[i];
			int eachMax = Math.max(sum, total - sum + value[i]);
			maxValue = Math.max(maxValue, eachMax);
		}
		return maxValue;
	}

}
