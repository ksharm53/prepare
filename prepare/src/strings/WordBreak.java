package strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordBreak {

	static Map<String, Boolean> map;

	public static void main(String[] args) {
		String s = "cars";
		List<String> wordDict = Arrays.asList("car", "ca", "rs");
		map = new HashMap<>();

		System.out.println(solve(s, wordDict));

	}

	private static boolean solve(String s, List<String> wordDict) {
		if (map.get(s) != null) {
			return map.get(s);
		}

		if (s.length() == 0) {
			map.put(s, true);
			return true;
		}

		for (int i = 0; i < wordDict.size(); i++) {
			String current = wordDict.get(i);
			if (s.startsWith(current)) {
				if (solve(s.substring(current.length(), s.length()), wordDict)) {
					map.put(s, true);
					return true;
				}

			}
		}
		map.put(s, false);
		return false;
	}

}
