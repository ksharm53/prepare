package arraysAndStrings;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MinimumDeletionsMakeCharacterFrequencies {

	public static void main(String[] args) {
		String s = "bbcebab";

		System.out.println(solve(s));

	}

	private static int solve(String s) {

		int currentValue = 0;
		int result = 0;
		Map<Character, Integer> map = new HashMap<>();

		for (char each : s.toCharArray()) {
			map.put(each, map.getOrDefault(each, 0) + 1);
		}

		List<Integer> list = map.values().stream().collect(Collectors.toList());
		Collections.sort(list, Collections.reverseOrder());

		currentValue = list.get(0);

		for (int i = 1; i < list.size(); i++) {
			int value = list.get(i);
			while (value >= currentValue && value > 0) {
				value = value - 1;
				result = result + 1;
			}
			currentValue = value;
		}
		return result;

	}

}
