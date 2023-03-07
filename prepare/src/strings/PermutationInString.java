package strings;

import java.util.HashMap;
import java.util.Map;

public class PermutationInString {

	public static void main(String[] args) {
		String s1 = "ab", s2 = "eidboaoo";
		System.out.println(checkInclusion(s1, s2));
	}

	public static boolean checkInclusion(String s1, String s2) {
		int length = s1.length();
		int i = 0;
		int j = 0;

		Map<Character, Integer> map = new HashMap<>();

		for (int k = 0; k < s1.length(); k++) {
			map.put(s1.charAt(k), map.getOrDefault(s1.charAt(k), 0) + 1);
		}

		int mapSize = map.size();

		while (j < s2.length()) {
			char eachChar = s2.charAt(j);
			if (map.containsKey(eachChar)) {
				int presentCounter = map.get(eachChar);
				presentCounter--;
				map.put(eachChar, presentCounter);
				if (presentCounter == 0) {
					mapSize--;
				}
			}
			if (j - i + 1 < length) {
				j++;
			} else if (j - i + 1 == length) {
				if (mapSize == 0) {
					return true;
				}

				if (map.containsKey(s2.charAt(i))) {
					int iValue = map.get(s2.charAt(i));
					iValue++;
					map.put(s2.charAt(i), iValue);
					if (iValue == 1) {
						mapSize++;
					}
				}
				i++;
				j++;
			}
		}
		return false;
	}

}
