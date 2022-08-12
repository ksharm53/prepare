package strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordBreak2 {

	static Map<String, List<String>> map;

	public static void main(String[] args) {
		String s = "catsanddog";
		List<String> wordDict = Arrays.asList("cat", "cats", "and", "sand", "dog");
		map = new HashMap<>();

		System.out.println(solve(s, wordDict));
	}

	private static List<String> solve(String s, List<String> wordDict) {
		if (map.get(s) != null) {
			return map.get(s);
		}

		List<String> list = new ArrayList<>();

		if (s.length() == 0) {
			list.add("");
			map.put(s, list);
			return list;
		}

		for (int i = 0; i < wordDict.size(); i++) {
			String current = wordDict.get(i);
			if (s.startsWith(current)) {
				List<String> temp = solve(s.substring(current.length(), s.length()), wordDict);
				for (String sub : temp)
					list.add(current + (sub.isEmpty() ? "" : " ") + sub);

			}

		}
		map.put(s, list);
		return list;
	}

}
