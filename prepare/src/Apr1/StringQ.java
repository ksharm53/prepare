package Apr1;

public class StringQ {

	public static void main(String[] args) {
		String s = "abb";
		System.out.println(solve(s));

	}

	private static int solve(String s) {
		int count = 0;
		StringBuilder sb = new StringBuilder(s);
		while (true) {
			if (sb.indexOf("ab") != -1) {
				int idx = sb.indexOf("ab");
				sb.replace(idx, idx + 2, "ba");
				count++;
			} else {
				break;
			}
		}
		return count;
	}

}
