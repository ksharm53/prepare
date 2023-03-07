package Oct21;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class LongestPalindromebyConcatenatingTwoLetterWords {

	public static void main(String[] args) {
		String[] words = { "ab", "ty", "yt", "lc", "cl", "ab" };
		System.out.println(solve(words));
	}

	private static int solve(String[] words) {
		Map<String, Integer> map = new HashMap<>();
		int val = 0;
		for (String each : words) {
			map.put(each, map.getOrDefault(each, 0) + 1);
		}
		boolean flag = false;
		for (Entry<String, Integer> eachEntry : map.entrySet()) {
			String reverse = new StringBuilder(eachEntry.getKey()).reverse().toString();
			if (!eachEntry.getKey().equals(reverse)) {
				int min = Math.min(eachEntry.getValue(), map.getOrDefault(reverse, 0));
				val += min * 2;
			} else {
				int odd = eachEntry.getValue();
				if (odd % 2 == 0) {
					val += odd * 2;
				} else {
					val += (odd - 1) * 2;
					flag = true;
				}
			}
		}
		if (flag) {
			val += 2;
		}
		return val;
	}

}
