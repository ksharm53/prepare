package aug;

public class CanMakeSubsequence {

	public static void main(String[] args) {
		String str1 = "ab", str2 = "c";
		System.out.println(solve(str1, str2));

	}

	private static boolean solve(String str1, String str2) {
		int i = 0;
		int j = 0;

		while (i < str1.length() && j < str2.length()) {
			if (str1.charAt(i) == str2.charAt(j)) {
				i++;
				j++;

			} else {

				char next = (char) ('a' + (str1.charAt(i) - 'a' + 1) % 26);

				if (next == str2.charAt(j)) {

					i++;
					j++;
				} else {
					i++;
				}
			}
		}
		return j >= str2.length();
	}

}
