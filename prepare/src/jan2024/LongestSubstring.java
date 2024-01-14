package jan2024;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstring {

	public static void main(String[] args) {
		String key = "aaa";
		String text = "aaaa";
		System.out.println(solve(key, text));

	}

	private static int solve(String key, String text) {
		Map<Character, Integer> map = new HashMap<>();
		for (char eachChar : key.toCharArray()) {
			map.put(eachChar, map.getOrDefault(eachChar, 0) + 1);
		}
		int count = 0;

		int i = 0;
		int j = 0;
		while (j < text.length()) {
			if (map.containsKey(text.charAt(j))) {
				map.put(text.charAt(j), map.get(text.charAt(j)) - 1);
				if (map.get(text.charAt(j)) == 0) {
					map.remove(text.charAt(j));
				}
			} else {
				i++;
			}

			if (map.size() == 0) {
				if (countSwaps(text.substring(i, j + 1), key)) {
					count++;
				}
				map.put(text.charAt(i), map.getOrDefault(text.charAt(j), 0) + 1);
				i++;
			}
			j++;
		}
		return count;
	}

	private static boolean countSwaps(String text, String key) {
		StringBuilder sb = new StringBuilder(text);
		if (key.equals(sb.toString())) {
			return true;
		}
		int count = 0;
		for (int i = 0; i < sb.length(); i++) {
			if (sb.charAt(i) != key.charAt(i)) {
				if (i - 1 >= 0 && (sb.charAt(i - 1) == key.charAt(i)) && (sb.charAt(i) == key.charAt(i - 1))) {
					char temp = sb.charAt(i - 1);
					sb.insert(i - 1, sb.charAt(i));
					sb.insert(i, temp);
				} else if (i + 1 < key.length() && (sb.charAt(i + 1) == key.charAt(i))
						&& (sb.charAt(i) == key.charAt(i + 1))) {
					char temp = sb.charAt(i);
					sb.replace(i, i + 1, String.valueOf(sb.charAt(i + 1)));
					sb.replace(i + 1, i + 2, String.valueOf(temp));
				} else {
					return false;
				}
				count++;
			}
		}

		return count == 0 || (count == 1 && sb.toString().equals(key));
	}
}
