package Apr1;

public class MaximumCostSubstring {

	public static void main(String[] args) {
		String s = "abc";
		String chars = "abc";
		int[] vals = { -1, -1, -1 };

		System.out.println(solve(s, chars, vals));
	}

	private static int solve(String s, String chars, int[] vals) {

		int max = Integer.MIN_VALUE;
		int localMax = 0;

		for (int i = 0; i < s.length(); i++) {
			int val = 0;
			char ch = s.charAt(i);
			int idx = chars.indexOf(ch);
			if (idx != -1) {
				val = vals[idx];
			} else {
				val = ch - 'a' + 1;
			}

			localMax = Math.max(val, localMax + val);

			max = Math.max(max, localMax);

		}

		return max < 0 ? 0 : max;
	}

}
