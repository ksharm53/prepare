package may1;

import java.util.HashMap;
import java.util.Map;

public class MinSteps {

	public static void main(String[] args) {
		String s = "leetcode";
		String t = "practice";

		System.out.println(solve(s, t));

	}

	private static int solve(String s, String t) {
		Map<Character, Integer> tMap = new HashMap<>();
		Map<Character, Integer> sMap = new HashMap<>();

		int count = 0;

		for (char each : t.toCharArray()) {
			tMap.put(each, tMap.getOrDefault(each, 0) + 1);
		}

		for (char each : s.toCharArray()) {
			sMap.put(each, sMap.getOrDefault(each, 0) + 1);
		}

		for (char each : tMap.keySet()) {
			if (sMap.containsKey(each)) {
				if (sMap.get(each) < tMap.get(each)) {
					count += tMap.get(each) - sMap.get(each);
				}
			} else {
				count += tMap.get(each);
			}
		}

		return count;
	}

}
