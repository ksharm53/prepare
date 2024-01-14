package oct2023;

import java.util.HashMap;
import java.util.Map;

public class CountCharacters {

	public static void main(String[] args) {
		String[] words = { "skwgxuuuumkfurejmqrbipvlavdrozjyxhagbwetabjwevfsegqfpllgafm", "ufvpzzgpswnk",
				"tcouxmlrnfyoxvkeglchhryykmdvgvdxpookbtiyhuthoqsnqbowewpfgbcy",
				"qwpttmxzazkkfqqtrnkaejifligdvgnyvtmppjbkeuqryxzqyegttvhzolpztvigxygzvsppurijaekb",
				"vbtvbheurzbglzljczmziitkbmtoybiwhoyfrsxvfveaxchebjdzdnnispzwbrgrbcdaistps" };
		String chars = "avyteswqppomeojxoybotzriuvxolmllevluauwb";
		System.out.println(countCharacters(words, chars));

	}

	public static int countCharacters(String[] words, String chars) {
		Map<Character, Integer> map = new HashMap<>();
		for (char each : chars.toCharArray()) {
			map.put(each, map.getOrDefault(each, 0) + 1);
		}
		int size = 0;

		outer: for (String each : words) {
			Map<Character, Integer> tempMap = new HashMap<>(map);
			for (char eachChar : each.toCharArray()) {
				if (!tempMap.containsKey(eachChar)) {
					continue outer;
				}
				tempMap.put(eachChar, tempMap.get(eachChar) - 1);
				if (tempMap.get(eachChar) == 0) {
					tempMap.remove(eachChar);
				}
			}
			size += each.length();
		}

		return size;
	}

}
