package arraysAndStrings;

public class RemovePalindromicSubsequence {

	public static void main(String[] args) {
		String s = "baabb";

		System.out.println(solve(s));

	}

	private static int solve(String s) {

		StringBuilder sb = new StringBuilder(s);

		if (sb.reverse().toString().equalsIgnoreCase(s)) {
			return 1;
		}
		else {
			return 2;
		}

	}

}
