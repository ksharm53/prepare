package CodeSignal;

public class CodeSignal_Palindrome {

	public static void main(String[] args) {
		
		String s = "aaacodedoc";
		System.out.println(solution(s));

	}

	public static String solution(String s) {
		StringBuilder sb = new StringBuilder(s);

		while (!sb.isEmpty()) {
			int i = 0;
			int j = sb.length() - 1;

			inner: while (i < j) {
				boolean result = isPalindrome(sb.substring(i, j + 1));
				if (result) {
					break inner;
				}
				j--;
			}
			if (sb.substring(i, j + 1).length() < 2) {
				return sb.toString();
			} else {
				sb.delete(i, j + 1);
			}
		}
		return sb.toString();
	}

	public static boolean isPalindrome(String value) {
		StringBuilder sb = new StringBuilder(value);
		if (sb.reverse().toString().equals(value)) {
			return true;
		} else {
			return false;
		}
	}

}
