package Oct13;

public class StringCompressionII {

	public static void main(String[] args) {
		String s = "aabbaa";
		int k = 2;

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			int counter = 1;
			while (i + 1 < s.length() && s.charAt(i + 1) == s.charAt(i)) {
				counter++;
				i++;
			}
			sb.append(s.charAt(i));
			if (counter > 1) {
				sb.append(counter);
			}
		}
		System.out.println(sb.toString());

	}

}
