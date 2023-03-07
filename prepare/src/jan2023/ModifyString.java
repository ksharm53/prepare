package jan2023;

public class ModifyString {

	public static void main(String[] args) {
		String s = "??yw?ipkj?";
		System.out.println(solve(s));

	}

	public static String solve(String s) {
		StringBuilder sb = new StringBuilder(s);
		for (int i = 0; i < sb.length(); i++) {
			if (sb.charAt(i) == '?') {
				for (int j = 0; j < 26; j++) {
					if (i - 1 < 0 && i + 1 < sb.length()) {
						if (sb.charAt(i + 1) != (char) (97 + j)) {
							sb.replace(i, i + 1, String.valueOf((char) (97 + j)));
							break;
						}
					} else if (i + 1 >= sb.length() && i - 1 >= 0) {
						if (sb.charAt(i - 1) != (char) (97 + j)) {
							sb.replace(i, i + 1, String.valueOf((char) (97 + j)));
							break;
						}
					} else if (i - 1 < 0 && i + 1 >= sb.length()) {
						sb.replace(i, i + 1, String.valueOf((char) (97 + j)));
						break;
					} else {
						if (sb.charAt(i - 1) != (char) (97 + j) && sb.charAt(i + 1) != (char) (97 + j)) {
							sb.replace(i, i + 1, String.valueOf((char) (97 + j)));
							break;
						}
					}
				}
			}
		}
		return sb.toString();
	}

}
