package strings;

public class CountBinarySubstrings {

	public static void main(String[] args) {
		String s = "00110011";
		System.out.println(solve(s));

	}

	private static int solve(String s) {
		int result = 0;
		int current = 1;
		int prevous = 0;
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) == s.charAt(i - 1)) {
				current++;
			} else {
				result = result + Math.min(current, prevous);
				prevous = current;
				current = 1;
			}
		}
		return result + Math.min(current, prevous);
	}

}
