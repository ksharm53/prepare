package airport;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DetermineifTwoStringsAreClose {

	public static void main(String[] args) {
		String word1 = "uau";
		String word2 = "ssx";
		System.out.println(solve(word1, word2));

	}

	private static boolean solve(String word1, String word2) {
		Map<Character, Integer> map1 = new HashMap<>();
		for (char arr : word1.toCharArray()) {
			map1.put(arr, map1.getOrDefault(arr, 0) + 1);
		}

		Map<Character, Integer> map2 = new HashMap<>();
		for (char arr : word2.toCharArray()) {
			map2.put(arr, map2.getOrDefault(arr, 0) + 1);
		}

		List<Integer> list1 = new ArrayList<>(map1.values().stream().toList());
		List<Integer> list2 = new ArrayList<>(map2.values().stream().toList());

		Collections.sort(list1);
		Collections.sort(list2);

		System.out.println(list1);
		System.out.println(list2);

		return list1.equals(list2) ? true : false;

	}

}
