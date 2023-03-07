package feb07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DistinctNames {
	public static Map<Character, Set<Character>> doneList;

	public static void main(String[] args) {
		String[] ideas = { "coffee", "donuts", "time", "toffee" };
		System.out.println(solve(ideas));
	}

	private static int solve(String[] ideas) {
		Map<Character, List<String>> map = new HashMap<>();
		doneList = new HashMap<>();
		String[] clone = Arrays.copyOf(ideas, ideas.length);
		Arrays.sort(clone);
		int count = 0;

		for (String eachString : ideas) {
			List<String> list = map.getOrDefault(eachString.charAt(0), new ArrayList<>());
			list.add(eachString);
			map.put(eachString.charAt(0), map.getOrDefault(eachString.charAt(0), list));
		}

		for (int i = 0; i < ideas.length; i++) {
			String eachString = ideas[i];
			int mile = ideas.length - map.get(eachString.charAt(0)).size();
			for (char alphabet = 'a'; alphabet <= 'z'; alphabet++) {
				if (map.keySet().contains(alphabet) && eachString.charAt(0) != alphabet) {
					StringBuilder sb = new StringBuilder(eachString);
					sb.replace(0, 1, String.valueOf(alphabet));
					if (findString(clone, sb.toString())) {
						mile -= map.get(alphabet).size();
					}
				}
			}
			count += mile;
		}
		return count;
	}

	private static boolean findString(String[] clone, String toFind) {
		int start = 0;
		int end = clone.length - 1;

		while (start <= end) {
			int mid = start + (end - start) / 2;

			if (toFind.equalsIgnoreCase(clone[mid])) {
				return true;
			} else if (clone[mid].compareTo(toFind) < 0) {
				start = mid + 1;
			} else if (clone[mid].compareTo(toFind) > 0) {
				end = mid - 1;
			}
		}
		return false;
	}

}
