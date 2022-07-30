package strings;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {

	public static void main(String[] args) {
		String s = "a";
		String t = "ab";

		System.out.println(solve(s, t));

	}

	private static boolean solve(String s, String t) {
		if (s.length() == 0 || t.length() == 0 || s.length() != t.length()) {
			return false;
		}
		Map<Character, Integer> originalMap = new HashMap<>();

		for (char each : s.toCharArray()) {
			originalMap.put(each, originalMap.getOrDefault(each, 0) + 1);
		}

		for (int i = 0; i < t.length(); i++) {
			char each = t.charAt(i);
			if (originalMap.keySet().contains(each)) {
				originalMap.put(each, originalMap.get(each) - 1);
				if (originalMap.get(each) == 0) {
					originalMap.remove(each);
				}
			}
		}
		return originalMap.size() > 0 ? false : true;
	}

}
