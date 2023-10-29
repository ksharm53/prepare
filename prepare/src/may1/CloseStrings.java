package may1;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class CloseStrings {

	public static void main(String[] args) {
		String word1 = "cabbba";
		String word2 = "abbccc";

		System.out.println(solve(word1, word2));

	}

	private static boolean solve(String word1, String word2) {

		if (word1.length() != word2.length()) {
			return false;
		}

		Map<Character, Integer> map1 = new TreeMap<>();
		Map<Character, Integer> map2 = new TreeMap<>();

		for (char each : word1.toCharArray()) {
			map1.put(each, map1.getOrDefault(each, 0) + 1);
		}

		for (char each : word2.toCharArray()) {
			map2.put(each, map2.getOrDefault(each, 0) + 1);
		}

		List<Integer> list1 = map1.values().stream().sorted().toList();
		List<Integer> list2 = map2.values().stream().sorted().toList();

		return (list1.equals(list2) && map1.keySet().equals(map2.keySet()));

	}

}
