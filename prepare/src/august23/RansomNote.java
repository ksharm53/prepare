package august23;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class RansomNote {

	public static void main(String[] args) {
		String ransomNote = "a";
		String magazine = "b";

		System.out.println(solve(ransomNote, magazine));

	}

	private static boolean solve(String ransomNote, String magazine) {
		if (ransomNote.length() == 0 || magazine.length() == 0) {
			return false;
		}

		Map<Character, Integer> ransomMap = new HashMap<>();
		Map<Character, Integer> magzineMap = new HashMap<>();

		for (char eachChar : ransomNote.toCharArray()) {
			ransomMap.put(eachChar, ransomMap.getOrDefault(eachChar, 0) + 1);
		}

		for (char eachChar : magazine.toCharArray()) {
			magzineMap.put(eachChar, magzineMap.getOrDefault(eachChar, 0) + 1);
		}

		for (Entry<Character, Integer> eachEntry : ransomMap.entrySet()) {
			if (magzineMap.get(eachEntry.getKey()) == null
					|| eachEntry.getValue() > magzineMap.get(eachEntry.getKey())) {
				return false;
			}
		}
		return true;
	}

}
