package august23;

public class ReverseWords {

	public static void main(String[] args) {
		String words = "Let's take LeetCode contest";
		System.out.println(reverseWords(words));
	}

	public static String reverseWords(String s) {
		String[] array = s.split(" ");
		StringBuilder result = new StringBuilder();
		for (String each : array) {
			StringBuilder sb = new StringBuilder(each);
			result.append(sb.reverse());
			result.append(" ");
		}

		return result.toString().trim();
	}

}
