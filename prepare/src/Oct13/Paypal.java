package Oct13;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Paypal {

	public static void main(String[] args) {
		String s = "hackthegame";
		System.out.println(solve(s));

	}

	private static int solve(String s) {
		Map<Character, Integer> map = new HashMap<>();
		int lowest = Integer.MAX_VALUE;
		for (char each : s.toCharArray()) {
			map.put(each, map.getOrDefault(each, 0) + 1);
		}

		for (Entry<Character, Integer> entry : map.entrySet()) {
			if (entry.getValue() == 1) {
				lowest = Math.min(lowest, s.indexOf(entry.getKey()));
			}
		}
		return lowest == Integer.MAX_VALUE ? -1 : lowest + 1;
	}

}
