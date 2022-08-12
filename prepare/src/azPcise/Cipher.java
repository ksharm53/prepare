package azPcise;

public class Cipher {

	public static void main(String[] args) {
		String s = "VTAOG";
		int cipher = 2;

		System.out.println(solve(s, cipher));

	}

	private static String solve(String s, int cipher) {
		if (s.length() == 0 || cipher == 0) {
			return s;
		}
		StringBuilder sb = new StringBuilder();
		cipher = cipher % 26;

		for (char eachCharacter : s.toCharArray()) {
			int value = eachCharacter - cipher;
			if (value < 65) {
				value += 26;
			}
			sb.append((char) value);
		}
		return sb.toString();
	}

}
