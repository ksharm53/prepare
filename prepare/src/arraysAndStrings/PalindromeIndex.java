package arraysAndStrings;

public class PalindromeIndex {

	public static void main(String[] args) {
		String s = "aaa";
		System.out.println(solve(s));

	}

	private static int solve(String s) {
		int i = 0;
		int j = s.length() - 1;
		if (s.charAt(i) == s.charAt(j)) {
			i++;
			j--;
		} else {
			if (isPalindrome(s.substring(i, j))) {
				return j;
			} else {
				return i;
			}
		}
		return -1;
	}

	private static boolean isPalindrome(String substring) {
		StringBuilder sb = new StringBuilder(substring);

		if (sb.reverse().toString().equalsIgnoreCase(substring)) {
			return true;
		} else {
			return false;
		}

	}

}
