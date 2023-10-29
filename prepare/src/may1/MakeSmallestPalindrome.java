package may1;

public class MakeSmallestPalindrome {

	public static void main(String[] args) {
		String s = "seven";
		System.out.println(solve(s));

	}

	private static String solve(String s) {
		StringBuilder sb = new StringBuilder(s);
		int i = 0;
		int j = sb.length() - 1;

		while (i <= j) {
			char first = sb.charAt(i);
			char second = sb.charAt(j);
			if (first != second) {
				if (first < second) {
					sb.replace(j, j + 1, String.valueOf(first));
				} else {
					sb.replace(i, i + 1, String.valueOf(second));
				}
			}
			i++;
			j--;
		}
		return sb.toString();
	}

}
