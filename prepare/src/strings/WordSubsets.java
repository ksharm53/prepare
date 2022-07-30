package strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordSubsets {

	public static void main(String[] args) {
		String[] words1 = { "amazon", "apple", "facebook", "google", "leetcode" };
		String[] words2 = { "lo", "eo" };
		System.out.println(solveAgain(words1, words2));

	}

	private static List<String> solveAgain(String[] words1, String[] words2) {
		List<String> list = new ArrayList<>();
		Map<Character, Integer> map = new HashMap<>();

		if (words1.length == 0 || words2.length == 0) {
			return list;
		}

		for (String eachWord2string : words2) {
			Map<Character, Integer> intermediate = new HashMap<>();

			for (char eachWord2Char : eachWord2string.toCharArray()) {
				intermediate.put(eachWord2Char, intermediate.getOrDefault(eachWord2Char, 0) + 1);

				map.put(eachWord2Char,
						Math.max(map.get(eachWord2Char) == null ? Integer.MIN_VALUE : map.get(eachWord2Char),
								intermediate.get(eachWord2Char)));
			}

		}

		outer: for (String eachString : words1) {
			Map<Character, Integer> mapWord1 = new HashMap<>();

			for (char eachWord1Char : eachString.toCharArray()) {
				mapWord1.put(eachWord1Char, mapWord1.getOrDefault(eachWord1Char, 0) + 1);
			}

			for (Character eachValue : map.keySet()) {
				if (mapWord1.get(eachValue) == null || mapWord1.get(eachValue) < map.get(eachValue)) {
					continue outer;
				}
			}
			list.add(eachString);
		}

		return list;
	}

}
