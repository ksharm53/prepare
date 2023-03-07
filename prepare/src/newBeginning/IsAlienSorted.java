package newBeginning;

public class IsAlienSorted {

	public static void main(String[] args) {
		String[] words = { "apple", "app" };
		String order = "abcdefghijklmnopqrstuvwxyz";

		System.out.println(solve(words, order));

	}

	private static boolean solve(String[] words, String order) {
		int length = Integer.MIN_VALUE;
		for (String eachWord : words) {
			length = Math.max(length, eachWord.length());
		}

		int j = 0;
		while (j < length) {
			int idx = 0;
			for (int i = 0; i < words.length; i++) {
				if (j >= words[i].length()) {
					continue;
				}
				char eachChar = words[i].charAt(j);
				int eachIdx = order.indexOf(eachChar);
				if (eachIdx < idx) {
					return false;
				}
				idx = Math.max(eachIdx, idx);
			}
			j++;
		}
		return true;
	}

}
