package oct3;

import java.util.HashMap;
import java.util.Map;

public class NumberofGoodWaystoSplitaString {

	public static void main(String[] args) {
		String s = "abcd";
		System.out.println(numSplits(s));
	}

	public static int numSplits(String s) {
		Map<Character, Integer> map = new HashMap<>();
		int counter = 0;

		for (char eachChar : s.toCharArray()) {
			map.put(eachChar, map.getOrDefault(eachChar, 0) + 1);
		}

		Map<Character, Integer> mapLeft = new HashMap<>();
		int j = 0;

		while (j < s.length()) {
			mapLeft.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);

			map.put(s.charAt(j), map.get(s.charAt(j)) - 1);
			if (map.get(s.charAt(j)) == 0) {
				map.remove(s.charAt(j));
			}

			if (mapLeft.size() == map.size()) {
				counter++;
			}
			j++;
		}
		return counter;
	}

}
