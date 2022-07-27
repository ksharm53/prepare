package arraysAndStrings;

public class StringToInteger {

	public static void main(String[] args) {
		String s = "-91283472332";

		System.out.println(solve(s));
	}

	private static int solve(String s) {
		if (s.length() == 0 || s.isBlank()) {
			return 0;
		}
		s = s.stripLeading();

		int multiple = 1;
		int j = 0;
		long valueResult = 0;

		if (s.charAt(0) == '-') {
			multiple = -1;
			j++;
		} else if (s.charAt(0) == '+') {
			multiple = 1;
			j++;
		}

		while (j < s.length() && Character.isDigit(s.charAt(j))) {
			valueResult = valueResult * 10 + Character.getNumericValue(s.charAt(j));
			valueResult = multiple * valueResult;

			if (valueResult >= Integer.MAX_VALUE) {
				return Integer.MAX_VALUE;
			} else if (valueResult < Integer.MIN_VALUE) {
				return Integer.MIN_VALUE;
			}

			if (multiple == -1) {
				valueResult = multiple * valueResult;
			}
			j++;
		}

		return (int) (multiple == 1 ? valueResult : multiple * valueResult);
	}

}
