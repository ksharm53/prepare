package strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindReplacePattern {

	public static void main(String[] args) {
		String[] words = { "abc", "deq", "mee", "aqq", "dkd", "ccc" };
		String pattern = "abb";

		System.out.println(solve(words, pattern));

	}

	private static List<String> solve(String[] words, String pattern) {
		List<String> list = new ArrayList<>();

		Map<Character, Integer> map = new HashMap<>();
		for (char each : pattern.toCharArray()) {
			map.put(each, map.getOrDefault(each, 0) + 1);
		}

		for (int i = 0; i < words.length; i++) {
			if (words[i].length() != pattern.length()) {
				continue;
			}
			if (words[i].equalsIgnoreCase(pattern)) {
				list.add(words[i]);
				continue;
			}

			if (match(words[i], pattern)) {
				list.add(words[i]);
			}
		}
		return list;
	}

	private static boolean match(String string, String pattern) {
		Map<Character, Character> forMap = new HashMap<>();
		Map<Character, Character> backMap = new HashMap<>();

		for (int j = 0; j < string.length(); j++) {

			char w = string.charAt(j);
			char p = pattern.charAt(j);

			if (!forMap.containsKey(w)) {
				forMap.put(w, p);
			}
			if (!backMap.containsKey(p)) {
				backMap.put(p, w);
			}
			if (forMap.get(w) != p) {
				return false;
			}
			if (backMap.get(p) != w) {
				return false;
			}
		}
		return true;

	}

}
