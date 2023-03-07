package Oct21;

public class Maximum69Number {

	public static void main(String[] args) {
		int num = 9996;

		System.out.println(solve(num));

	}

	private static int solve(int num) {
		StringBuilder sb = new StringBuilder(String.valueOf(num));

		for (int i = 0; i < sb.length(); i++) {
			if (sb.charAt(i) == '6') {
				sb.replace(i, i + 1, "9");
				break;
			}
		}

		return Integer.valueOf(sb.toString());
	}

}
