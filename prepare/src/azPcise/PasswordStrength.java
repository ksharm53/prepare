package azPcise;

import java.util.Arrays;
import java.util.List;

public class PasswordStrength {

	public static void main(String[] args) {
		String s = "aeiou";
		System.out.println(solve(s));

	}

	private static int solve(String s) {
		if (s.length() == 0) {
			return 0;
		}
		int counter = 0;
		List<Character> list = Arrays.asList('a', 'e', 'i', 'o', 'u');

		int i = 0;
		int j = 0;
		int countConsonant = 0;
		int countVowel = 0;

		while (j < s.length()) {
			if (list.contains(s.charAt(j))) {
				countVowel++;
			} else {
				countConsonant++;
			}

			if (countConsonant > 0 && countVowel > 0) {
				counter++;
				j++;
				i = j;
				countConsonant = 0;
				countVowel = 0;
			} else {
				j++;
			}
		}
		return counter;
	}

}
