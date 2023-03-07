package Oct21;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

	public static void main(String[] args) {
		String s = "a";
		String t = "aa";

		System.out.println(solve(s, t));

	}

	private static String solve(String s, String t) {
		if (s.length() == 0 || t.length() == 0 || t.length() > s.length()) {
			return "";
		}

		int i = 0;
		int j = 0;

		Map<Character, Integer> map = new HashMap<>();
		for (char each : t.toCharArray()) {
			map.put(each, map.getOrDefault(each, 0) + 1);
		}

		int counter = map.size();
		int min = Integer.MAX_VALUE;
		String res = "";

		while (j < s.length()) {

			if (map.containsKey(s.charAt(j))) {
				map.put(s.charAt(j), map.get(s.charAt(j)) - 1);
				if (map.get(s.charAt(j)) == 0) {
					counter--;
				}
			}
			j++;

			if (counter == 0) {
				while (!map.containsKey(s.charAt(i)) || map.get(s.charAt(i)) < 0) {
					if (map.containsKey(s.charAt(i))) {
						map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
						if (map.get(s.charAt(i)) > 0) {
							counter++;
						}
					}
					i++;
				}
				if (j - i + 1 < min) {
					min = j - i + 1;
					res = s.substring(i, j);
				}

			}

		}
		return res;
	}

}
