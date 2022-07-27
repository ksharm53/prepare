package arraysAndStrings;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

	static int counter;
	static StringBuilder sb;
	static StringBuilder resultant;
	static int max;

	public static void main(String[] args) {
		String s = "ab";
		String t = "a";

		counter=0;
		sb = new StringBuilder();
		resultant=new StringBuilder();
		max= Integer.MAX_VALUE;

		System.out.println(solve(s, t));
	}

	private static String solve(String s, String t) {

		int i = 0;
		int j = 0;
		char[] array = t.toCharArray();
		Map<Character, Integer> map = new HashMap<>();

		for (char c : array) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}

		counter = map.size();

		while (j < s.length()) {
			char eachChar = s.charAt(j);
			if (map.containsKey(eachChar)) {
				map.put(eachChar, map.get(eachChar) - 1);
				if (map.get(eachChar) == 0) {
					counter--;
				}
				j++;
			} else {
				j++;
			}

			if (counter == 0) {
				sb = new StringBuilder(s.substring(i, j));

				while (!map.containsKey(s.charAt(i)) || map.get(s.charAt(i)) < 0) {
					if (!map.containsKey(s.charAt(i))) {
						sb.delete(0, 1);
						i++;
					} else {
						map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
						sb.delete(0, 1);
						i++;
					}

				}
				if(sb.length() < max) {
					resultant=new StringBuilder(sb);
					max= resultant.length();
				}
			}

		}
		return resultant.toString();
	}

}
