package arraysAndStrings;

public class CeaserCypher {

	public static void main(String[] args) {
		String string = "middle-Outz";

		System.out.println(solve(string, 3));

	}

	private static String solve(String string, int k) {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < string.length(); i++) {
			char temp = string.charAt(i);
			boolean upperCase = Character.isUpperCase(temp);
			if (Character.isLetter(temp)) {
				temp += k % 26;
				if (!Character.isLetter(temp) || (upperCase && !Character.isUpperCase(temp))) {
					temp -= 26;
				}
			}
			sb.append(temp);
		}
		return sb.toString();
	}

}
