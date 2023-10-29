package july;

public class FinalString {

	public static void main(String[] args) {
		String s = "poiinter";
		System.out.println(solve(s));

	}

	private static String solve(String s) {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'i') {
				sb.reverse();
			} else {
				sb.append(s.charAt(i));
			}
		}
		return sb.toString();
	}

}
