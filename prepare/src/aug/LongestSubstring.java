package aug;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstring {

	public static void main(String[] args) {
		String s = "bbaaacbd";
		int k = 2;

		System.out.println(solve(s, k));
	}

	private static int solve(String s, int k) {
		int i = 0;
		int j = 0;

		int max = 0;
		Map<Character, Integer> map = new HashMap<>();
		int thresholdCounter = 0;

		while (j < s.length()) {
			map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
			if (map.get(s.charAt(j)) == k) {
				thresholdCounter++;
			}

			if (map.size() == thresholdCounter) {
				max = Math.max(max, j - i + 1);
			}
			j++;

		}
		return max;
	}

}
