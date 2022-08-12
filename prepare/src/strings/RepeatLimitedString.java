package strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RepeatLimitedString {

	public static void main(String[] args) {
		String s = "cczazcc";
		int repeatLimit = 3;

		System.out.println(solve(s, repeatLimit));

	}

	private static String solve(String s, int repeatLimit) {
		char[] array = s.toCharArray();
		Arrays.sort(array);
		for (int i = 0; i < array.length / 2; i++) {
			char temp = array[i];
			array[i] = array[array.length - i - 1];
			array[array.length - i - 1] = temp;
		}

		Map<Character, Integer> map = new HashMap<>();
		int length = Integer.MIN_VALUE;
		String result = "";

		int start = 0;
		int end = 0;

		while (end < array.length) {
			char current = array[end];
			map.put(current, map.getOrDefault(current, 0) + 1);
			if (map.get(current) > repeatLimit) {
				if (end - start + 1 > length) {
					length = end - start + 1;
					StringBuilder sb = new StringBuilder();
					for (int i = start; i < end; i++) {
						sb.append(array[i]);
					}
					result = sb.toString();
				}
				start = end - repeatLimit + 1;
				map.put(current, map.get(current) - 1);
			}
			end++;
		}
		return result;

	}

}
