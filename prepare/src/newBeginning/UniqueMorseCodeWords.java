package newBeginning;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueMorseCodeWords {

	static Map<Character, String> map;

	public static void main(String[] args) {
		String[] words = { "gin", "zen", "gig", "msg" };
		map = new HashMap<>();

		map.put('a', ".-");
		map.put('b', "-...");
		map.put('c', "-.-.");
		map.put('d', "-..");
		map.put('e', ".");
		map.put('f', "..-.");
		map.put('g', "--.");
		map.put('h', "....");
		map.put('i', "..");
		map.put('j', ".---");
		map.put('k', "-.-");
		map.put('l', ".-..");
		map.put('m', "--");
		map.put('n', "-.");
		map.put('o', "---");
		map.put('p', ".--.");
		map.put('q', "--.-");
		map.put('r', ".-.");
		map.put('s', "...");
		map.put('t', "-");
		map.put('u', "..-");
		map.put('v', "...-");
		map.put('w', ".--");
		map.put('x', "-..-");
		map.put('y', "-.--");
		map.put('z', "--..");
		System.out.println(solve(words));

	}

	private static int solve(String[] words) {
		Set<String> set = new HashSet<>();
		for (String eachWord : words) {
			StringBuilder sb = new StringBuilder();
			for (char eachChar : eachWord.toCharArray()) {
				sb.append(map.get(eachChar));
			}
			set.add(sb.toString());
		}
		return set.size();
	}

}
