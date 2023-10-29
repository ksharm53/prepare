package aug;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetWordsInLongestSubsequence {

	static Map<Integer, List<Integer>> map;

	public static void main(String[] args) {
		int n = 36;
		String[] words = { "a", "s", "g", "ra", "td", "ci", "ct", "u", "ff", "t", "h", "ca", "zf", "y", "p", "tm", "i",
				"wa", "d", "xp", "jf", "q", "hd", "m", "e", "oq", "k", "v", "x", "z", "o", "bk", "c", "n", "l", "j" };
		int[] groups = { 0, 1, 0, 1, 0, 1, 1, 1, 1, 0, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0,
				1, 0, 1, 1 };

		map = new HashMap<>();

		List<Integer> res = solve(n, words, groups, n - 1, new ArrayList<>());
		List<String> val = new ArrayList<>();
		for (int i = res.size() - 1; i >= 0; i--) {
			val.add(words[res.get(i)]);
		}

		System.out.println(val);
	}

	private static List<Integer> solve(int n, String[] words, int[] groups, int sizeWords, List<Integer> ret) {
		if (sizeWords < 0) {
			return ret;
		}

		if (map.containsKey(sizeWords)) {
			return map.get(sizeWords);
		}

		if (ret.size() == 0 || groups[ret.get(ret.size() - 1)] != groups[sizeWords]) {
			ret.add(sizeWords);
			List<Integer> liya = new ArrayList<>(solve(n, words, groups, sizeWords - 1, ret));
			ret.remove(ret.size() - 1);
			List<Integer> naiLiya = new ArrayList<>(solve(n, words, groups, sizeWords - 1, ret));

			map.put(sizeWords, liya.size() >= naiLiya.size() ? liya : naiLiya);
			return map.get(sizeWords);
		}

		map.put(sizeWords, solve(n, words, groups, sizeWords - 1, ret));
		return map.get(sizeWords);

	}

}
