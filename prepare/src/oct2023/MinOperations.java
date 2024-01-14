package oct2023;

public class MinOperations {

	public static void main(String[] args) {
		String s = "10000";
		System.out.println(solve(s));

	}

	private static int solve(String s) {
		int startZeroCount = 0;
		int startOneCount = 0;
		for (int i = 0; i < s.length(); i++) {
			if ((i % 2 == 0 && s.charAt(i) == '1') || (i % 2 != 0 && s.charAt(i) == '0')) {
				startZeroCount++;
			}

			if ((i % 2 == 0 && s.charAt(i) == '0') || (i % 2 != 0 && s.charAt(i) == '1')) {
				startOneCount++;
			}
		}

		return Math.min(startZeroCount, startOneCount);
	}

}
