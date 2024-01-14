package oct2023;

public class CountTestedDevices {

	public static void main(String[] args) {
		int[] batteryPercentages = { 1, 1, 2, 1, 3 };
		System.out.println(solve(batteryPercentages));
	}

	private static int solve(int[] batteryPercentages) {
		int count = 0;
		int decrement = 0;
		for (int i = 0; i < batteryPercentages.length; i++) {
			if (batteryPercentages[i] - decrement > 0) {
				count++;
				decrement++;
			}
		}
		return count;
	}

}
