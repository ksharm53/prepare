package arraysAndStrings;

public class FlippingBits {

	public static void main(String[] args) {
		long n = 2147483647;
		System.out.println(solve(n));

	}

	private static long solve(long n) {
		StringBuilder binary = new StringBuilder(Long.toBinaryString(n));
		int diff = 32 - binary.length();
		if (diff > 0) {
			StringBuilder sb = new StringBuilder();
			while (diff > 0) {
				sb.append("0");
				diff--;
			}

			binary = sb.append(binary);
		}
		StringBuilder sbTemp = new StringBuilder();
		for (int i = 0; i < binary.length(); i++) {
			if (binary.charAt(i) == '0') {
				sbTemp.append('1');
			} else {
				sbTemp.append('0');
			}
		}
		return Long.parseLong(sbTemp.toString(), 2);
	}

}
