package azPcise;

public class BinaryConsecutive {

	public static void main(String[] args) {
		String s = "111000";
		System.out.println(solve(s));

	}

	private static int solve(String s) {
		if (s.length() == 0) {
			return 0;
		}
		int max = 0;
		for (int i = 0; i < s.length(); i++) {

			if (s.charAt(i) == '1') {
				int oneCounter = 0;
				int zeroCounter = 0;

				while (i < s.length() && s.charAt(i) == '1') {
					oneCounter++;
					i++;
				}
				int j = i;

				while (j < s.length() && s.charAt(j) == '0') {
					zeroCounter++;
					j++;
				}
				max += Math.min(oneCounter, zeroCounter);
				i--;

			} else if (s.charAt(i) == '0') {
				int oneCounter = 0;
				int zeroCounter = 0;
				while (i < s.length() && s.charAt(i) == '0') {
					zeroCounter++;
					i++;
				}
				int j = i;

				while (j < s.length() && s.charAt(j) == '1') {
					oneCounter++;
					j++;
				}
				max += Math.min(oneCounter, zeroCounter);
				i--;

			}

		}
		return max;

	}

}
