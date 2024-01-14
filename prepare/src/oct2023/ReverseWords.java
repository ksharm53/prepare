package oct2023;

public class ReverseWords {

	public static void main(String[] args) {
		String s = "a good   example";
		System.out.println(solve(s));

	}

	private static String solve(String s) {
		String[] arr = s.split(" ");
		int i = 0;
		int j = arr.length - 1;
		while (i < j) {
			String temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			i++;
			j--;
		}
		StringBuilder sb = new StringBuilder();
		for (int idx = 0; idx < arr.length; idx++) {
			String each = arr[idx];
			if (!each.isBlank()) {
				sb.append(each);
				sb.append(" ");
			}
		}

		sb.deleteCharAt(sb.length() - 1);
		return sb.toString();
	}

}
