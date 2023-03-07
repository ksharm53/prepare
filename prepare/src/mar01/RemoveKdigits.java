package mar01;

public class RemoveKdigits {

	public static void main(String[] args) {
		String num = "1432219";
		int k = 3;
		System.out.println(solve(num, k));

	}

	private static String solve(String num, int k) {
		if (num.length() == k) {
			return "0";
		}

		if (k == 0) {
			return num;
		}
		StringBuilder sb = new StringBuilder();
		sb.append(num.charAt(0));

		for (int i = 1; i < num.length(); i++) {
			while (k > 0 && !sb.isEmpty() && sb.charAt(sb.length() - 1) /* stack.peek() */ > num.charAt(i)) {
				sb.deleteCharAt(sb.length() - 1);
				k--;
			}
			sb.append(num.charAt(i));
		}

		while (!sb.isEmpty() && k > 0) {
			sb.deleteCharAt(sb.length() - 1);
			k--;
		}

		StringBuilder temp = new StringBuilder(sb);

		int i = 0;
		while (i < temp.length() && temp.charAt(i) == '0') {
			sb.deleteCharAt(0);
			i++;
		}

		return sb.isEmpty() ? "0" : sb.toString();
	}

}
