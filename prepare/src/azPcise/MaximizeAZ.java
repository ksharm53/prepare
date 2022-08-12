package azPcise;

public class MaximizeAZ {

	public static void main(String[] args) {
		String s = "BAZAZ";
		String a = "AZ";

		System.out.println(solve(s, a));

	}

	private static int solve(String s, String a) {
		int valu = findSubsequence(s, a, s.length(), a.length());

		StringBuilder sb = new StringBuilder(s);
		sb.append("Z");

		int appendZ = findSubsequence(sb.toString(), a, sb.length(), a.length());

		String next = "A" + s;

		int appendA = findSubsequence(next, a, next.length(), a.length());

		return Math.max(valu, Math.max(appendZ, appendA));
	}

	private static int findSubsequence(String s, String a, int length, int length2) {
		if (length == 0 || length2 == 0) {
			return 0;
		}

		if (s.charAt(length - 1) == a.charAt(length2 - 1)) {
			return 1 + findSubsequence(s, a, length - 1, length2 - 1);
		} else {
			return Math.max(findSubsequence(s, a, length - 1, length2), findSubsequence(s, a, length, length2 - 1));
		}
	}

}
