package arraysAndStrings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class IsValidString {

	public static void main(String[] args) {
		String s = "abcdefghhgfedecba";
		System.out.println(solve(s));

	}

	private static String solve(String s) {
		Map<Character, Integer> map = new HashMap<>();
		Set<Integer> set = new HashSet<>();
		Set<Character> characterSet = new HashSet<>();

		for (char each : s.toCharArray()) {
			map.put(each, map.getOrDefault(each, 0) + 1);
			characterSet.add(each);
		}
		int[] freq = new int[map.size()];
		int counter = -1;
		for (Entry<Character, Integer> each : map.entrySet()) {
			counter++;
			set.add(each.getValue());
			freq[counter] = each.getValue();
		}

		if (set.size() > 3 || set.size() < 1) {
			return "NO";
		}
		if (set.size() == 1) {
			return "YES";
		}

		Arrays.sort(freq);

		if (freq[0] == freq[freq.length - 1]) {
			return "YES";
		}
		if (freq[0] == 1 && freq[1] == freq[freq.length - 1]) {
			return "YES";
		}
		if (freq[0] == freq[freq.length - 2] && freq[freq.length - 1] - freq[freq.length - 2] == 1) {
			return "YES";
		}
		return "NO";
	}

}
