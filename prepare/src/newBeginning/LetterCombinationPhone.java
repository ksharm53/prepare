package newBeginning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationPhone {

	public static void main(String[] args) {
		String digits = "2";
		System.out.println(solve(digits));

	}

	public static List<String> solve(String digits) {
		List<String> list = new ArrayList<>();

		if (digits.length() == 0) {
			return list;
		}

		Map<Character, List<Character>> map = new HashMap<>();
		map.put('2', Arrays.asList('a', 'b', 'c'));
		map.put('3', Arrays.asList('d', 'e', 'f'));
		map.put('4', Arrays.asList('g', 'h', 'i'));
		map.put('5', Arrays.asList('j', 'k', 'l'));
		map.put('6', Arrays.asList('m', 'n', 'o'));
		map.put('7', Arrays.asList('p', 'q', 'r', 's'));
		map.put('8', Arrays.asList('t', 'u', 'v'));
		map.put('9', Arrays.asList('w', 'x', 'y', 'z'));

		for (char eachChar : map.get(digits.charAt(0))) {
			list.add(String.valueOf(eachChar));
		}

		for (int i = 1; i < digits.length(); i++) {
			char eachCharacter = digits.charAt(i);
			List<String> tempList = new ArrayList<>();
			List<Character> listChar = map.get(eachCharacter);
			for (int k = 0; k < list.size(); k++) {
				for (int j = 0; j < listChar.size(); j++) {
					StringBuilder sb = new StringBuilder();
					sb.append(list.get(k));
					sb.append(listChar.get(j));
					tempList.add(sb.toString());
				}
			}
			list = new ArrayList<>(tempList);
		}
		return list;

	}

}
