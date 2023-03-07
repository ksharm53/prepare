package strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAllAnagramsinaString {

	public static void main(String[] args) {
		String s = "cbaebabacd", p = "abc";
		System.out.println(findAnagrams(s, p));
	}

	public static List<Integer> findAnagrams(String s, String p) {

		int i = 0;
		int j = 0;
		int length = p.length();
		List<Integer> list = new ArrayList<>();

		Map<Character, Integer> map = new HashMap<>();
		for (char eachChar : p.toCharArray()) {
			map.put(eachChar, map.getOrDefault(eachChar, 0) + 1);
		}
		int counter = map.size();

		while (j < s.length()) {
			char eachData = s.charAt(j);

			if (map.containsKey(eachData)) {
				int count = map.get(eachData);
				count--;
				map.put(eachData, count);
				if (count == 0) {
					counter--;
				}

			}

			if (j - i + 1 < length) {
				j++;
			} else if (j - i + 1 == length) {
				if (counter == 0) {
					list.add(i);
				}
				if (map.containsKey(s.charAt(i))) {
					int temp = map.get(s.charAt(i));
					temp++;
					map.put(s.charAt(i), temp);

					if (temp == 1) {
						counter++;
					}
				}
				i++;
				j++;
			}

		}

		return list;
	}

}
