package CodeSignal;

import java.util.HashMap;
import java.util.Map;

public class CodeSignal_StringQuestion {

	public static void main(String[] args) {
		String s1 = "super";
		String s2 = "tower";
		System.out.println(solution(s1, s2));
	}

	public static String solution(String s1, String s2) {
		Map<Character, Integer> map1 = new HashMap<>();
		Map<Character, Integer> map2 = new HashMap<>();

		for (char each : s1.toCharArray()) {
			map1.put(each, map1.getOrDefault(each, 0) + 1);
		}

		for (char each : s2.toCharArray()) {
			map2.put(each, map2.getOrDefault(each, 0) + 1);
		}

		StringBuilder sb = new StringBuilder();
		int s1Pointer = 0;
		int s2Pointer = 0;

		while (s1Pointer < s1.length() && s2Pointer < s2.length()) {
			char s1C = s1.charAt(s1Pointer);
			char s2C = s2.charAt(s2Pointer);

			if (map1.get(s1C) < map2.get(s2C)) {
				sb.append(s1C);
				s1Pointer++;
			} else if (map1.get(s1C) > map2.get(s2C)) {
				sb.append(s2C);
				s2Pointer++;
			} else {
				if (s1C <= s2C) {
					sb.append(s1C);
					s1Pointer++;
				} else {
					sb.append(s2C);
					s2Pointer++;
				}
			}
		}

		while (s1Pointer < s1.length()) {
			sb.append(s1.charAt(s1Pointer));
			s1Pointer++;
		}

		while (s2Pointer < s2.length()) {
			sb.append(s2.charAt(s2Pointer));
			s2Pointer++;
		}

		return sb.toString();
	}

}
