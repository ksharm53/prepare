package august23;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class SatisfiabilityofEqualityEquations {

	public static void main(String[] args) {
		String[] equations = { "a==b", "e==c", "b==c", "a!=e" };
		System.out.println(solve(equations));

	}

	private static boolean solve(String[] equations) {
		Map<Character, List<Character>> map = new HashMap<>();

		for (String string : equations) {
			if (string.substring(1, 3).equals("==")) {
				List<Character> temp = map.getOrDefault(string.charAt(0), new ArrayList<Character>());
				temp.add(string.charAt(3));
				map.put(string.charAt(0), temp);

				temp = map.getOrDefault(string.charAt(3), new ArrayList<Character>());
				temp.add(string.charAt(0));
				map.put(string.charAt(3), temp);

			}
		}
		for (String string : equations) {
			if (string.substring(1, 3).equals("!=")) {

				if (string.charAt(0) == string.charAt(3)) {
					return false;
				}

				for (Entry<Character, List<Character>> value : map.entrySet()) {
					List<Character> tempList = value.getValue();
					if ((map.containsKey(string.charAt(0)) && map.get(string.charAt(0)).contains(string.charAt(3)))
							|| (tempList.contains(string.charAt(0)) && tempList.contains(string.charAt(3)))) {
						return false;
					}
				}
			}
		}

		return true;
	}

}
