package june;

import java.util.HashMap;
import java.util.Map;

public class BuddyStrings {

	public static void main(String[] args) {
		String s = "aaaaaaabc";
		String goal = "aaaaaaacb";
		System.out.println(solve(s, goal));

	}

	private static boolean solve(String s, String goal) {
		if (s.length() != goal.length()) {
			return false;
		}

		Map<Character, Character> map = new HashMap<>();
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == goal.charAt(i)) {
				continue;
			}

			if (!map.isEmpty() && map.containsKey(goal.charAt(i)) && map.get(goal.charAt(i)) == s.charAt(i)) {
				count++;
			}

			map.put(s.charAt(i), goal.charAt(i));
		}

		return count == 1 ? true : false;
	}

}
