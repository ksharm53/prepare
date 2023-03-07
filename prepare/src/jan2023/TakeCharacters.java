package jan2023;

import java.util.HashMap;

public class TakeCharacters {

	public static void main(String[] args) {
		String s = "aabaaaacaabc";
		int k = 2;
		System.out.println(solve(s, k, 0, s.length() - 1, new HashMap<Character, Integer>()));

	}

	private static int solve(String s, int k, int start, int end, HashMap<Character, Integer> map) {
		if (k == 0 || s.length() == 0 || start >= end || map.size() > 3) {
			return 0;
		}

		map.put(s.charAt(start), map.getOrDefault(s.charAt(start), 0) + 1);
		int aageSe = 1 + solve(s, k, start + 1, end, map);
		map.put(s.charAt(start), map.getOrDefault(s.charAt(start), 0) - 1);
		map.put(s.charAt(end), map.getOrDefault(s.charAt(end), 0) + 1);
		int peecheSe = 1 + solve(s, k, start, end - 1, map);
		map.put(s.charAt(end), map.getOrDefault(s.charAt(end), 0) - 1);
		return Math.min(aageSe, peecheSe);

	}

}
