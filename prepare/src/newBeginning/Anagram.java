package newBeginning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Anagram {

	public static void main(String[] args) {
		List<String> val = new ArrayList<>();
		val.add("tea");
		val.add("ate");
		val.add("anagram");
		val.add("eat");
		val.add("gramaan");
		System.out.println(funWithAnagrams(val));

		System.out.println(anagrams(val));

	}

	private static List<String> anagrams(List<String> val) {

		Set<String> set = new HashSet<>();
		List<String> res = new ArrayList<>();
		for (int i = 0; i < val.size(); i++) {
			char[] arr = val.get(i).toCharArray();
			Arrays.sort(arr);

			StringBuilder sb = new StringBuilder();
			sb.append(arr);

			if (!set.contains(sb.toString())) {
				set.add(sb.toString());
				res.add(val.get(i));
			}
		}

		return res;
	}

	public static List<String> funWithAnagrams(List<String> text) {

		List<String> valClone = new ArrayList<>(text);

		Collections.sort(text, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.length() - o2.length();
			}
		});

		// System.out.println(text);

		Map<Integer, List<Map<Character, Integer>>> map = new HashMap<>();

		for (int i = 0; i < text.size(); i++) {
			String eachString = text.get(i);
			if (map.containsKey(eachString.length())) {
				List<Map<Character, Integer>> lis = map.get(eachString.length());
				if (ifPresent(lis, eachString)) {
					valClone.remove(eachString);
				} else {
					Map<Character, Integer> temp = new HashMap<>();
					for (char eachChar : eachString.toCharArray()) {
						temp.put(eachChar, temp.getOrDefault(eachChar, 0) + 1);
					}
					List<Map<Character, Integer>> list = new ArrayList<>();
					list.add(temp);
					map.put(eachString.length(), list);
				}

			} else {
				Map<Character, Integer> temp = new HashMap<>();
				for (char eachChar : eachString.toCharArray()) {
					temp.put(eachChar, temp.getOrDefault(eachChar, 0) + 1);
				}
				List<Map<Character, Integer>> list = new ArrayList<>();
				list.add(temp);
				map.put(eachString.length(), list);
			}
		}
		return valClone;

	}

	public static boolean ifPresent(List<Map<Character, Integer>> list, String val) {
		upper: for (Map<Character, Integer> map : list) {
			Map<Character, Integer> temp = new HashMap<>(map);
			for (char eachChar : val.toCharArray()) {
				if (!temp.containsKey(eachChar)) {
					continue upper;
				} else {
					temp.put(eachChar, temp.getOrDefault(eachChar, 0) - 1);
					if (temp.get(eachChar) <= 0) {
						temp.remove(eachChar);
						if (temp.size() == 0) {
							return true;
						}
					}
				}
			}
		}
		return false;
	}

}
