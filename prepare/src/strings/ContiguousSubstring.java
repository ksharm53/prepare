package strings;

public class ContiguousSubstring {

	public static void main(String[] args) {
		String source = "bbaacaa";
		System.out.println(solve(source));

	}

	private static String solve(String source) {

		int i = 0;
		int j = 0;
		int max = Integer.MIN_VALUE;
		char value = 0;

		while (j < source.length()) {
			if (source.charAt(j) == source.charAt(i)) {
				j++;
			} else if (source.charAt(j) != source.charAt(i)) {
				if (j - i >= max) {
					max = j - i;
					value = source.charAt(i);
				}
				i = j;
				j++;
			}
		}

		StringBuilder sb = new StringBuilder();
		sb.append(value);
		sb.append(max);
		return sb.toString();
	}

}
