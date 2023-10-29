package Apr1;

public class SimplifyPath {

	public static void main(String[] args) {
		String path = "/a/./b/../../c/";
		System.out.println(solve(path));

	}

	private static String solve(String path) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < path.length(); i++) {
			char each = path.charAt(i);
			if (each == '/') {
				while (i < path.length() && path.charAt(i) == '/') {
					i++;
				}
				i--;
				if (i != path.length() - 1) {
					sb.append('/');
				}

			} else if (Character.isAlphabetic(each) || each == '_') {
				sb.append(each);
			} else if (each == '.') {
				int count = 0;
				int temp = i;
				while (temp < path.length() && path.charAt(temp) == '.') {
					count++;
					temp++;
				}
				if (count > 2) {
					sb.append(path.substring(i, temp));
				}
				i = temp - 1;
			}
		}

		if (!sb.isEmpty() && sb.charAt(0) != '/') {
			sb.insert(0, '/');
		}
		return sb.toString();
	}

}
