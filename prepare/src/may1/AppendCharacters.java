package may1;

public class AppendCharacters {

	public static void main(String[] args) {
		String s = "z";
		String t = "abcde";

		System.out.println(solve(s, t));

	}

	private static int solve(String s, String t) {
		int idx = 0;
		for (int i = 0; i < t.length(); i++) {
			char each = t.charAt(i);

			while (idx < s.length() && s.charAt(idx) != each) {
				idx++;
			}
			if (idx < s.length() && s.charAt(idx) == each) {
				idx++;
				continue;
			}
			if (idx >= s.length()) {
				return (t.length() - i);
			}

		}

		return 0;
	}

}
