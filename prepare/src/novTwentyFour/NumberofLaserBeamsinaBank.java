package novTwentyFour;

public class NumberofLaserBeamsinaBank {

	public static void main(String[] args) {
		String[] bank = { "000", "111", "000" };
		System.out.println(solve(bank));
	}

	private static int solve(String[] bank) {
		int totalLasers = 0;
		int prev = 0;
		for (int i = 0; i < bank.length; i++) {
			String current = bank[i];
			int eachCount = 0;
			for (char each : current.toCharArray()) {
				if (each == '1') {
					eachCount++;
				}
			}
			totalLasers += prev * eachCount;
			if (eachCount != 0) {
				prev = eachCount;
			}

		}
		return totalLasers;
	}

}
