package Oct21;

public class ReverseWordsinaString {

	public static void main(String[] args) {
		String s = "a good   example";
		System.out.println(solve(s));
	}

	private static String solve(String s) {
		s.trim();
		String[] arr = s.split(" ");
		StringBuilder sb = new StringBuilder();

		for (int i = arr.length - 1; i >= 0; i--) {
			String each = arr[i];
			if (!each.isBlank()) {
				sb.append(each);
				sb.append(" ");
			}
		}
		return sb.toString().trim();
	}

}
