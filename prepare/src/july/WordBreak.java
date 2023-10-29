package july;

import java.util.List;

public class WordBreak {

	public static void main(String[] args) {
		String s = "cars";
		List<String> wordDict = List.of("car", "ca", "rs");

		System.out.println(solve(new StringBuilder(s), wordDict, 0));

	}

	private static boolean solve(StringBuilder s, List<String> wordDict, int idx) {
		if (s.isEmpty()) {
			return true;
		}

		if (idx >= wordDict.size()) {
			return false;
		}

		if (s.toString().contains(wordDict.get(idx))) {
			int startIdx = s.indexOf(wordDict.get(idx));
			s.delete(startIdx, startIdx + wordDict.get(idx).length());

			boolean liya = solve(s, wordDict, idx);

			s.insert(startIdx, wordDict.get(idx));

			boolean naiLiya = solve(s, wordDict, idx + 1);

			return liya || naiLiya;

		} else {
			return solve(s, wordDict, idx + 1);
		}
	}

}
