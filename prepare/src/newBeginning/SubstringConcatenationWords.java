package newBeginning;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringConcatenationWords {

	public static void main(String[] args) {
		String s = "a";
		String[] words = { "a" };

		System.out.println(solve(s, words));

	}

	private static List<Integer> solve(String s, String[] words) {
		List<Integer> list = new ArrayList<>();
		
		if (s.length() == 0 || words.length == 0) {
			return new ArrayList<>();
		}
		int totalLength = 0;
		Map<String, Integer> map = new HashMap<>();
		for (String eachWord : words) {
			totalLength += eachWord.length();
			map.put(eachWord, map.getOrDefault(eachWord, 0) + 1);
		}
		int eachWordLength = words[0].length();

		if (s.length() < totalLength) {
			return new ArrayList<>();
		}

		Map<String, Integer> tempMap = new HashMap<>(map);

		outer: for (int k = 0; k < s.length(); k++) {
			if (k + (words.length * eachWordLength) > s.length()) {
				break;
			}
			String subString = s.substring(k, k + (words.length * eachWordLength));
			int i = 0;
			int j = 0;
			StringBuilder sb = new StringBuilder();
			tempMap = new HashMap<>(map);

			while (j < subString.length()) {
				sb.append(subString.charAt(j));
				if (j - i + 1 < eachWordLength) {
					j++;
				} else if (j - i + 1 == eachWordLength) {
					if (tempMap.keySet().contains(sb.toString())) {
						tempMap.put(sb.toString(), tempMap.get(sb.toString()) - 1);
						if (tempMap.get(sb.toString()) == 0) {
							tempMap.remove(sb.toString());
						}
						if (tempMap.size() == 0) {
							list.add(k);
							continue;
						} else {
							j++;
							i = j;
						}
						sb = new StringBuilder();
					} else {
						continue outer;

					}
				}
			}

		}
		return list;

	}

}
