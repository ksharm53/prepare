package oct2023;

public class LargestGoodInteger {

	public static void main(String[] args) {
		String num = "42352338";
		System.out.println(solve(num));

	}

	private static String solve(String num) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < num.length(); i++) {
			int count = 1;
			while (i + 1 < num.length() && num.charAt(i) == num.charAt(i + 1)) {
				count++;
				i++;
			}
			if (count >= 3) {
				max = Math.max(max, Character.getNumericValue(num.charAt(i)));
			}
		}
		if (max == Integer.MIN_VALUE) {
			return "";
		}
		String val = String.valueOf(max);

		return val + val + val;
	}

}
