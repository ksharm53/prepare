package newBeginning;

public class PowerOfFour {

	public static void main(String[] args) {
		int n = 243;

		System.out.println(solve(n));

	}

	private static boolean solve(int n) {
		if (n == 0) {
			return false;
		}
		double val = Math.log10(n) / Math.log10(3);
		double value = Math.floor(val);

		return val == value;
	}

}
