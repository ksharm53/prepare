package strings;

public class FindtheIndexoftheFirstOccurrenceinaString {

	public static void main(String[] args) {
		String haystack = "leetcode";
		String needle = "leeto";

		System.out.println(solve(haystack, needle));

	}

	private static int solve(String haystack, String needle) {
		if (haystack.length() == 0 || needle.length() == 0) {
			return -1;
		}
	
		return haystack.indexOf(needle);
		
		
	}

}
