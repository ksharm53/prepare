package arraysAndStrings;

public class CountPossibleDecodingsDigit {

	public static void main(String[] args) {
		String s = "10";
		System.out.println(solve(s, -1));
	}

	private static int solve(String digits, int index) {

		if (digits.isEmpty() || digits.charAt(0) - '0' == 0) {
			return 0;
		}

		if (index >= digits.length()) {
			return 0;
		}
		
		if (index >= 0 && ((index < digits.length() && Character.getNumericValue(digits.charAt(index)) == 0)
				|| (index + 1 < digits.length() && Character.getNumericValue(digits.charAt(index)) * 10
						+ Character.getNumericValue(digits.charAt(index + 1)) > 26))) {
			return 0;
		}

		if (index == digits.length() - 1) {
			return 1;
		}		

		return solve(digits, index + 1) + solve(digits, index + 2);

	}

}
