package arraysAndStrings;

import java.util.HashMap;
import java.util.Map;

public class OccurenceOfAnagram {

	public static void main(String[] args) {
		String txt = "rtkjprepggxrpnrvystmwcysyycqpevikeffmznimkkas";
		String pat = "vwsrenzk";	

		System.out.println(solve(txt, pat));
	}

	private static int solve(String txt, String pat) {
		int i = 0;
		int j = 0;
		int result = 0;

		int size = pat.length();
		Map<Character, Integer> map = new HashMap<>();
		for (char iterable_element : pat.toCharArray()) {
			map.put(iterable_element, map.getOrDefault(iterable_element, 0) + 1);
		}
		int counter = map.size();

		while (j < txt.length()) {
			if (map.containsKey(txt.charAt(j))) {
				map.put(txt.charAt(j), map.get(txt.charAt(j)) - 1);
				if (map.get(txt.charAt(j)) == 0) {
					counter--;
				}
			}

			if (j - i + 1 < size) {
				j++;
			} else if (j - i + 1 == size) {
				if (counter == 0) {
					result++;
				}
				if (map.containsKey(txt.charAt(i))) {
					map.put(txt.charAt(i), map.get(txt.charAt(i)) + 1);
					if (map.get(txt.charAt(i)) == 1) {
						counter++;
					}
				}
				i++;
				j++;
			}
		}
		return result;
	}
}
