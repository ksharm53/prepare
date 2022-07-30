package strings;

public class PercentageLetterString {

	public static void main(String[] args) {
		String s = "sgawtb";
		char letter = 's';

		System.out.println(solve(s, letter));

	}

	private static int solve(String s, char letter) {
		if (!s.contains(String.valueOf(letter))) {
			return 0;
		}

		int counter = 0;
		for (char each : s.toCharArray()) {
			if (each == letter) {
				counter++;
			}
		}

		return (counter * 100) / s.length();

	}

}
