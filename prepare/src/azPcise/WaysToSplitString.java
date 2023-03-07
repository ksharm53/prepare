package azPcise;

import java.util.HashMap;
import java.util.Map;

public class WaysToSplitString {

	public static void main(String[] args) {
		String s = "wxyzzyxw";
		System.out.println(solve(s, 1));
	}

	private static int solve(String s, int k) {
		if (s.length() == 0) {
			return 0;
		}
		int count = 0;
		
		Map<Character, Integer> map = new HashMap<>();
		Map<Character, Integer> leftMap = new HashMap<>();

		for (Character eachCharacter : s.toCharArray()) {
			map.put(eachCharacter, map.getOrDefault(eachCharacter, 0) + 1);
		}

		for (int i = 0; i < s.length(); i++) {
			int innerCounter = 0;
			char current = s.charAt(i);
			map.put(current, map.get(current) - 1);
			leftMap.put(current, leftMap.getOrDefault(current, 0) + 1);

			for (char eachKey : leftMap.keySet()) {
				if (null != map.get(eachKey) && map.get(eachKey) != 0) {
					innerCounter++;
				}
			}

			if (innerCounter > k) {
				count++;
			}
		}
		return count;
	}

}
