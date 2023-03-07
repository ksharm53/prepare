package jan2023;

public class ValidPalindrome {

	public static void main(String[] args) {
		String s = "0P";
		System.out.println(solve(s));

	}

	private static boolean solve(String s) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			char each = s.charAt(i);
			if (Character.isAlphabetic(each) || Character.isDigit(each)) {
				if (Character.isAlphabetic(each) && Character.isUpperCase(each)) {
					sb.append(Character.toLowerCase(each));
				} else {
					sb.append(each);
				}
			}
		}

		String finalString = sb.toString();
		return sb.reverse().toString().equals(finalString);
	}

}
