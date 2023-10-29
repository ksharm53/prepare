package june;

public class LongestSemiRepetitiveSubstring {

	public static void main(String[] args) {
		String s = "0001";
		System.out.println(solve(s));

	}

	private static int solve(String s) {
		int max = Integer.MIN_VALUE;
		boolean foundPreviously = false;
		int start = 0;
		int end = 0;
		for (int i = 0; i < s.length(); i++) {
			if (i - 1 >= 0 && s.charAt(i - 1) == s.charAt(i)) {
				if (!foundPreviously) {
					foundPreviously = true;
					end = i;
					continue;
				} else {
					max = Math.max(max, i - start);
					start = end;
					end = i;
					max = Math.max(max, i - start + 1);
				}
			}
		}
		foundPreviously = false;
		start = s.length() - 1;
		end = s.length() - 1;
		for (int i = s.length() - 1; i >= 0; i--) {
			if (i + 1 < s.length() && s.charAt(i + 1) == s.charAt(i)) {
				if (!foundPreviously) {
					foundPreviously = true;
					end = i;
					continue;
				} else {
					max = Math.max(max, start - i);
					start = end;
					end = i;
					max = Math.max(max, start - i + 1);
				}
			}
		}

		return max == Integer.MIN_VALUE ? s.length() : max;
	}

}
