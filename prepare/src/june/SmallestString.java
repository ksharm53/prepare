package june;

import java.util.HashMap;
import java.util.Map;

public class SmallestString {

	public static void main(String[] args) {
		String s = "aab";
		System.out.println(solve(s));

	}

	private static String solve(String s) {
		Map<Character, Integer> map = new HashMap<>();
		for (char eachVal : s.toCharArray()) {
			map.put(eachVal, map.getOrDefault(eachVal, 0) + 1);
		}

		if (map.keySet().size() == 1 && map.keySet().contains('a')) {
			int each = (int) s.charAt(s.length() - 1);

			if (each - 1 < 97) {
				each += 25;
			} else {
				each -= 1;
			}
			StringBuilder sbTemp = new StringBuilder(s);
			sbTemp.deleteCharAt(s.length() - 1);
			sbTemp.insert(s.length() - 1, (char) each);
			return sbTemp.toString();
		}

		int idx = s.indexOf('a');
		while (idx < s.length() && s.charAt(idx) == 'a') {
			idx++;
		}
		idx--;
		StringBuilder sb = null;
		if (idx == 0) {
			sb = new StringBuilder(s.substring(idx + 1, s.length()));
		} else if (idx == -1) {
			sb = new StringBuilder(s);
		} else {
			sb = new StringBuilder(s.substring(0, idx));
		}

		for (int i = 0; i < sb.length(); i++) {
			int each = (int) sb.charAt(i);
			sb.deleteCharAt(i);
			if (each - 1 < 97) {
				each += 25;
			} else {
				each -= 1;
			}
			sb.insert(i, (char) each);
		}

		if (idx == 0) {
			if (sb.length() == 0) {
				int each = (int) s.charAt(0);

				if (each - 1 < 97) {
					each += 25;
				} else {
					each -= 1;
				}
				StringBuilder sbTemp = new StringBuilder(s);
				sbTemp.deleteCharAt(0);
				sbTemp.insert(0, (char) each);
				return sbTemp.toString();
			} else {
				return s.charAt(0) + sb.toString();
			}

		} else if (idx == -1) {
			return sb.toString();
		} else {
			return sb.toString() + s.substring(idx, s.length());
		}
	}

}
