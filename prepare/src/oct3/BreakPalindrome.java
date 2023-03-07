package oct3;

public class BreakPalindrome {

	public static void main(String[] args) {
		String s = "abccbb";
		System.out.println(breakPalindrome(s));
	}

	public static String breakPalindrome(String palindrome) {

		StringBuilder sb = new StringBuilder(palindrome);
		if (sb.length() == 1) {
			return "";
		}
		boolean changed = false;
		for (int i = 0; i < sb.length(); i++) {
			if (sb.charAt(i) == 'a') {
				continue;
			} else {
				StringBuilder temp = new StringBuilder(palindrome).replace(i, i + 1, "a");
				if (!validate(temp.toString())) {
					sb.replace(i, i + 1, "a");
					changed = true;
					break;
				}
			}
		}
		if (!changed) {
			sb.replace(sb.length() - 1, sb.length(), "b");
		}
		return sb.toString();
	}

	public static boolean validate(String s) {
		StringBuilder sb = new StringBuilder(s);
		return sb.reverse().toString().equals(s) ? true : false;
	}

}
