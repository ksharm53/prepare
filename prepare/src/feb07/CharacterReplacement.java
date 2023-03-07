package feb07;

import java.util.HashMap;
import java.util.Map;

public class CharacterReplacement {

	public static void main(String[] args) {
		String s = "ABAB";
		int k = 2;

		System.out.println(solve(s, k));

	}

	private static int solve(String s, int k) {
		int i = 0;
		int j = 0;
		int max = Integer.MIN_VALUE;
		Map<Character, Integer> map = new HashMap<>();
		int maxFrequency = Integer.MIN_VALUE;

		while (j < s.length()) {
			map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
			if (map.get(s.charAt(j)) >= maxFrequency) {
				maxFrequency = map.get(s.charAt(j));
			}

			if ((j - i + 1) - maxFrequency <= k) {
				max = Math.max(max, j - i + 1);
				j++;
			} else {
				map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) - 1);
				i++;
				j++;
			}

		}
		return max;
	}

}
