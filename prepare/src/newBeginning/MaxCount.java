package newBeginning;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class MaxCount {

	public static void main(String[] args) {
		String s = "adbcbcbcc";

		System.out.println(solve(s));

	}

	private static int solve(String s) {
		Map<Character, Integer> map = new HashMap<>();
		Map<Character, Integer> innerMap = new HashMap<>();

		int result = Integer.MIN_VALUE;
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < s.length(); i++) {

			innerMap.put(s.charAt(i), innerMap.getOrDefault(s.charAt(i), 0) + 1);
			max = Math.max(max, innerMap.get(s.charAt(i)));

			for (Entry<Character, Integer> eachMapItem : innerMap.entrySet()) {
				if (eachMapItem.getValue() == max) {
					map.put(eachMapItem.getKey(), map.getOrDefault(eachMapItem.getKey(), 0) + 1);
				}
			}
		}

		for (Integer eachValue : map.values()) {
			result = Math.max(result, eachValue);
		}
		return result;
	}

}
