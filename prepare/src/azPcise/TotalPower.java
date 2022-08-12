package azPcise;

public class TotalPower {

	public static void main(String[] args) {
		int[] power = { 2, 3, 2, 1 };
		System.out.println(solve(power));
	}

	private static int solve(int[] power) {
		int mod = 1000000007;
		int result = 0;

		for (int i = 0; i < power.length; i++) {
			int totalEachSubSet = 0;
			int min = Integer.MAX_VALUE;
			int sum = 0;
			for (int j = i; j < power.length; j++) {
				min = Math.min(min, power[j]);
				sum += power[j];
				totalEachSubSet += (min * sum) % mod;
			}
			result += totalEachSubSet;

		}
		return result % mod;
	}

}
