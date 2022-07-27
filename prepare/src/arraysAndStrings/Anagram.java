package arraysAndStrings;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Anagram {

	public static void main(String[] args) {
		String s = "fdhlvosfpafhalll";
		System.out.println(anagram(s));
	}

	public static int anagram(String s) {
		if (s.length() == 0) {
			return 0;
		}
		Map<Character, Integer> map = new HashMap<>();
		Map<Character, Integer> mapSecond = new HashMap<>();
		int length = s.length();
		String first = s.substring(0, length / 2);
		String second = s.substring(length / 2, length);
		int counter = 0;

		if (first.length() != second.length()) {
			return -1;
		}
		for (char each : first.toCharArray()) {
			map.put(each, map.getOrDefault(each, 0) + 1);
		}

		for (char each : second.toCharArray()) {
			mapSecond.put(each, mapSecond.getOrDefault(each, 0) + 1);
		}

		for (Entry<Character, Integer> each : map.entrySet()) {
			if (mapSecond.containsKey(each.getKey())) {
				int value2 = mapSecond.get(each.getKey());
				int value1 = each.getValue();
				if (value2 >= value1) {
					mapSecond.put(each.getKey(), value2 - value1);
					map.put(each.getKey(), 0);
				} else {
					map.put(each.getKey(), value1 - value2);
					mapSecond.put(each.getKey(), 0);
				}

			}
		}

		for (Entry<Character, Integer> each : map.entrySet()) {
			counter = counter + each.getValue();
		}
		int temp = 0;
		for (Entry<Character, Integer> each : mapSecond.entrySet()) {
			temp = temp + each.getValue();
		}

		return Math.min(counter, temp);

	}

	public static int solve(String first, String second, int firstLength, int secondLength) {
		if (firstLength == 0 || secondLength == 0) {
			return 0;
		}
		if (first.charAt(firstLength - 1) == second.charAt(secondLength - 1)) {
			return 1 + solve(first, second, firstLength - 1, secondLength - 1);
		} else {
			return Math.max(solve(first, second, firstLength - 1, secondLength),
					solve(first, second, firstLength, secondLength - 1));
		}
	}

}
