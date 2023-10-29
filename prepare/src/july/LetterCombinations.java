package july;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinations {
	static List<String> list;
	static Map<Integer, List<Character>> map;

	public static void main(String[] args) {
		String digits = "246";
		list = new ArrayList<>();
		map = new HashMap<>();

		map.put(2, List.of('a', 'b', 'c'));
		map.put(3, List.of('d', 'e', 'f'));
		map.put(4, List.of('g', 'h', 'i'));
		map.put(5, List.of('j', 'k', 'l'));
		map.put(6, List.of('m', 'n', 'o'));
		map.put(7, List.of('p', 'q', 'r', 's'));
		map.put(8, List.of('t', 'u', 'v'));
		map.put(9, List.of('w', 'x', 'y', 'z'));

		solve(digits, new StringBuilder(), 0);

		System.out.println(list);

	}

	private static void solve(String digits, StringBuilder sb, int idx) {
		if (idx >= digits.length()) {
			if (!sb.isEmpty()) {
				list.add(sb.toString());
			}

			if (!sb.isEmpty()) {
				sb.deleteCharAt(sb.length() - 1);
			}
			return;

		}
		int num = Character.getNumericValue(digits.charAt(idx));
		for (int i = 0; i < map.get(num).size(); i++) {
			solve(digits, sb.append(map.get(num).get(i)), idx + 1);
		}

		if (!sb.isEmpty()) {
			sb.deleteCharAt(sb.length() - 1);
		}
	}

}
